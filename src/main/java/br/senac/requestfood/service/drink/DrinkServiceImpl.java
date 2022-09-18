package br.senac.requestfood.service.drink;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.senac.requestfood.dto.drink.DrinkDTO;
import br.senac.requestfood.enumeration.drink.CategoryDrink;
import br.senac.requestfood.exception.consumable.ConsumableNameRegisteredException;
import br.senac.requestfood.exception.consumable.ConsumableNotFoundException;
import br.senac.requestfood.mapper.drink.DrinkMapper;
import br.senac.requestfood.model.consumable.drink.Drink;
import br.senac.requestfood.projection.drink.DrinkProjection;
import br.senac.requestfood.repository.drink.DrinkRepository;

@Service
public class DrinkServiceImpl implements DrinkService{

	private final DrinkRepository repository;
	private final DrinkMapper mapper;

	public DrinkServiceImpl(DrinkRepository repository, DrinkMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}
	
	public DrinkDTO save(DrinkDTO drinkDTO) {

		if (repository.existsByName(drinkDTO.name()))
			throw new ConsumableNameRegisteredException("Drink " + drinkDTO.name() + " is already registered");

		Drink drink = mapper.toEntity(drinkDTO);
		Drink drinkSaved = repository.save(drink);

		return mapper.toDTO(drinkSaved);
	}

	public void update(DrinkDTO drinkDTO, Long id) {

		Drink drink = repository.findById(id).orElseThrow(() -> new ConsumableNotFoundException("Drink " + id + " was not found"));

		if (!repository.existsByName(drinkDTO.name()))
			throw new ConsumableNameRegisteredException("Drink " + drinkDTO.name() + " is already registered");

		drink.setName(drinkDTO.name());
		drink.setPrice(drinkDTO.price());

		repository.save(drink);
	}

	public void delete(Long id) {

		if (!repository.existsById(id))
			throw new ConsumableNotFoundException("Drink " + id + " was not found");

			repository.deleteById(id);
	}

	public DrinkProjection findById(Long id) {
		DrinkProjection bebida = repository.findDrinkById(id).orElseThrow(() -> new ConsumableNotFoundException("Drink " + id + " was not found"));
		return bebida;
	}

	public Page<DrinkProjection> findByName(String name, Pageable pageable) {
		return repository.findByNameContainingIgnoreCase(name, pageable);
	}
	
	public Page<DrinkProjection> findByPriceByOrdemByAsc(Pageable pageable, Integer page) {
		int size = 4;
		
		pageable = PageRequest.of(page,size, Sort.Direction.ASC, "price");
		return repository.findDrinks(pageable);
	}
	
	public Page<DrinkProjection> findByPriceByOrdemByDesc(Pageable pageable, Integer page) {
		int size = 4;
		
		pageable = PageRequest.of(page,size, Sort.Direction.DESC, "price");
		return repository.findDrinks(pageable);
	}
	
	public Page<DrinkProjection> findAll(Pageable pageable, Integer page) {
		int size = 4;
		
		pageable = PageRequest.of(page,size);
		return repository.findDrinks(pageable);
	}
	
	public List<DrinkProjection> findAll() {
		return repository.findDrinks();
	}
	
	public Page<DrinkProjection> findByCategoryDrink(CategoryDrink categoryDrink, Pageable pageable) {
		int size = 4;
		int page = 0;
		
		pageable = PageRequest.of(page,size);
		
		return repository.findDrinkByCategoryDrink(pageable, categoryDrink);
	}

	public Page<DrinkProjection> findByAlcoholic(Pageable pageable, Boolean alcoholic) {
		int size = 4;
		int page = 0;
		
		pageable = PageRequest.of(page, size);
		
		return repository.findDrinkByAlcoholic(pageable, alcoholic);
	}

}

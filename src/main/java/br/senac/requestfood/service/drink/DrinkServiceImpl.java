package br.senac.requestfood.service.drink;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.senac.requestfood.dto.drink.DrinkDTO;
import br.senac.requestfood.dto.establishment.EstablishmentWithConsumablesDTO;
import br.senac.requestfood.enumeration.drink.CategoryDrink;
import br.senac.requestfood.exception.consumable.ConsumableNotFoundException;
import br.senac.requestfood.exception.establishment.EstablishmentNotFoundException;
import br.senac.requestfood.mapper.drink.DrinkMapper;
import br.senac.requestfood.model.consumable.drink.Drink;
import br.senac.requestfood.projection.drink.DrinkProjection;
import br.senac.requestfood.projection.establishment.EstablishmentProjection;
import br.senac.requestfood.repository.drink.DrinkRepository;
import br.senac.requestfood.repository.establisment.EstablishmentRepository;

@Service
public class DrinkServiceImpl implements DrinkService{

	private final DrinkRepository repository;
	private final EstablishmentRepository establishmentRepository;
	private final DrinkMapper mapper;

	public DrinkServiceImpl(DrinkRepository repository, DrinkMapper mapper, EstablishmentRepository establishmentRepository) {
		this.repository = repository;
		this.mapper = mapper;
		this.establishmentRepository = establishmentRepository;
	}
	
	public DrinkDTO save(DrinkDTO drinkDTO) {

		Drink drink = mapper.toEntity(drinkDTO);
		Drink drinkSaved = repository.save(drink);

		return mapper.toDTO(drinkSaved);
	}

	public void update(DrinkDTO drinkDTO, Long id) {

		Drink drink = repository.findById(id).orElseThrow(() -> new ConsumableNotFoundException("Drink " + id + " was not found"));

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

	public EstablishmentWithConsumablesDTO findByName(Long id, String name, Integer page, Pageable pageable) {
		
		int size = 4;
		pageable = PageRequest.of(page,size, Sort.Direction.ASC, "name");

		EstablishmentProjection establishment = establishmentRepository.findEstablishmentById(id).orElseThrow(() -> new EstablishmentNotFoundException("Establishment " + id + " was not found"));
		return new EstablishmentWithConsumablesDTO(establishment.getId(), establishment.getName(), repository.findByNameContainingIgnoreCase(name, pageable));
	}
	
	public EstablishmentWithConsumablesDTO findByPriceByOrdemByAsc(Long id, Integer page, Pageable pageable) {
		
		int size = 4;
		pageable = PageRequest.of(page,size, Sort.Direction.ASC, "price");
		
		EstablishmentProjection establishment = establishmentRepository.findEstablishmentById(id).orElseThrow(() -> new EstablishmentNotFoundException("Establishment " + id + " was not found"));
		return  new EstablishmentWithConsumablesDTO(establishment.getId(), establishment.getName(), repository.findDrinks(pageable));
	}
	
	public EstablishmentWithConsumablesDTO findByPriceByOrdemByDesc(Long id, Integer page, Pageable pageable) {
		
		int size = 4;
		pageable = PageRequest.of(page,size, Sort.Direction.DESC, "price");

		EstablishmentProjection establishment = establishmentRepository.findEstablishmentById(id).orElseThrow(() -> new EstablishmentNotFoundException("Establishment " + id + " was not found"));
		return  new EstablishmentWithConsumablesDTO(establishment.getId(), establishment.getName(), repository.findDrinks(pageable));
	}
	
	public EstablishmentWithConsumablesDTO findAll(Long id, Integer page, Pageable pageable) {
		
		int size = 4;
		pageable = PageRequest.of(page,size, Sort.Direction.ASC, "name");

		EstablishmentProjection establishment = establishmentRepository.findEstablishmentById(id).orElseThrow(() -> new EstablishmentNotFoundException("Establishment " + id + " was not found"));
		return  new EstablishmentWithConsumablesDTO(establishment.getId(), establishment.getName(), repository.findDrinks(pageable));	}
	
	
	public EstablishmentWithConsumablesDTO findByCategoryDrink(Long id, CategoryDrink categoryDrink, Integer page, Pageable pageable) {

		int size = 4;
		pageable = PageRequest.of(page,size, Sort.Direction.ASC, "name");

		EstablishmentProjection establishment = establishmentRepository.findEstablishmentById(id).orElseThrow(() -> new EstablishmentNotFoundException("Establishment " + id + " was not found"));		
		return new EstablishmentWithConsumablesDTO(establishment.getId(), establishment.getName(), repository.findDrinkByCategoryDrink(pageable, categoryDrink));
	}

	public EstablishmentWithConsumablesDTO findByAlcoholic(Long id, Boolean alcoholic, Integer page, Pageable pageable) {
		
		int size = 4;
		pageable = PageRequest.of(page,size, Sort.Direction.ASC, "name");

		EstablishmentProjection establishment = establishmentRepository.findEstablishmentById(id).orElseThrow(() -> new EstablishmentNotFoundException("Establishment " + id + " was not found"));		
		return new EstablishmentWithConsumablesDTO(establishment.getId(), establishment.getName(), repository.findDrinkByAlcoholic(pageable, alcoholic));
	}

	public List<DrinkProjection> findAll() {
		return repository.findDrinks();
	}
}

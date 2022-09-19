package br.senac.requestfood.service.drink;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.senac.requestfood.dto.consumable.ConsumableCardDTO;
import br.senac.requestfood.dto.drink.DrinkDTO;
import br.senac.requestfood.dto.establishment.EstablishmentWithConsumablesDTO;
import br.senac.requestfood.enumeration.drink.CategoryDrink;
import br.senac.requestfood.exception.consumable.ConsumableNameRegisteredException;
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

	public EstablishmentWithConsumablesDTO findByName(String name, Long id) {
		
		Pageable pageable = PageRequest.of(0,Integer.MAX_VALUE, Sort.Direction.ASC, "name");
		
		Page<DrinkProjection> drinks = repository.findByNameContainingIgnoreCase(name, pageable);
		List<ConsumableCardDTO> drinksCard = new ArrayList<>();
		
		EstablishmentProjection establishment = establishmentRepository.findEstablishmentById(id).orElseThrow(() -> new EstablishmentNotFoundException("Establishment " + id + " was not found"));
		
		for (DrinkProjection drinkProjection : drinks) {
			drinksCard.add(new ConsumableCardDTO(drinkProjection.getId(), drinkProjection.getImage(), drinkProjection.getName(), drinkProjection.getPrice(), drinkProjection.getDescription()));
		}
		
		
		return new EstablishmentWithConsumablesDTO(establishment.getId(), establishment.getName(), drinksCard);
	}
	
	public EstablishmentWithConsumablesDTO findByPriceByOrdemByAsc(Long id) {
		
		Pageable pageable = PageRequest.of(0,Integer.MAX_VALUE, Sort.Direction.ASC, "price");
		
		Page<DrinkProjection> drinks = repository.findDrinks(pageable);
		List<ConsumableCardDTO> drinksCard = new ArrayList<>();
		
		EstablishmentProjection establishment = establishmentRepository.findEstablishmentById(id).orElseThrow(() -> new EstablishmentNotFoundException("Establishment " + id + " was not found"));
		
		for (DrinkProjection drinkProjection : drinks) {
			drinksCard.add(new ConsumableCardDTO(drinkProjection.getId(), drinkProjection.getImage(), drinkProjection.getName(), drinkProjection.getPrice(), drinkProjection.getDescription()));
		}
		
		
		return new EstablishmentWithConsumablesDTO(establishment.getId(), establishment.getName(), drinksCard);
	}
	
	public EstablishmentWithConsumablesDTO findByPriceByOrdemByDesc(Long id) {

		Pageable pageable = PageRequest.of(0,Integer.MAX_VALUE, Sort.Direction.DESC, "price");
		
		Page<DrinkProjection> drinks = repository.findDrinks(pageable);
		List<ConsumableCardDTO> drinksCard = new ArrayList<>();
		
		EstablishmentProjection establishment = establishmentRepository.findEstablishmentById(id).orElseThrow(() -> new EstablishmentNotFoundException("Establishment " + id + " was not found"));
		
		for (DrinkProjection drinkProjection : drinks) {
			drinksCard.add(new ConsumableCardDTO(drinkProjection.getId(), drinkProjection.getImage(), drinkProjection.getName(), drinkProjection.getPrice(), drinkProjection.getDescription()));
		}
		
		return new EstablishmentWithConsumablesDTO(establishment.getId(), establishment.getName(), drinksCard);
	}
	
	public EstablishmentWithConsumablesDTO findAll(Long id) {
		
		Pageable pageable = PageRequest.of(0,Integer.MAX_VALUE, Sort.Direction.ASC, "name");
		
		Page<DrinkProjection> drinks = repository.findDrinks(pageable);
		List<ConsumableCardDTO> drinksCard = new ArrayList<>();
		
		EstablishmentProjection establishment = establishmentRepository.findEstablishmentById(id).orElseThrow(() -> new EstablishmentNotFoundException("Establishment " + id + " was not found"));
		
		for (DrinkProjection drinkProjection : drinks) {
			drinksCard.add(new ConsumableCardDTO(drinkProjection.getId(), drinkProjection.getImage(), drinkProjection.getName(), drinkProjection.getPrice(), drinkProjection.getDescription()));
		}
		
		return new EstablishmentWithConsumablesDTO(establishment.getId(), establishment.getName(), drinksCard);
	}
	
	
	public EstablishmentWithConsumablesDTO findByCategoryDrink(CategoryDrink categoryDrink, Long id) {

		Pageable pageable = PageRequest.of(0,Integer.MAX_VALUE, Sort.Direction.ASC, "name");
		
		Page<DrinkProjection> drinks = repository.findDrinkByCategoryDrink(pageable, categoryDrink);
		List<ConsumableCardDTO> drinksCard = new ArrayList<>();
		
		EstablishmentProjection establishment = establishmentRepository.findEstablishmentById(id).orElseThrow(() -> new EstablishmentNotFoundException("Establishment " + id + " was not found"));
		
		for (DrinkProjection drinkProjection : drinks) {
			drinksCard.add(new ConsumableCardDTO(drinkProjection.getId(), drinkProjection.getImage(), drinkProjection.getName(), drinkProjection.getPrice(), drinkProjection.getDescription()));
		}
		
		return new EstablishmentWithConsumablesDTO(establishment.getId(), establishment.getName(), drinksCard);
	}

	public EstablishmentWithConsumablesDTO findByAlcoholic(Boolean alcoholic, Long id) {
		
		Pageable pageable = PageRequest.of(0,Integer.MAX_VALUE, Sort.Direction.ASC, "name");
		
		Page<DrinkProjection> drinks = repository.findDrinkByAlcoholic(pageable, alcoholic);
		List<ConsumableCardDTO> drinksCard = new ArrayList<>();
		
		EstablishmentProjection establishment = establishmentRepository.findEstablishmentById(id).orElseThrow(() -> new EstablishmentNotFoundException("Establishment " + id + " was not found"));
		
		for (DrinkProjection drinkProjection : drinks) {
			drinksCard.add(new ConsumableCardDTO(drinkProjection.getId(), drinkProjection.getImage(), drinkProjection.getName(), drinkProjection.getPrice(), drinkProjection.getDescription()));
		}
		
		return new EstablishmentWithConsumablesDTO(establishment.getId(), establishment.getName(), drinksCard);
	}

	public List<DrinkProjection> findAll() {
		return repository.findDrinks();
	}
}

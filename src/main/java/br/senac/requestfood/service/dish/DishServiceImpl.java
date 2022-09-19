package br.senac.requestfood.service.dish;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.senac.requestfood.dto.consumable.ConsumableCardDTO;
import br.senac.requestfood.dto.dish.DishDTO;
import br.senac.requestfood.dto.establishment.EstablishmentWithConsumablesDTO;
import br.senac.requestfood.enumeration.dish.CategoryDish;
import br.senac.requestfood.exception.consumable.ConsumableNameRegisteredException;
import br.senac.requestfood.exception.consumable.ConsumableNotFoundException;
import br.senac.requestfood.exception.establishment.EstablishmentNotFoundException;
import br.senac.requestfood.mapper.dish.DishMapper;
import br.senac.requestfood.model.consumable.dish.Dish;
import br.senac.requestfood.projection.dish.DishProjection;
import br.senac.requestfood.projection.establishment.EstablishmentProjection;
import br.senac.requestfood.repository.dish.DishRepository;
import br.senac.requestfood.repository.establisment.EstablishmentRepository;

@Service
public class DishServiceImpl implements DishService{

	private final DishRepository repository;
	private final EstablishmentRepository establishmentRepository;
	private final DishMapper mapper;

	
	public DishServiceImpl(DishRepository repository, DishMapper mapper, EstablishmentRepository establishmentRepository) {
		this.repository = repository;
		this.mapper = mapper;
		this.establishmentRepository = establishmentRepository;
	}

	public DishDTO save(DishDTO dishDTO) {
	
		if (repository.existsByName(dishDTO.name()))
			throw new ConsumableNameRegisteredException("Prato " + dishDTO.name() + " is already registered");
		
		Dish dish = mapper.toEntity(dishDTO);
		Dish dishSaved = repository.save(dish);

		return mapper.toDTO(dishSaved);
	}

	public void update(DishDTO dishDTO, Long id) {
		
		Dish dish = repository.findById(id).orElseThrow(() -> new ConsumableNotFoundException("Dish " + id + " was not found"));

		if (!repository.existsByName(dishDTO.name()))
			throw new ConsumableNameRegisteredException("Dish " + dishDTO.name() + " is already registered");

		dish.setName(dishDTO.name());
		dish.setPrice(dishDTO.price());

		repository.save(dish);
	}

	public void delete(Long id) {

		if (!repository.existsById(id))
			throw new ConsumableNotFoundException("Dish " + id + " was not found");

			repository.deleteById(id);
	}

	public DishProjection findById(Long id) {
		DishProjection dish = repository.findDishById(id).orElseThrow(() -> new ConsumableNotFoundException("Dish " + id + " was not found"));
		return dish;
	}
	
	public EstablishmentWithConsumablesDTO findByName(String name, Long id) {
		
		Pageable pageable = PageRequest.of(0,Integer.MAX_VALUE, Sort.Direction.ASC, "name");
		Page<DishProjection> dishes = repository.findByNameContainingIgnoreCase(pageable ,name);
		List<ConsumableCardDTO> dishesCard = new ArrayList<>();
		
		EstablishmentProjection establishment = establishmentRepository.findEstablishmentById(id).orElseThrow(() -> new EstablishmentNotFoundException("Establishment " + id + " was not found"));
		
		for (DishProjection dishProjection : dishes) {
			dishesCard.add(new ConsumableCardDTO(dishProjection.getId(), dishProjection.getImage(), dishProjection.getName(), dishProjection.getPrice(), dishProjection.getDescription()));
		}
		
		
		return new EstablishmentWithConsumablesDTO(establishment.getId(), establishment.getName(), dishesCard);
	}
	
	public EstablishmentWithConsumablesDTO  findByPriceByOrdemByAsc(Long id) {
		
		Pageable pageable = PageRequest.of(0,Integer.MAX_VALUE, Sort.Direction.ASC, "price");
		Page<DishProjection> dishes = repository.findDishes(pageable);
		
		List<ConsumableCardDTO> dishesCard = new ArrayList<>();
		
		EstablishmentProjection establishment = establishmentRepository.findEstablishmentById(id).orElseThrow(() -> new EstablishmentNotFoundException("Establishment " + id + " was not found"));
		
		for (DishProjection dishProjection : dishes) {
			dishesCard.add(new ConsumableCardDTO(dishProjection.getId(), dishProjection.getImage(), dishProjection.getName(), dishProjection.getPrice(), dishProjection.getDescription()));
		}
		return new EstablishmentWithConsumablesDTO(establishment.getId(), establishment.getName(), dishesCard);
	}
	
	public EstablishmentWithConsumablesDTO findByPriceByOrdemByDesc(Long id) {
		
		Pageable pageable = PageRequest.of(0,Integer.MAX_VALUE, Sort.Direction.DESC, "price");
		Page<DishProjection> dishes = repository.findDishes(pageable);
		
		List<ConsumableCardDTO> dishesCard = new ArrayList<>();
		
		EstablishmentProjection establishment = establishmentRepository.findEstablishmentById(id).orElseThrow(() -> new EstablishmentNotFoundException("Establishment " + id + " was not found"));
		
		for (DishProjection dishProjection : dishes) {
			dishesCard.add(new ConsumableCardDTO(dishProjection.getId(), dishProjection.getImage(), dishProjection.getName(), dishProjection.getPrice(), dishProjection.getDescription()));
		}
		return new EstablishmentWithConsumablesDTO(establishment.getId(), establishment.getName(), dishesCard);
	}
	
	public EstablishmentWithConsumablesDTO findAll(Long id) {
		
		Pageable pageable = PageRequest.of(0,Integer.MAX_VALUE, Sort.Direction.ASC, "name");
		Page<DishProjection> dishes = repository.findDishes(pageable);
		
		List<ConsumableCardDTO> dishesCard = new ArrayList<>();
		
		EstablishmentProjection establishment = establishmentRepository.findEstablishmentById(id).orElseThrow(() -> new EstablishmentNotFoundException("Establishment " + id + " was not found"));
		
		for (DishProjection dishProjection : dishes) {
			dishesCard.add(new ConsumableCardDTO(dishProjection.getId(), dishProjection.getImage(), dishProjection.getName(), dishProjection.getPrice(), dishProjection.getDescription()));
		}
		return new EstablishmentWithConsumablesDTO(establishment.getId(), establishment.getName(), dishesCard);
	}

	public EstablishmentWithConsumablesDTO findByTypeDish(CategoryDish typeDish, Long id) {
		
		Pageable pageable = PageRequest.of(0,Integer.MAX_VALUE, Sort.Direction.ASC, "name");
		Page<DishProjection> dishes = repository.findDishByTypeDish(pageable, typeDish);
		
		List<ConsumableCardDTO> dishesCard = new ArrayList<>();
		
		EstablishmentProjection establishment = establishmentRepository.findEstablishmentById(id).orElseThrow(() -> new EstablishmentNotFoundException("Establishment " + id + " was not found"));
		
		for (DishProjection dishProjection : dishes) {
			dishesCard.add(new ConsumableCardDTO(dishProjection.getId(), dishProjection.getImage(), dishProjection.getName(), dishProjection.getPrice(), dishProjection.getDescription()));
		}
		return new EstablishmentWithConsumablesDTO(establishment.getId(), establishment.getName(), dishesCard);
	}

}
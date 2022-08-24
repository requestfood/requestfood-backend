package br.senac.requestfood.service.dish;

import java.util.List;

import org.springframework.stereotype.Service;

import br.senac.requestfood.dto.dish.DishDTO;
import br.senac.requestfood.exception.consumable.ConsumableNameRegisteredException;
import br.senac.requestfood.exception.consumable.ConsumableNotFoundException;
import br.senac.requestfood.mapper.dish.DishMapper;
import br.senac.requestfood.model.consumable.dish.Dish;
import br.senac.requestfood.projection.dish.DishProjection;
import br.senac.requestfood.repository.dish.DishRepository;

@Service
public class DishServiceImpl implements DishService{

	private final DishRepository repository;
	private final DishMapper mapper;
	
	public DishServiceImpl(DishRepository repository, DishMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
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
		dish.setEstablishment(dishDTO.establishment());
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

	public List<DishProjection> findAll() {
		return repository.findDishes();
	}
}

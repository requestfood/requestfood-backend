package br.senac.requestfood.service.dish;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.senac.requestfood.dto.dish.DishDTO;
import br.senac.requestfood.dto.establishment.EstablishmentWithConsumablesDTO;
import br.senac.requestfood.enumeration.dish.CategoryDish;
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
	
		Dish dish = mapper.toEntity(dishDTO);
		Dish dishSaved = repository.save(dish);

		return mapper.toDTO(dishSaved);
	}

	public void update(DishDTO dishDTO, Long id) {
		
		Dish dish = repository.findById(id).orElseThrow(() -> new ConsumableNotFoundException("Dish " + id + " was not found"));

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
	
	public EstablishmentWithConsumablesDTO findByName(Long id, String name, Integer page, Pageable pageable) {
		
		int size = 4;
		pageable = PageRequest.of(page,size, Sort.Direction.ASC, "name");
		
		EstablishmentProjection establishment = establishmentRepository.findEstablishmentById(id).orElseThrow(() -> new EstablishmentNotFoundException("Establishment " + id + " was not found"));
		return new EstablishmentWithConsumablesDTO(establishment.getId(), establishment.getName(), repository.findByNameContainingIgnoreCaseAndEstablishmentId(name, id, pageable));
	}
	
	public EstablishmentWithConsumablesDTO findByPriceByOrdemByAsc(Long id, Integer page, Pageable pageable) {
		
		int size = 4;
		pageable = PageRequest.of(page,size, Sort.Direction.ASC, "price");
		
		EstablishmentProjection establishment = establishmentRepository.findEstablishmentById(id).orElseThrow(() -> new EstablishmentNotFoundException("Establishment " + id + " was not found"));
		return new EstablishmentWithConsumablesDTO(establishment.getId(), establishment.getName(), repository.findDishesByEstablishmentId(id, pageable));
	}
	
	public EstablishmentWithConsumablesDTO findByPriceByOrdemByDesc(Long id, Integer page, Pageable pageable) {
		
		int size = 4;
		pageable = PageRequest.of(page,size, Sort.Direction.DESC, "price");
		
		EstablishmentProjection establishment = establishmentRepository.findEstablishmentById(id).orElseThrow(() -> new EstablishmentNotFoundException("Establishment " + id + " was not found"));
		return new EstablishmentWithConsumablesDTO(establishment.getId(), establishment.getName(), repository.findDishesByEstablishmentId(id, pageable));
	}
	
	public EstablishmentWithConsumablesDTO findAll(Long id, Integer page, Pageable pageable) {
		
		int size = 4;
		pageable = PageRequest.of(page,size, Sort.Direction.ASC, "name");
		
		EstablishmentProjection establishment = establishmentRepository.findEstablishmentById(id).orElseThrow(() -> new EstablishmentNotFoundException("Establishment " + id + " was not found"));
		return new EstablishmentWithConsumablesDTO(establishment.getId(), establishment.getName(), repository.findDishesByEstablishmentId(id, pageable));
	}

	public EstablishmentWithConsumablesDTO findByTypeDish(Long id, CategoryDish typeDish, Integer page, Pageable pageable) {

		int size = 4;
		pageable = PageRequest.of(page, size, Sort.Direction.ASC, "name");
		
		EstablishmentProjection establishment = establishmentRepository.findEstablishmentById(id).orElseThrow(() -> new EstablishmentNotFoundException("Establishment " + id + " was not found"));
		return new EstablishmentWithConsumablesDTO(establishment.getId(), establishment.getName(), repository.findDishByTypeDishAndEstablishmentId(typeDish, id, pageable));
	}
}
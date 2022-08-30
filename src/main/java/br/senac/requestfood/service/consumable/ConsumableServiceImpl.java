package br.senac.requestfood.service.consumable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.senac.requestfood.exception.consumable.ConsumableNotFoundException;
import br.senac.requestfood.mapper.dish.DishMapper;
import br.senac.requestfood.mapper.drink.DrinkMapper;
import br.senac.requestfood.projection.consumable.ConsumableProjection;
import br.senac.requestfood.repository.consumable.ConsumableRepository;

@Service
public class ConsumableServiceImpl implements ConsumableService{

	private final ConsumableRepository repository;
	private final DishMapper dishMapper;
	private final DrinkMapper drinkMapper;
	
	public ConsumableServiceImpl(ConsumableRepository repository, DishMapper dishMapper, DrinkMapper drinkMapper) {
		this.repository = repository;
		this.dishMapper = dishMapper;
		this.drinkMapper = drinkMapper;
	}

	public ConsumableProjection findById(Long id) {
		
		ConsumableProjection consumable = repository.findConsumableById(id).orElseThrow(() -> new ConsumableNotFoundException("Consumable "+ id +" was not found."));
		
		return consumable;
	}
	
	public Page<ConsumableProjection> findByName(String name, Pageable pageable) {
		return repository.findByNameContainingIgnoreCase(name, pageable);
	}

	public Page<ConsumableProjection> findAll(Pageable pageable) {
		return repository.findConsumables(pageable);
	}


	
}

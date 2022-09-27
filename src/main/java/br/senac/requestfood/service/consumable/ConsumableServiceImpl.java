package br.senac.requestfood.service.consumable;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.senac.requestfood.exception.consumable.ConsumableNotFoundException;
import br.senac.requestfood.mapper.dish.DishMapper;
import br.senac.requestfood.mapper.drink.DrinkMapper;
import br.senac.requestfood.projection.consumable.ConsumableProjection;
import br.senac.requestfood.repository.consumable.ConsumableRepository;
import br.senac.requestfood.repository.dish.DishRepository;
import br.senac.requestfood.repository.drink.DrinkRepository;

@Service
public class ConsumableServiceImpl implements ConsumableService{

	private final ConsumableRepository repository;
	
	public ConsumableServiceImpl(ConsumableRepository repository, DishRepository dishRepository, DrinkRepository drinkRepository, DishMapper dishMapper, DrinkMapper drinkMapper) {
		this.repository = repository;
	}

	public ConsumableProjection findById(Long id) {
		
		ConsumableProjection consumable = repository.findConsumableById(id).orElseThrow(() -> new ConsumableNotFoundException("Consumable "+ id +" was not found."));
		
		return consumable;
	}
	
	public Page<ConsumableProjection> findByName(String name, Integer page,Pageable pageable) {
		int size = 4;
		
		pageable = PageRequest.of(page,size, Sort.Direction.ASC, "name");
		return repository.findByNameContainingIgnoreCase(name, pageable);
	}

	public Page<ConsumableProjection> findByPriceByOrdemByAsc(Pageable pageable, Integer page) {
		int size = 4;
		
		pageable = PageRequest.of(page,size, Sort.Direction.ASC, "price");
		return repository.findConsumables(pageable);
	}
	
	public Page<ConsumableProjection> findByPriceByOrdemByDesc(Pageable pageable, Integer page) {
		int size = 4;
		
		pageable = PageRequest.of(page,size, Sort.Direction.DESC, "price");
		return repository.findConsumables(pageable);
	}
	
	public Page<ConsumableProjection> findAll(Pageable pageable, Integer page) {
		int size = 4;
		
		pageable = PageRequest.of(page,size, Sort.Direction.ASC, "name");
		return repository.findConsumables(pageable);
	}
	
	public List<ConsumableProjection> findAll() {
		return repository.findConsumables();
	}
}

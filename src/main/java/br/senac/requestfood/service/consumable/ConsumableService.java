package br.senac.requestfood.service.consumable;

import java.util.List;

import br.senac.requestfood.projection.consumable.ConsumableProjection;

public interface ConsumableService {
	
	ConsumableProjection findById(Long id);
	
	List<ConsumableProjection> findByName(String name);
	
	List<ConsumableProjection> findAll();

}

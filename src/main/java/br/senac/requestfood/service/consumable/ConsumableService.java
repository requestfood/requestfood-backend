package br.senac.requestfood.service.consumable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.senac.requestfood.projection.consumable.ConsumableProjection;

public interface ConsumableService {
	
	ConsumableProjection findById(Long id);
	
	Page<ConsumableProjection> findByName(String name, Pageable pageable);
	
	Page<ConsumableProjection> findAll(Pageable pageable);

}

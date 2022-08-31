package br.senac.requestfood.service.consumable;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.senac.requestfood.projection.consumable.ConsumableProjection;

public interface ConsumableService {
	
	ConsumableProjection findById(Long id);
	
	Page<ConsumableProjection> findByName(String name, Pageable pageable);
	
	Page<ConsumableProjection> findByPriceByOrdemByAsc(Pageable pageable, Integer page);
	
	Page<ConsumableProjection> findByPriceByOrdemByDesc(Pageable pageable, Integer page);
	
	Page<ConsumableProjection> findAll(Pageable pageable, Integer page);

	List<ConsumableProjection> findAll();
}

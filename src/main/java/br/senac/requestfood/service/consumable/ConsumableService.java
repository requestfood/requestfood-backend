package br.senac.requestfood.service.consumable;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.senac.requestfood.dto.consumable.ConsumableCardDTO;
import br.senac.requestfood.projection.consumable.ConsumableProjection;

public interface ConsumableService {
	
	ConsumableProjection findById(Long id);
	
	Page<ConsumableCardDTO> findByName(String name, Integer page,Pageable pageable);
	
	Page<ConsumableCardDTO> findByPriceByOrdemByAsc(Pageable pageable, Integer page);
	
	Page<ConsumableCardDTO> findByPriceByOrdemByDesc(Pageable pageable, Integer page);
	
	Page<ConsumableCardDTO> findAll(Pageable pageable, Integer page);

	List<ConsumableProjection> findAll();
}

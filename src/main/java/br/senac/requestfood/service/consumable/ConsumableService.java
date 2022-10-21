package br.senac.requestfood.service.consumable;

import java.util.List;

import org.springframework.data.domain.Pageable;

import br.senac.requestfood.dto.consumable.ConsumableImageDTO;
import br.senac.requestfood.dto.consumable.ConsumableRoleDTO;
import br.senac.requestfood.dto.establishment.EstablishmentWithConsumablesDTO;
import br.senac.requestfood.projection.consumable.ConsumableProjection;

public interface ConsumableService {
	
	void delete(Long id);
	
	ConsumableProjection findById(Long id);
	
	ConsumableRoleDTO findTypeById(Long id);
			
	ConsumableImageDTO findByIdImage(Long id);
	
	EstablishmentWithConsumablesDTO findByName(Long id, String name, Integer page,Pageable pageable);
	
	EstablishmentWithConsumablesDTO findByPriceByOrdemByAsc(Long id, Integer page,Pageable pageable);
	
	EstablishmentWithConsumablesDTO findByPriceByOrdemByDesc(Long id, Integer page,Pageable pageable);
	
	EstablishmentWithConsumablesDTO findAll(Long id, Integer page,Pageable pageable);

	List<ConsumableProjection> findAll();
}

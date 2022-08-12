package br.senac.requestfood.service.item;

import java.util.List;

import br.senac.requestfood.dto.item.ItemDTO;
import br.senac.requestfood.projection.item.ItemProjection;

public interface ItemService {

	ItemDTO save(ItemDTO itemDTO);
	
	void update(ItemDTO itemDTO, Long id);
	
	void delete(Long id);
	
	ItemProjection findById(Long id);
	
	List<ItemProjection> findAll();
}

package br.senac.requestfood.service.item;

import java.util.List;

import br.senac.requestfood.dto.item.ItemDTO;
import br.senac.requestfood.projection.item.ItemProjection;
import br.senac.requestfood.projection.item.ItemWithItemAdditionalProjection;

public interface ItemService {

	ItemDTO save(ItemDTO itemDTO);
	
	void update(ItemDTO itemDTO, Long id);
	
	void delete(Long id);
	
	ItemProjection findById(Long id);
	
	ItemWithItemAdditionalProjection findItemWithItemAdditionalById(Long id);
	
	List<ItemProjection> findAll();
}

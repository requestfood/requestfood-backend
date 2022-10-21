package br.senac.requestfood.service.item;

import java.util.List;

import br.senac.requestfood.dto.item.ItemOrderDTO;
import br.senac.requestfood.projection.item.ItemProjection;

public interface ItemService {

	ItemOrderDTO save(ItemOrderDTO itemDTO);
	
	void update(ItemOrderDTO itemDTO, Long id);
	
	void delete(Long id);
	
	ItemProjection findById(Long id);
	
	List<ItemProjection> findAll();
}

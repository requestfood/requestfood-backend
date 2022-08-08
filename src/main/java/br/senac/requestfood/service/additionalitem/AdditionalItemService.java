package br.senac.requestfood.service.additionalitem;

import java.util.List;

import br.senac.requestfood.dto.itemadicional.ItemAdicionalDTO;
import br.senac.requestfood.projection.itemAdicional.ItemAdicionalProjection;

public interface AdditionalItemService {
	
	ItemAdicionalDTO save(ItemAdicionalDTO additionalItemDTO);

	void update(ItemAdicionalDTO additionalItemDTO, Long id);

	void delete(Long id);
	
	ItemAdicionalProjection findById(Long id);
	
	List<ItemAdicionalProjection> findAll();
}

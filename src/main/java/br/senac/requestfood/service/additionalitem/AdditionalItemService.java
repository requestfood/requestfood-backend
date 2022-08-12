package br.senac.requestfood.service.additionalitem;

import java.util.List;

import br.senac.requestfood.dto.addicionalitem.AdditionalItemDTO;
import br.senac.requestfood.projection.addicionalItem.AdditionalItemProjection;

public interface AdditionalItemService {
	
	AdditionalItemDTO save(AdditionalItemDTO additionalItemDTO);

	void update(AdditionalItemDTO additionalItemDTO, Long id);

	void delete(Long id);
	
	AdditionalItemProjection findById(Long id);
	
	List<AdditionalItemProjection> findAll();
}

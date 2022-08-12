package br.senac.requestfood.mapper.addicionalitem;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.senac.requestfood.dto.addicionalitem.AdditionalItemDTO;
import br.senac.requestfood.model.addicionalItem.AdditionalItem;

@Service
public class AdditionalItemMapper {
    public AdditionalItemDTO toDTO(AdditionalItem addicionalItem) {
        return new AdditionalItemDTO(addicionalItem.getId(), addicionalItem.getItem(), addicionalItem.getName(), addicionalItem.getQuantity());
    }

    public AdditionalItem toEntity(AdditionalItemDTO addicionalItemDTO) {
    	return null;
    }
    
    public List<AdditionalItemDTO> toDTO(List<AdditionalItem> additionalItems){
		
		final List<AdditionalItemDTO> addicionalItemDTOs = new ArrayList<>();
		
		for (AdditionalItem additionalItem : additionalItems) {
			addicionalItemDTOs.add(toDTO(additionalItem));
		}
		
		return addicionalItemDTOs;
	}
	
	public List<AdditionalItem> toEntity(List<AdditionalItemDTO> additionalItemDTOs) {
		
		final List<AdditionalItem> additionalitems = new ArrayList<>();
		
		for (AdditionalItemDTO additionalitemDTO : additionalItemDTOs) {
			additionalitems.add(toEntity(additionalitemDTO));
		}
		
		return additionalitems;
	}
}

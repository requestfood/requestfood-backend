package br.senac.requestfood.mapper.itemadicional;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.senac.requestfood.dto.itemadicional.ItemAdicionalDTO;
import br.senac.requestfood.model.itemadicional.ItemAdicional;

@Service
public class ItemAdicionalMapper {
    public ItemAdicionalDTO toDTO(ItemAdicional itemAdicional) {
        return new ItemAdicionalDTO(itemAdicional.getId(), itemAdicional.getItem(), itemAdicional.getNomeAdicional(), itemAdicional.getQuantidade());
    }

    public void toEntity(ItemAdicionalDTO itemAdicionalDTO) {
		// Not completed, waiting response for Front-End
    }
    
    public List<ItemAdicionalDTO> toDTO(List<ItemAdicional> itemadicionais){
		
		final List<ItemAdicionalDTO> itemadicionalDTOs = new ArrayList<>();
		
		for (ItemAdicional itemAdicional : itemadicionais) {
			itemadicionalDTOs.add(toDTO(itemAdicional));
		}
		
		return itemadicionalDTOs;
	}
	
	public List<ItemAdicional> toEntity(List<ItemAdicionalDTO> itemadicionalDTOs) {
		
		final List<ItemAdicional> itemadicionais = new ArrayList<>();
		
		for (ItemAdicionalDTO itemadicionalDTO : itemadicionalDTOs) {
//			contatos.add(toEntity(contatoDTO));
		}
		
		return itemadicionais;
	}
}

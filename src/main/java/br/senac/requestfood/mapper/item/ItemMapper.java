package br.senac.requestfood.mapper.item;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.senac.requestfood.dto.item.ItemDTO;
import br.senac.requestfood.model.item.Item;


@Service
public class ItemMapper {

	public ItemDTO toDTO(Item item) {
		return new ItemDTO(item.getId(), item.getComanda(), item.getQuantidade(), item.getConsumivel(), item.getObservacao(), item.getItensAdicionais());
	}
	
	public void toEntity(ItemDTO itemDTO) {
	//Not Completed, waiting response for Front-End
	}

	public List<ItemDTO> toDTO(List<Item> items){
		
		final List<ItemDTO> itemDTOs = new ArrayList<>();
		
		for (Item item : items) {
			itemDTOs.add(toDTO(item));
		}
		
		return itemDTOs;
	}
	
	public List<Item> toEntity(List<ItemDTO> itemDTOs) {
		
		final List<Item> items= new ArrayList<>();
		
		for (ItemDTO itemDTO : itemDTOs) {
		//	items.add(toEntity(itemDTO));
		}
		
		return items;
	}
}

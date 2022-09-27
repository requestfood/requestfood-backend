package br.senac.requestfood.mapper.item;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.senac.requestfood.dto.item.ItemDTO;
import br.senac.requestfood.exception.consumable.ConsumableNotFoundException;
import br.senac.requestfood.exception.order.OrderNotFoundException;
import br.senac.requestfood.model.consumable.Consumable;
import br.senac.requestfood.model.item.Item;
import br.senac.requestfood.model.order.Order;
import br.senac.requestfood.repository.consumable.ConsumableRepository;
import br.senac.requestfood.repository.order.OrderRepository;


@Service
public class ItemMapper {
	
	private OrderRepository orderRepository;
	private ConsumableRepository consumableRepository;

	public ItemDTO toDTO(Item item) {
		return new ItemDTO(item.getId(), item.getOrder().getId(), item.getQuantity(), item.getConsumable().getId(), item.getObservation());
	}
	
	public Item toEntity(ItemDTO dto) {
		Order order = orderRepository.findById(dto.idOrder())
				.orElseThrow(() -> new OrderNotFoundException(null));
		Consumable consumable = consumableRepository.findById(dto.idComsumbale())
				.orElseThrow(() -> new ConsumableNotFoundException(null));		
		
		return new Item(dto.id(), order, dto.quantity(), consumable, dto.observation());
	}

	public List<ItemDTO> toDTO(List<Item> items){
		
		final List<ItemDTO> itemDTOs = new ArrayList<>();
		
		for (Item item : items) {
			itemDTOs.add(toDTO(item));
		}
		
		return itemDTOs;
	}
	
	public List<Item> toEntity(List<ItemDTO> itemDTOs) {
		
		final List<Item> items = new ArrayList<>();
		
		for (ItemDTO itemDTO : itemDTOs) {
			items.add(toEntity(itemDTO));
		}
		
		return items;
	}
}

package br.senac.requestfood.mapper.item;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.senac.requestfood.dto.item.ItemOrderDTO;
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
	
	public ItemMapper(OrderRepository orderRepository, ConsumableRepository consumableRepository) {
		this.orderRepository = orderRepository;
		this.consumableRepository = consumableRepository;
	}

	public ItemOrderDTO toDTO(Item item) {
		return new ItemOrderDTO(item.getId(), item.getOrder().getId(), item.getConsumable().getId(), item.getQuantity(), item.getObservation());
	}
	
	public Item toEntity(ItemOrderDTO dto) {
		Order order = orderRepository.findById(dto.idOrder())
				.orElseThrow(() -> new OrderNotFoundException(null));
		Consumable consumable = consumableRepository.findById(dto.idConsumable())
				.orElseThrow(() -> new ConsumableNotFoundException(null));		
		
		return new Item(dto.id(), order, dto.quantityItem(), consumable, dto.obsItem());
	}

	public List<ItemOrderDTO> toDTO(List<Item> items){
		
		final List<ItemOrderDTO> itemDTOs = new ArrayList<>();
		
		for (Item item : items) {
			itemDTOs.add(toDTO(item));
		}
		
		return itemDTOs;
	}
	
	public List<Item> toEntity(List<ItemOrderDTO> itemDTOs) {
		
		final List<Item> items = new ArrayList<>();
		
		for (ItemOrderDTO itemDTO : itemDTOs) {
			items.add(toEntity(itemDTO));
		}
		
		return items;
	}
}

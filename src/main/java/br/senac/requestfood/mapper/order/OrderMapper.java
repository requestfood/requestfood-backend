package br.senac.requestfood.mapper.order;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.senac.requestfood.dto.order.CreateOrderDTO;
import br.senac.requestfood.dto.order.client.ClientOrdersDTO;
import br.senac.requestfood.dto.order.client.OrderToClientDTO;
import br.senac.requestfood.model.order.Order;

@Service
public class OrderMapper {
	
	public CreateOrderDTO toDTO(Order entity) {
		return new CreateOrderDTO(entity.getId(), entity.getEstablishment().getId(), entity.getClient().getId());
	}

	public ClientOrdersDTO toClientOrdersDTO(Order entity) {
		
		List<Order> orders = entity.getClient().getOrders();
		List<OrderToClientDTO> dtos = new ArrayList<>();
		
		for (Order order : orders) {
			dtos.add(new OrderToClientDTO(order.getId(), order.getEstablishment().getId(), order.getEstablishment().getImage(), order.getEstablishment().getName(), order.getOrderStatus(), order.getIssueDate()));
		}
		
		return new ClientOrdersDTO(entity.getClient().getId(), dtos);
	}

}

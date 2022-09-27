package br.senac.requestfood.mapper.order;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.senac.requestfood.dto.client.ClientOrdersDTO;
import br.senac.requestfood.dto.order.client.OrderToClientDTO;
import br.senac.requestfood.model.order.Order;
import br.senac.requestfood.repository.client.ClientRepository;
import br.senac.requestfood.repository.establisment.EstablishmentRepository;

@Service
public class OrderMapper {
	
	private EstablishmentRepository establishmentRepository;
	private ClientRepository clientRepository;
	
	public OrderMapper(EstablishmentRepository establishmentRepository, ClientRepository clientRepository) {
		this.establishmentRepository = establishmentRepository;
		this.clientRepository = clientRepository;
	}

	public ClientOrdersDTO toClientOrdersDTO(Order entity) {
		
		List<Order> orders = entity.getClient().getOrders();
		List<OrderToClientDTO> dtos = new ArrayList<>();
		
		for (Order order : orders) {
			dtos.add(new OrderToClientDTO(order.getId(), order.getEstablishment().getImage(), order.getEstablishment().getName(), order.getOrderStatus(), order.getIssueDate()));
		}
		
		return new ClientOrdersDTO(entity.getClient().getId(), dtos);
	}

}

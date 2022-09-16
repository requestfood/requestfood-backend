package br.senac.requestfood.mapper.order;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.senac.requestfood.dto.order.OrderDTO;
import br.senac.requestfood.exception.client.ClientNotFoundException;
import br.senac.requestfood.exception.establishment.EstablishmentNotFoundException;
import br.senac.requestfood.model.order.Order;
import br.senac.requestfood.model.user.client.Client;
import br.senac.requestfood.model.user.establishment.Establishment;
import br.senac.requestfood.repository.client.ClientRepository;
import br.senac.requestfood.repository.establisment.EstablishmentRepository;

@Service
public class OrderMapper {
	
	private EstablishmentRepository establishmentRepository;
	private ClientRepository clientRepository;

	public OrderDTO toDTO(Order order) {
		return new OrderDTO(order.getId(),order.getEstablishment().getId() ,order.getClient().getId(), order.getIssueDate(), order.getClosingDate(), order.getOrderStatus(), order.getAmount());
	}
	
	public Order toEntity(OrderDTO orderDTO) {
		Establishment establishment = establishmentRepository.findById(orderDTO.idEstablishment())
				.orElseThrow(() -> new EstablishmentNotFoundException("Establishment "+ orderDTO.idEstablishment() +" was not found."));
		Client client = clientRepository.findById(orderDTO.idClient())
				.orElseThrow(() -> new ClientNotFoundException("Client "+ orderDTO.idClient() +" was not found."));
		
		return new Order(orderDTO.id(), establishment, client, orderDTO.issueDate(), orderDTO.closingDate(), orderDTO.orderStatus());
	}
	
	public List<OrderDTO> toDTO(List<Order> orders){
		
		final List<OrderDTO> orderDTOS = new ArrayList<>();
		
		for (Order order : orders) {
			orderDTOS.add(toDTO(order));
		}
		
		return orderDTOS;
	}
	
	public List<Order> toEntity(List<OrderDTO> orderDTOS) {
		
		final List<Order> orders= new ArrayList<>();
		
		for (OrderDTO orderDTO : orderDTOS) {
			orders.add(toEntity(orderDTO));
		}
		
		return orders;
	}
}

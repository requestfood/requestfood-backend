package br.senac.requestfood.mapper.establishment;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.senac.requestfood.dto.establishment.EstablishmentAllDTO;
import br.senac.requestfood.dto.establishment.EstablishmentWithOrdersDTO;
import br.senac.requestfood.dto.order.establishment.OrderWithDateDTO;
import br.senac.requestfood.model.contact.Contact;
import br.senac.requestfood.model.order.Order;
import br.senac.requestfood.model.user.establishment.Establishment;

@Service
public class EstablishmentMapper {
	
	public EstablishmentAllDTO toDTO(Establishment establishment) {
		return new EstablishmentAllDTO(establishment.getId(), establishment.getName(), establishment.getContact().getEmail(), establishment.getContact().getPhone(), establishment.getPassword(), establishment.getImage(), establishment.getTimeToOpen(), establishment.getTimeToClose());
	}
	
	public Establishment toEntity(EstablishmentAllDTO dto) {	
		final Contact contact = new Contact(dto.id(), dto.phone(), dto.email());
		return new Establishment(dto.id(), dto.name(), contact, dto.password(), dto.image(), dto.timeToOpen(), dto.timeToClose());
	}
	
	public EstablishmentWithOrdersDTO toEWOrdersDTO(Establishment entity) {
		
		List<OrderWithDateDTO> orders = new ArrayList<>();
		
		for (Order order : entity.getOrders()) {
			orders.add(new OrderWithDateDTO(order.getId(), order.getClient().getName(), order.getIssueDate(), order.getClosingDate()));
		}
		
		final EstablishmentWithOrdersDTO dto = new EstablishmentWithOrdersDTO(entity.getId(), entity.getName(), orders);
		return dto;
	}
	
	public List<EstablishmentAllDTO> toDTO(List<Establishment> establishments){
		
		final List<EstablishmentAllDTO> establishmentDTOs = new ArrayList<>();
		
		for (Establishment establishment : establishments) {
			establishmentDTOs.add(toDTO(establishment));
		}
		
		return establishmentDTOs;
	}
	
	public List<Establishment> toEntity(List<EstablishmentAllDTO> establishmentDTOs) {
		
		final List<Establishment> establishments= new ArrayList<>();
		
		for (EstablishmentAllDTO establishmentDTO : establishmentDTOs) {
			establishments.add(toEntity(establishmentDTO));
		}
		
		return establishments;
	}
}

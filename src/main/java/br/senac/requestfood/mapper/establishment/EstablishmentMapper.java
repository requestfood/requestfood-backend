package br.senac.requestfood.mapper.establishment;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.senac.requestfood.dto.establishment.EstablishmentAllDTO;
import br.senac.requestfood.dto.establishment.EstablishmentDTO;
import br.senac.requestfood.dto.establishment.EstablishmentWithConsumablesDTO;
import br.senac.requestfood.model.contact.Contact;
import br.senac.requestfood.model.user.establishment.Establishment;

@Service
public class EstablishmentMapper {
	
	public EstablishmentDTO toDTO(Establishment establishment) {
		return new EstablishmentDTO(establishment.getId(), establishment.getName(), establishment.getContact(), establishment.getImage(), establishment.getDescription());
	}
	
	public Establishment toEntity(EstablishmentAllDTO establishmentDTO) {
		Contact contact = new Contact(establishmentDTO.id(), establishmentDTO.phone(), establishmentDTO.email());
		return new Establishment(establishmentDTO.id(), establishmentDTO.name(), contact, establishmentDTO.password(), establishmentDTO.image(),establishmentDTO.description());
	}

	
	public EstablishmentAllDTO AllToDTO(Establishment establishment) {
		return new EstablishmentAllDTO(establishment.getId(), establishment.getName(), establishment.getContact().getEmail(), establishment.getContact().getPhone(), establishment.getPassword(), establishment.getDescription(), establishment.getImage());
	}
	
	public Establishment AllToEntity(EstablishmentAllDTO dto) {	
		final Contact contact = new Contact(dto.id(), dto.phone(), dto.email());
		return new Establishment(dto.id(), dto.name(), contact, dto.password(), dto.image(), dto.description());
	}
	
	public EstablishmentWithConsumablesDTO toConsumables(Establishment entity) {
		final EstablishmentWithConsumablesDTO dto = new EstablishmentWithConsumablesDTO(entity.getId(), entity.getName(), entity.getConsumables());
		return dto;
	}
	
	public List<EstablishmentDTO> toDTO(List<Establishment> establishments){
		
		final List<EstablishmentDTO> establishmentDTOs = new ArrayList<>();
		
		for (Establishment establishment : establishments) {
			establishmentDTOs.add(toDTO(establishment));
		}
		
		return establishmentDTOs;
	}
	
	public List<Establishment> toEntity(List<EstablishmentAllDTO> establishmentDTOs) {
		
		final List<Establishment> establishments= new ArrayList<>();
		
		for (EstablishmentAllDTO establishmentDTO : establishmentDTOs) {
			establishments.add(AllToEntity(establishmentDTO));
		}
		
		return establishments;
	}
}

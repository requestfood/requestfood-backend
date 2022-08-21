package br.senac.requestfood.mapper.establishment;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.senac.requestfood.dto.establishment.AllEstablishmentDTO;
import br.senac.requestfood.dto.establishment.EstablishmentDTO;
import br.senac.requestfood.model.contact.Contact;
import br.senac.requestfood.model.user.establishment.Establishment;

@Service
public class EstablishmentMapper {
	
	public EstablishmentDTO toDTO(Establishment establishment) {
		return new EstablishmentDTO(establishment.getId(), establishment.getName(), establishment.getContact(), establishment.getImage(), establishment.getCep(),establishment.getDescription());
	}
	
	public Establishment toEntity(AllEstablishmentDTO establishmentDTO) {
		Contact contact = new Contact(establishmentDTO.id(), establishmentDTO.phone(), establishmentDTO.email());
		return new Establishment(establishmentDTO.id(), establishmentDTO.name(), contact, establishmentDTO.password(), establishmentDTO.image(), establishmentDTO.cep(),establishmentDTO.description());
	}

	
	public AllEstablishmentDTO AllToDTO(Establishment establishment) {
		return new AllEstablishmentDTO(establishment.getId(), establishment.getName(), establishment.getCep(), establishment.getContact().getEmail(), establishment.getContact().getPhone(), establishment.getPassword(), establishment.getDescription(), establishment.getImage());
	}
	
	public Establishment AllToEntity(AllEstablishmentDTO dto) {	
		Contact contact = new Contact(dto.id(), dto.phone(), dto.email());
		return new Establishment(dto.id(), dto.name(), contact, dto.password(), dto.image(), dto.cep(), dto.description());
	}
	
	public List<EstablishmentDTO> toDTO(List<Establishment> establishments){
		
		final List<EstablishmentDTO> establishmentDTOs = new ArrayList<>();
		
		for (Establishment establishment : establishments) {
			establishmentDTOs.add(toDTO(establishment));
		}
		
		return establishmentDTOs;
	}
	
	public List<Establishment> toEntity(List<AllEstablishmentDTO> establishmentDTOs) {
		
		final List<Establishment> establishments= new ArrayList<>();
		
		for (AllEstablishmentDTO establishmentDTO : establishmentDTOs) {
			establishments.add(AllToEntity(establishmentDTO));
		}
		
		return establishments;
	}
}

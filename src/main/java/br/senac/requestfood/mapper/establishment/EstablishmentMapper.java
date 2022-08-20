package br.senac.requestfood.mapper.establishment;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.senac.requestfood.dto.client.ClientRegisterDTO;
import br.senac.requestfood.dto.establishment.EstablishmentDTO;
import br.senac.requestfood.dto.establishment.EstablishmentRegisterDTO;
import br.senac.requestfood.model.contact.Contact;
import br.senac.requestfood.model.user.client.Client;
import br.senac.requestfood.model.user.establishment.Establishment;

@Service
public class EstablishmentMapper {
	
	public EstablishmentDTO toDTO(Establishment establishment) {
		return new EstablishmentDTO(establishment.getId(), establishment.getName(), establishment.getContact(), establishment.getPassword(), establishment.getImage(), establishment.getCep(),establishment.getDescription());
	}
	
	public Establishment toEntity(EstablishmentDTO establishmentDTO) {
		return new Establishment(establishmentDTO.id(), establishmentDTO.name(), establishmentDTO.contact(), establishmentDTO.password(), establishmentDTO.image(), establishmentDTO.cep(),establishmentDTO.description());
	}

	
	public EstablishmentRegisterDTO RegisterToDTO(Establishment establishment) {
		return new EstablishmentRegisterDTO(establishment.getId(), establishment.getName(), establishment.getCep(), establishment.getContact().getEmail(), establishment.getContact().getPhone(), establishment.getPassword(), establishment.getDescription(), establishment.getImage());
	}
	
	public Establishment RegisterToEntity(EstablishmentRegisterDTO dto) {	
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
	
	public List<Establishment> toEntity(List<EstablishmentDTO> establishmentDTOs) {
		
		final List<Establishment> establishments= new ArrayList<>();
		
		for (EstablishmentDTO establishmentDTO : establishmentDTOs) {
			establishments.add(toEntity(establishmentDTO));
		}
		
		return establishments;
	}
}

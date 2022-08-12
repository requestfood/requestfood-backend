package br.senac.requestfood.mapper.establishment;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.senac.requestfood.dto.establishment.EstablishmentDTO;
import br.senac.requestfood.model.user.establishment.Establishment;

@Service
public class EstablishmentMapper {
	
	public EstablishmentDTO toDTO(Establishment establishment) {
		return new EstablishmentDTO(establishment.getId(), establishment.getName(), establishment.getContact(), establishment.getPassword(), establishment.getImage(), establishment.getCep(),establishment.getBiography());
	}
	
	public Establishment toEntity(EstablishmentDTO establishmentDTO) {
		return new Establishment(establishmentDTO.id(), establishmentDTO.name(), establishmentDTO.contact(), establishmentDTO.password(), establishmentDTO.image(), establishmentDTO.cep(),establishmentDTO.biography());
	}

	public List<EstablishmentDTO> toDTO(List<Establishment> establiments){
		
		final List<EstablishmentDTO> establishmentDTOs = new ArrayList<>();
		
		for (Establishment establishment : establiments) {
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

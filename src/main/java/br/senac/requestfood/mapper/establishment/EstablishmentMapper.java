package br.senac.requestfood.mapper.establishment;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.senac.requestfood.dto.establishment.EstablishmentDTO;
import br.senac.requestfood.model.user.establishment.Establishment;

@Service
public class EstablishmentMapper {
	
	public EstablishmentDTO toDTO(Establishment establishment) {
		return new EstablishmentDTO(establishment.getId(), establishment.getName(), establishment.getContact(),establishment.getConsumables(), establishment.getDesks());
	}
	
	public Establishment toEntity(EstablishmentDTO establishmentTO) {
	//Not Completed, waiting response for Front-End
		return null;
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

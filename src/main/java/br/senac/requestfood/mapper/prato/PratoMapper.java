package br.senac.requestfood.mapper.prato;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.senac.requestfood.dto.prato.PratoDTO;
import br.senac.requestfood.model.consumivel.prato.Prato;

@Service
public class PratoMapper {

	public PratoDTO toDTO(Prato prato) {
		return new PratoDTO(prato.getId(), prato.getNome(), prato.getEstabelecimento(),prato.getValor());
	}
	
	public Prato toEntity(PratoDTO pratoDTO) {
	//Not Completed, waiting response for Front-End
		return null;
	}

	public List<PratoDTO> toDTO(List<Prato> pratos){
		
		final List<PratoDTO> pratoDTOs = new ArrayList<>();
		
		for (Prato prato : pratos) {
			pratoDTOs.add(toDTO(prato));
		}
		
		return pratoDTOs;
	}
	
	public List<Prato> toEntity(List<PratoDTO> pratoDTOs) {
		
		final List<Prato> pratos= new ArrayList<>();
		
		for (PratoDTO pratoDTO : pratoDTOs) {
			pratos.add(toEntity(pratoDTO));
		}
		
		return pratos;
	}
}

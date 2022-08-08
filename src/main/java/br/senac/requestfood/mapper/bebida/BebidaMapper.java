package br.senac.requestfood.mapper.bebida;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.senac.requestfood.dto.bebida.BebidaDTO;
import br.senac.requestfood.model.consumivel.bebida.Bebida;

@Service
public class BebidaMapper {

	public BebidaDTO toDTO(Bebida bebida) {
		return new BebidaDTO(bebida.getId(), bebida.getEstabelecimento(), bebida.getNome(), bebida.getValor());
	}
	
	public Bebida toEntity(BebidaDTO bebidaDTO) {
		// Not completed, waiting response for Front-End
		return null;
	}
	
	public List<BebidaDTO> toDTO(List<Bebida> bebidas){
		
		final List<BebidaDTO> bebidaDTOs = new ArrayList<>();
		
		for (Bebida bebida : bebidas) {
			bebidaDTOs.add(toDTO(bebida));
		}
		
		return bebidaDTOs;
	}
	
	public List<Bebida> toEntity(List<BebidaDTO> dtos) {
		
		final List<Bebida> bebidas = new ArrayList<>();
		
		for (BebidaDTO bebidaDTO : dtos) {
			bebidas.add(toEntity(bebidaDTO));
		}
		
		return bebidas;
	}
}

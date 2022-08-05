package br.senac.requestfood.mapper.comanda;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.senac.requestfood.dto.comanda.ComandaDTO;
import br.senac.requestfood.model.comanda.Comanda;

@Service
public class ComandaMapper {

	public ComandaDTO toDTO(Comanda comanda) {
		return new ComandaDTO(comanda.getId(), comanda.getCliente(), comanda.getMesa(), comanda.getDataEmissao(), comanda.getDataFechamento(), comanda.getItens());
	}
	
	public void toEntity(ComandaDTO clienteDTO) {
	//Not Completed, waiting response for Front-End
	}

	public List<ComandaDTO> toDTO(List<Comanda> comandas){
		
		final List<ComandaDTO> comandaDTOs = new ArrayList<>();
		
		for (Comanda comanda : comandas) {
			comandaDTOs.add(toDTO(comanda));
		}
		
		return comandaDTOs;
	}
	
	public List<Comanda> toEntity(List<ComandaDTO> comandaDTOs) {
		
		final List<Comanda> comandas= new ArrayList<>();
		
		for (ComandaDTO comandaDTO : comandaDTOs) {
		//	clientes.add(toEntity(comandaDTO));
		}
		
		return comandas;
	}
}

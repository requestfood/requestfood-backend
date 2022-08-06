package br.senac.requestfood.service.comanda;

import java.util.List;

import br.senac.requestfood.dto.comanda.ComandaDTO;
import br.senac.requestfood.exception.client.ClientNotFoundException;
import br.senac.requestfood.mapper.comanda.ComandaMapper;
import br.senac.requestfood.repository.comanda.ComandaRepository;


public class ComandaServiceImpl implements ComandaService{
	
	private final ComandaRepository repository;
	private final ComandaMapper mapper;
	
	public ComandaServiceImpl (ComandaRepository repository, ComandaMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}
	
	public ComandaDTO save(ComandaDTO comandaDTO) {
		
		if(!repository.existsCliente(comandaDTO.cliente()))
			throw new CommandClientNotFoundException("Client "+ id +" was not found");
		
		if
		
		
		if
	}

}

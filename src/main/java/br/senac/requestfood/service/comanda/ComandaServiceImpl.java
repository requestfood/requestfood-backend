package br.senac.requestfood.service.comanda;

import java.util.List;

import br.senac.requestfood.dto.comanda.ComandaDTO;
import br.senac.requestfood.exception.comanda.ComandaMesaRegisteredException;
import br.senac.requestfood.exception.comanda.CommandClientNotFoundException;
import br.senac.requestfood.exception.comanda.CommandNotFoundException;
import br.senac.requestfood.mapper.comanda.ComandaMapper;
import br.senac.requestfood.model.comanda.Comanda;
import br.senac.requestfood.projection.comanda.ComandaProjection;
import br.senac.requestfood.projection.comanda.ComandaWithClosureDateProjection;
import br.senac.requestfood.projection.comanda.ComandaWithItemProjection;
import br.senac.requestfood.repository.comanda.ComandaRepository;


public class ComandaServiceImpl implements ComandaService{
	
	private final ComandaRepository repository;
	private final ComandaMapper mapper;
	
	public ComandaServiceImpl (ComandaRepository repository, ComandaMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}
	
	public ComandaDTO save(ComandaDTO comandaDTO) {
		
		if(!repository.existsClient(comandaDTO.cliente()))
			throw new CommandClientNotFoundException("Client "+ comandaDTO.cliente().getId() + " was not found");

		if(!repository.existsMesa(comandaDTO.mesa()))
			throw new ComandaMesaRegisteredException("Table "+ comandaDTO.mesa().getId() + " was not found");

		Comanda comanda = mapper.toEntity(comandaDTO);
		Comanda comandaSaved = repository.save(comanda);

		return mapper.toDTO(comandaSaved);
	}

	public void update(ComandaDTO comandaDTO, Long id) {
		
		Comanda comanda = repository.findById(id).orElseThrow(() -> new CommandNotFoundException("Command " + id + " was not found"));
		
		if(!repository.existsClient(comandaDTO.cliente()))
			throw new CommandClientNotFoundException("Client "+ comandaDTO.cliente().getId() + " was not found");

		if(!repository.existsMesa(comandaDTO.mesa()))
			throw new ComandaMesaRegisteredException("Table "+ comandaDTO.mesa().getId() + " was not found");
		
		comanda.setCliente(comandaDTO.cliente());
		comanda.setMesa(comandaDTO.mesa());
		comanda.setDataEmissao(comandaDTO.dataEmissao());
		comanda.setDataFechamento(comandaDTO.dataFechamento());
		comanda.setValorTotal(comandaDTO.valorTotal());
		
		repository.save(comanda);
	}

	public void delete(Long id) {
		if(!repository.existsById(id))
			throw new CommandNotFoundException("Command " + id + " was not found");
	}

	public ComandaProjection findById(Long id) {
		ComandaProjection comanda = repository.findComandaById(id).orElseThrow(() -> new CommandNotFoundException("Command " + id + " was not found"));
		return comanda;
	}

	public ComandaWithItemProjection findByIdWithItem(Long id) {
		ComandaWithItemProjection comanda = repository.findComandaWithItemById(id).orElseThrow(() -> new CommandNotFoundException("Item " + id + " was not found"));
		return comanda;
	}

	public ComandaWithClosureDateProjection findByIdWithClosureDate(Long id) {
		ComandaWithClosureDateProjection comanda = repository.findComandaWithClosureDate(id).orElseThrow(() -> new CommandNotFoundException("Item " + id + " was not found"));
		return comanda;
	}

	public List<ComandaProjection> findAll() {
		return repository.findCommands();
	}

}

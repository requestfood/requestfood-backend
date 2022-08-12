package br.senac.requestfood.service.command;

import java.util.List;

import br.senac.requestfood.dto.command.CommandDTO;
import br.senac.requestfood.exception.command.CommandNotFoundException;
import br.senac.requestfood.mapper.command.CommandMapper;
import br.senac.requestfood.model.command.Command;
import br.senac.requestfood.projection.command.CommandProjection;
import br.senac.requestfood.projection.command.CommandWithClosureDateProjection;
import br.senac.requestfood.projection.command.CommandWithItemProjection;
import br.senac.requestfood.repository.command.CommandRepository;


public class ComandaServiceImpl implements CommandService{
	
	private final CommandRepository repository;
	private final CommandMapper mapper;
	
	public ComandaServiceImpl (CommandRepository repository, CommandMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}
	
	public CommandDTO save(CommandDTO comandaDTO) {
		
		Command comanda = mapper.toEntity(comandaDTO);
		Command comandaSaved = repository.save(comanda);

		return mapper.toDTO(comandaSaved);
	}

	public void update(CommandDTO comandaDTO, Long id) {
		
		Command command = repository.findById(id).orElseThrow(() -> new CommandNotFoundException("Command " + id + " was not found"));
		
		command.setClient(comandaDTO.client());
		command.setDesk(comandaDTO.desk());
		command.setIssueDate(comandaDTO.issueDate());
		command.setClosingDate(comandaDTO.closingDate());
		command.setAmount(comandaDTO.value());
		
		repository.save(command);
	}

	public void delete(Long id) {
		if(!repository.existsById(id))
			throw new CommandNotFoundException("Command " + id + " was not found");
	}

	public CommandProjection findById(Long id) {
		CommandProjection comanda = repository.findCommandById(id).orElseThrow(() -> new CommandNotFoundException("Command " + id + " was not found"));
		return comanda;
	}

	public CommandWithItemProjection findByIdWithItem(Long id) {
		CommandWithItemProjection comanda = repository.findCommandWithItemById(id).orElseThrow(() -> new CommandNotFoundException("Item " + id + " was not found"));
		return comanda;
	}

	public CommandWithClosureDateProjection findByIdWithClosureDate(Long id) {
		CommandWithClosureDateProjection comanda = repository.findCommandWithClosureDate(id).orElseThrow(() -> new CommandNotFoundException("Item " + id + " was not found"));
		return comanda;
	}

	public List<CommandProjection> findAll() {
		return repository.findCommands();
	}

}

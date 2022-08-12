package br.senac.requestfood.mapper.command;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.senac.requestfood.dto.command.CommandDTO;
import br.senac.requestfood.model.command.Command;

@Service
public class CommandMapper {

	public CommandDTO toDTO(Command command) {
		return new CommandDTO(command.getId(), command.getClient(), command.getIssueDate(), command.getClosingDate(), command.getItens(), command.getAmount());
	}
	
	public Command toEntity(CommandDTO commandDTO) {
	//Not Completed, waiting response for Front-End
		return null;
	}

	public List<CommandDTO> toDTO(List<Command> commands){
		
		final List<CommandDTO> commandDTOs = new ArrayList<>();
		
		for (Command command : commands) {
			commandDTOs.add(toDTO(command));
		}
		
		return commandDTOs;
	}
	
	public List<Command> toEntity(List<CommandDTO> commandDTOs) {
		
		final List<Command> commands= new ArrayList<>();
		
		for (CommandDTO commandDTO : commandDTOs) {
			commands.add(toEntity(commandDTO));
		}
		
		return commands;
	}
}

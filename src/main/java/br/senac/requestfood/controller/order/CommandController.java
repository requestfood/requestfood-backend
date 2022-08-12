package br.senac.requestfood.controller.order;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.senac.requestfood.dto.order.CommandDTO;
import br.senac.requestfood.projection.order.CommandProjection;
import br.senac.requestfood.service.order.CommandService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/command")

public class CommandController {
    
    private final CommandService commandService;

    public CommandController(CommandService commandService) {
		this.commandService = commandService;
	}

	@PostMapping
	public ResponseEntity<CommandDTO> addCommand(@RequestBody CommandDTO commandDTO) {
		return ResponseEntity.status(HttpStatus.CREATED).body(commandService.save(commandDTO));
	}

	@PutMapping("/{id}")
	public ResponseEntity<String> updatedCommand(@RequestBody CommandDTO commandDTO, @PathVariable(value = "id") Long id) {
		commandService.update(commandDTO, id);
		return ResponseEntity.status(HttpStatus.OK).body("Command updated successfully");
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletedCommand(@PathVariable(value = "id") Long id) {
		commandService.delete(id);
		return ResponseEntity.status(HttpStatus.OK).body("Command deleted successfully");
	}

	@GetMapping("/{id}")
	public ResponseEntity<CommandProjection> getCommand(@PathVariable(value = "id") Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(commandService.findById(id));
	}

	@GetMapping()
	public ResponseEntity<List<CommandProjection>> getAllCommand() {
		return ResponseEntity.status(HttpStatus.OK).body(commandService.findAll());
	}
}

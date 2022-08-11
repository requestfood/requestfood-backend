package br.senac.requestfood.controller.comanda;

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

import br.senac.requestfood.dto.comanda.ComandaDTO;
import br.senac.requestfood.projection.comanda.ComandaProjection;
import br.senac.requestfood.service.comanda.ComandaService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/command")

public class ComandaController {
    
    private final ComandaService commandService;

    public ComandaController(ComandaService comandaService) {
		this.commandService = comandaService;
	}

	@PostMapping
	public ResponseEntity<ComandaDTO> addCommand(@RequestBody ComandaDTO comandaDTO) {
		return ResponseEntity.status(HttpStatus.CREATED).body(commandService.save(comandaDTO));
	}

	@PutMapping("/{id}")
	public ResponseEntity<String> updatedCommand(@RequestBody ComandaDTO comandaDTO, @PathVariable(value = "id") Long id) {
		commandService.update(comandaDTO, id);
		return ResponseEntity.status(HttpStatus.OK).body("Command updated successfully");
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletedCommand(@PathVariable(value = "id") Long id) {
		commandService.delete(id);
		return ResponseEntity.status(HttpStatus.OK).body("Command deleted successfully");
	}

	@GetMapping("/{id}")
	public ResponseEntity<ComandaProjection> getComanda(@PathVariable(value = "id") Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(commandService.findById(id));
	}

	@GetMapping()
	public ResponseEntity<List<ComandaProjection>> getAllCommand() {
		return ResponseEntity.status(HttpStatus.OK).body(commandService.findAll());
	}
}

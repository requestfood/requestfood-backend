package br.senac.requestfood.controller.comanda;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.senac.requestfood.dto.comanda.ComandaDTO;
import br.senac.requestfood.projection.comanda.ComandaProjection;
import br.senac.requestfood.service.comanda.ComandaService;

@RestController
@CrossOrigin
@RequestMapping("/comanda")

public class ComandaController {
    
    private final ComandaController comandaService;

    public ComandaController(ComandaService comandaService) {
		this.comandaService = comandaService;
	}

	@PostMapping
	public ResponseEntity<ComandaDTO> addComanda(@RequestBody ComandaDTO comandaDTO) {
		return ResponseEntity.status(HttpStatus.CREATED).body(comandaService.save(comandaDTO));
	}

	@PutMapping("/{id}")
	public ResponseEntity<String> updateComanda(@RequestBody ComandaDTO comandaDTO, @PathVariable(value = "id") Long id) {
		comandaService.update(comandaDTO, id);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteComanda(@PathVariable(value = "id") Long id) {
		comandaService.delete(id);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ComandaProjection> getComanda(@PathVariable(value = "id") Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(comandaService.findById(id));
	}

}

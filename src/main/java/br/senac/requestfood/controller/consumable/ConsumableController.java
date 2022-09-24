package br.senac.requestfood.controller.consumable;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.senac.requestfood.projection.consumable.ConsumableProjection;
import br.senac.requestfood.service.consumable.ConsumableService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/consumable")
public class ConsumableController {
	
	private final ConsumableService service;

	public ConsumableController(ConsumableService service) {
		this.service = service;
	}

	@GetMapping()
	public ResponseEntity<List<ConsumableProjection>> getAllConsumables() {
		return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ConsumableProjection> getConsumable(@PathVariable(value = "id") Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
	}
	
}

package br.senac.requestfood.controller.consumable;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.senac.requestfood.dto.client.AllClientDTO;
import br.senac.requestfood.dto.client.ClientPasswordDTO;
import br.senac.requestfood.projection.client.ClientProjection;
import br.senac.requestfood.projection.consumable.ConsumableProjection;
import br.senac.requestfood.projection.establishment.EstablishmentProjection;
import br.senac.requestfood.service.client.ClientService;

public class ConsumableController {
	
	private final ConsumableService service;

	public ConsumableController(ConsumableService service) {
		this.service = service;
	}

	@GetMapping("/{id}")
	public ResponseEntity<ConsumableProjection> getConsumable(@PathVariable(value = "id") Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
	}

	@GetMapping("/search-name/{name}")
	public ResponseEntity<List<ConsumableProjection>> getConsumableByName(@PathVariable(value = "name") String name) {
		return ResponseEntity.status(HttpStatus.OK).body(service.findConsumableByName(name));
	}
	
	@GetMapping()
	public ResponseEntity<List<ConsumableProjection>> getAllConsumable() {
		return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
	}
}

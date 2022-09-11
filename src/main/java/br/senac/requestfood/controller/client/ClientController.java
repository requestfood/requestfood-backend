package br.senac.requestfood.controller.client;

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

import br.senac.requestfood.dto.client.AllClientDTO;
import br.senac.requestfood.dto.client.ClientUpdateDTO;
import br.senac.requestfood.projection.client.ClientProjection;
import br.senac.requestfood.service.client.ClientService;


@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/client")

public class ClientController {

    private final ClientService service;

	public ClientController(ClientService clientService) {
		this.service = clientService;
	}

	@PostMapping
	public ResponseEntity<AllClientDTO> addClientRegister(@RequestBody AllClientDTO dto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(dto));
	}

	@PutMapping("/{id}")
	public ResponseEntity<String> updatedClient(@RequestBody ClientUpdateDTO dto, @PathVariable(value = "id") Long id) {
		service.update(dto, id);
		return ResponseEntity.status(HttpStatus.OK).body("Client updated successfully");
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletedClient(@PathVariable(value = "id") Long id) {
		service.delete(id);
		return ResponseEntity.status(HttpStatus.OK).body("Client deleted successfully");
	}

	@GetMapping("/{id}")
	public ResponseEntity<ClientProjection> getClient(@PathVariable(value = "id") Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
	}

	@GetMapping()
	public ResponseEntity<List<ClientProjection>> getAllClient() {
		return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
	}
}

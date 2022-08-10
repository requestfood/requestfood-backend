package br.senac.requestfood.controller.cliente;

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

import br.senac.requestfood.dto.cliente.ClienteDTO;
import br.senac.requestfood.projection.cliente.ClienteProjection;
import br.senac.requestfood.service.cliente.ClientService;


@RestController
@CrossOrigin
@RequestMapping("/cliente")

public class ClienteController {

    private final ClientService clienteService;

	public ClienteController(ClientService clienteService) {
		this.clienteService = clienteService;
	}

	@PostMapping
	public ResponseEntity<ClienteDTO> addCliente(@RequestBody ClienteDTO clienteDTO) {
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.save(clienteDTO));
	}

	@PutMapping("/{id}")
	public ResponseEntity<String> updateCliente(@RequestBody ClienteDTO clienteDTO, @PathVariable(value = "id") Long id) {
		clienteService.update(clienteDTO, id);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCliente(@PathVariable(value = "id") Long id) {
		clienteService.delete(id);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ClienteProjection> getCliente(@PathVariable(value = "id") Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(clienteService.findById(id));
	}
}

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
import br.senac.requestfood.dto.order.CreateOrderDTO;
import br.senac.requestfood.dto.order.client.ClientOrdersDTO;
import br.senac.requestfood.enumeration.order.OrderStatus;
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
		//dto = service.encodePassword(dto);
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
	public ResponseEntity<ClientUpdateDTO> getClient(@PathVariable(value = "id") Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
	}

	@GetMapping()
	public ResponseEntity<List<ClientProjection>> getAllCLient() {
		return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
	}

	//CLIENT's ORDERS
	
	@GetMapping("/orders/{id}")
	public ResponseEntity<ClientOrdersDTO> getClientWithOrders(@PathVariable(value = "id") Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(service.findByIdWithOrders(id));
	}
	
	@GetMapping("/orders/{status}/{id}")
	public ResponseEntity<ClientOrdersDTO> getClientWithOrdersByStatus(@PathVariable(value = "status") OrderStatus status, @PathVariable(value = "id") Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(service.findByIdWithOrdersByStatus(id, status));
	}
	
	@GetMapping("/orders/{id}/establishment-name/{name}")
	public ResponseEntity<ClientOrdersDTO> getOrdersClientByEstablishmentName(@PathVariable(value = "id") Long id, @PathVariable(value = "name") String name) {
		return ResponseEntity.status(HttpStatus.OK).body(service.findByIdWithOrdersByEstablishmentName(id, name));
	}
	
	@GetMapping("/current-order/{id}")
	public ResponseEntity<CreateOrderDTO> getClientWithCurrentOrder(@PathVariable(value = "id") Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(service.findByIdWithCurrentOrder(id));
	}
	
}

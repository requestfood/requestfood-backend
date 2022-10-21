package br.senac.requestfood.controller.consumable;

import java.io.IOException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.senac.requestfood.dto.consumable.ConsumableImageDTO;
import br.senac.requestfood.dto.consumable.ConsumableRoleDTO;
import br.senac.requestfood.dto.dish.DishImageDTO;
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

	@GetMapping("/getImage/{id}")
	public ResponseEntity<ConsumableImageDTO> getDrinkImage(@PathVariable Long id) throws IOException {
		return ResponseEntity.status(HttpStatus.OK).body(service.findByIdImage(id));
	}
	
	@GetMapping()
	public ResponseEntity<List<ConsumableProjection>> getAllConsumables() {
		return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ConsumableProjection> getConsumable(@PathVariable(value = "id") Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
	}
	
	@GetMapping("/role/{id}")
	public ResponseEntity<ConsumableRoleDTO> getTypeConsumable(@PathVariable(value = "id") Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(service.findTypeById(id));
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteConsumable(@PathVariable(value = "id") Long id){
		service.delete(id);
		return ResponseEntity.status(HttpStatus.OK).body("Consumable delete Succesfully");
	}
	
}

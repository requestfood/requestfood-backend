package br.senac.requestfood.controller.establishment;

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

import br.senac.requestfood.dto.establishment.AllEstablishmentDTO;
import br.senac.requestfood.dto.establishment.EstablishmentPasswordDTO;
import br.senac.requestfood.projection.establishment.EstablishmentProjection;
import br.senac.requestfood.service.establishment.EstablishmentService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/establishment")

public class EstablishmentController {
    
    private final EstablishmentService service;

    public EstablishmentController(EstablishmentService establishmentService) {
		this.service = establishmentService;
	}

	@PostMapping
	public ResponseEntity<AllEstablishmentDTO> addEstablishment(@RequestBody AllEstablishmentDTO dto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(dto));
	}

	@PutMapping("/{id}")
	public ResponseEntity<String> updatedEstablishment(@RequestBody AllEstablishmentDTO dto, @PathVariable(value = "id") Long id) {
		service.update(dto, id);
		return ResponseEntity.status(HttpStatus.OK).body("Establishment update successfully");
	}

	@PutMapping("/{id}/password")
	public ResponseEntity<String> updatedPasswordEstablishment(@RequestBody EstablishmentPasswordDTO dto, @PathVariable(value = "id") Long id) {
		service.updatePassword(dto, id);
		return ResponseEntity.status(HttpStatus.OK).body("Password update successfully");
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletedEstablishment(@PathVariable(value = "id") Long id) {
		service.delete(id);
		return ResponseEntity.status(HttpStatus.OK).body("Establishment deleted successfully");
	}

	@GetMapping("/{id}")
	public ResponseEntity<EstablishmentProjection> getEstablishment(@PathVariable(value = "id") Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
	}

	@GetMapping("/search-name/{name}")
	public ResponseEntity<List<EstablishmentProjection>> getEstablishmentByName(@PathVariable(value = "name") String name) {
		return ResponseEntity.status(HttpStatus.OK).body(service.findEstablishmentByName(name));
	}
	
	@GetMapping()
	public ResponseEntity<List<EstablishmentProjection>> getAllEstablishment() {
		return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
	}
}

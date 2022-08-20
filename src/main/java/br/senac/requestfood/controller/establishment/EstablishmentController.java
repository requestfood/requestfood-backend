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

import br.senac.requestfood.dto.establishment.EstablishmentDTO;
import br.senac.requestfood.dto.establishment.EstablishmentRegisterDTO;
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
	public ResponseEntity<EstablishmentRegisterDTO> addEstablishment(@RequestBody EstablishmentRegisterDTO dto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(dto));
	}

	@PutMapping("/{id}")
	public ResponseEntity<String> updatedEstablishmentDTO(@RequestBody EstablishmentRegisterDTO dto, @PathVariable(value = "id") Long id) {
		service.update(dto, id);
		return ResponseEntity.status(HttpStatus.OK).body("Establishment update successfully");
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

	@GetMapping()
	public ResponseEntity<List<EstablishmentProjection>> getAllEstablishment() {
		return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
	}
}

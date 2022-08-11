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

import br.senac.requestfood.dto.estabelecimento.EstabelecimentoDTO;
import br.senac.requestfood.projection.estabelecimento.EstabelecimentoProjection;
import br.senac.requestfood.service.establishment.EstablishmentService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/establishment")

public class EstablishmentController {
    
    private final EstablishmentService establishmentService;

    public EstablishmentController(EstablishmentService establishmentService) {
		this.establishmentService = establishmentService;
	}

	@PostMapping
	public ResponseEntity<EstabelecimentoDTO> Establishment(@RequestBody EstabelecimentoDTO establishmentDTO) {
		return ResponseEntity.status(HttpStatus.CREATED).body(establishmentService.save(establishmentDTO));
	}

	@PutMapping("/{id}")
	public ResponseEntity<String> updatedEstablishmentDTO(@RequestBody EstabelecimentoDTO establishmentDTO, @PathVariable(value = "id") Long id) {
		establishmentService.update(establishmentDTO, id);
		return ResponseEntity.status(HttpStatus.OK).body("Establishment update successfully");
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletedEstablishment(@PathVariable(value = "id") Long id) {
		establishmentService.delete(id);
		return ResponseEntity.status(HttpStatus.OK).body("Establishment deleted successfully");
	}

	@GetMapping("/{id}")
	public ResponseEntity<EstabelecimentoProjection> getEstablishment(@PathVariable(value = "id") Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(establishmentService.findById(id));
	}

	@GetMapping()
	public ResponseEntity<List<EstabelecimentoProjection>> getAllEstablishment() {
		return ResponseEntity.status(HttpStatus.OK).body(establishmentService.findAll());
	}
}

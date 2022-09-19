package br.senac.requestfood.controller.establishment;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

import br.senac.requestfood.dto.establishment.EstablishmentAllDTO;
import br.senac.requestfood.dto.establishment.EstablishmentWithConsumablesDTO;
import br.senac.requestfood.projection.establishment.EstablishmentCardProjection;
import br.senac.requestfood.projection.establishment.EstablishmentProjection;
import br.senac.requestfood.projection.establishment.EstablishmentWithOrderProjection;
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
	public ResponseEntity<EstablishmentAllDTO> addEstablishment(@RequestBody EstablishmentAllDTO dto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(dto));
	}

	@PutMapping("/{id}")
	public ResponseEntity<String> updatedEstablishment(@RequestBody EstablishmentAllDTO dto, @PathVariable(value = "id") Long id) {
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

	@GetMapping("/search-name/{name}")
	public ResponseEntity<List<EstablishmentCardProjection>> getEstablishmentByName(@PathVariable(value = "name") String name) {
		return ResponseEntity.status(HttpStatus.OK).body(service.findByName(name));
	}
	
	@GetMapping("/name/a-z/{page}")
	public ResponseEntity<Page<EstablishmentCardProjection>> getEstablishmentByNameByOrderByAsc(Pageable pageable,@PathVariable(value = "page") Integer page){
		return ResponseEntity.status(HttpStatus.OK).body(service.findNameByOrderByAsc(pageable, page));
	}
	
	@GetMapping("/name/z-a/{page}")
	public ResponseEntity<Page<EstablishmentCardProjection>> getEstablishmentByNameByOrderByDesc(Pageable pageable,@PathVariable(value = "page") Integer page){
		return ResponseEntity.status(HttpStatus.OK).body(service.findNameByOrderByDesc(pageable, page));
	}
	
	@GetMapping("/card/{page}")
	public ResponseEntity<Page<EstablishmentCardProjection>> getAllEstablishmentCard(Pageable pageable,@PathVariable(value = "page") Integer page) {
		return ResponseEntity.status(HttpStatus.OK).body(service.findAllToCard(pageable, page));
	}
	
	@GetMapping("/with-consumables/{id}")
	public ResponseEntity<EstablishmentWithConsumablesDTO> getEstablishmentWithConsumables(@PathVariable(value = "id") Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(service.findByIdWithConsumable(id));
	}
	
	@GetMapping("/with-orders/{id}")
	public ResponseEntity<EstablishmentWithOrderProjection> getEstablishmentWithOrdes(@PathVariable(value = "id") Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(service.findByIdWithOrder(id));
	}
	
	@GetMapping("/getOpen/{id}")
	public ResponseEntity<EstablishmentProjection> getEstablishmentOpen(@PathVariable(value = "id") Long id) {
		service.setOpen(id);
		return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
	}
}

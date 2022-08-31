package br.senac.requestfood.controller.consumable;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

	@GetMapping("/{id}")
	public ResponseEntity<ConsumableProjection> getConsumable(@PathVariable(value = "id") Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
	}

	@GetMapping("/search-name/{name}")
	public ResponseEntity<Page<ConsumableProjection>> getConsumableByName(@PathVariable(value = "name") String name, Pageable pageable) {
		return ResponseEntity.status(HttpStatus.OK).body(service.findByName(name, pageable));
	}
	
	@GetMapping("/price/minor-to-major/{page}")
	public ResponseEntity<Page<ConsumableProjection>> getAllConsumableByOrderByPriceByAsc(Pageable pageable, @PathVariable(value= "page") Integer page){
		return ResponseEntity.status(HttpStatus.OK).body(service.findByPriceByOrdemByAsc(pageable, page));
	}
	
	@GetMapping("/price/major-to-minor/{page}")
	public ResponseEntity<Page<ConsumableProjection>> getAllConsumableByOrderByPriceByDesc(Pageable pageable, @PathVariable(value= "page") Integer page){
		return ResponseEntity.status(HttpStatus.OK).body(service.findByPriceByOrdemByDesc(pageable, page));
	}
	
	@GetMapping("/page/{page}")
	public ResponseEntity<Page<ConsumableProjection>> getAllConsumable(Pageable pageable,@PathVariable(value = "page") Integer page) {
		return ResponseEntity.status(HttpStatus.OK).body(service.findAll(pageable, page));
	}
	
	@GetMapping()
	public ResponseEntity<List<ConsumableProjection>> getAllConsumables() {
		return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
	}
}

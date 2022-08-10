package br.senac.requestfood.controller.additionalItem;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.senac.requestfood.dto.itemadicional.ItemAdicionalDTO;
import br.senac.requestfood.projection.itemAdicional.ItemAdicionalProjection;
import br.senac.requestfood.service.additionalitem.AdditionalItemService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/additionalitem")

public class AdditionalItemController
    
	private final AdditionalItemService additionalItemService;

	public AdditionalItemController(AdditionalItemService additionalItemService) {
		this.additionalItemService = additionalItemService;
	}

	@PostMapping
	public ResponseEntity<ItemAdicionalDTO> addItemAdicional(@RequestBody ItemAdicionalDTO additionalItemDTO) {
		return ResponseEntity.status(HttpStatus.CREATED).body(additionalItemService.save(additionalItemDTO));
	}

	@PutMapping("/{id}")
	public ResponseEntity<String> updateItemAdicional(@RequestBody ItemAdicionalDTO additionalItemDTO, @PathVariable(value = "id") Long id) {
		additionalItemService.update(additionalItemDTO, id);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteItemAdicional(@PathVariable(value = "id") Long id) {
		additionalItemService.delete(id);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ItemAdicionalProjection> getItemAdicional(@PathVariable(value = "id") Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(additionalItemService.findById(id));
	}
}

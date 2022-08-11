package br.senac.requestfood.controller.contact;

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

import br.senac.requestfood.dto.contato.ContatoDTO;
import br.senac.requestfood.projection.contato.ContatoProjection;
import br.senac.requestfood.service.contact.ContactService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/contact")

public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
		this.contactService = contactService;
	}

    @PostMapping
	public ResponseEntity<ContatoDTO> addContact(@RequestBody ContatoDTO contactDTO) {
		return ResponseEntity.status(HttpStatus.CREATED).body(contactService.save(contactDTO));
	}

    @PutMapping("/{id}")
	public ResponseEntity<String> updatedContact(@RequestBody ContatoDTO contactDTO, @PathVariable(value = "id") Long id) {
		contactService.update(contactDTO, id);
		return ResponseEntity.status(HttpStatus.OK).body("Contact updated successfully");
	}

    @DeleteMapping("/{id}")
	public ResponseEntity<String> deletedContact(@PathVariable(value = "id") Long id) {
		contactService.delete(id);
		return ResponseEntity.status(HttpStatus.OK).body("Contact deleted successfully");
	}

    @GetMapping("/{id}")
	public ResponseEntity<ContatoProjection> getContact(@PathVariable(value = "id") Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(contactService.findById(id));
	}

	@GetMapping()
	public ResponseEntity<List<ContatoProjection>> getAllContact() {
		return ResponseEntity.status(HttpStatus.OK).body(contactService.findAll());
	}
}

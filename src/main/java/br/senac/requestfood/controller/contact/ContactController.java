package br.senac.requestfood.controller.contact;

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
@CrossOrigin
@RequestMapping("/contact")

public class ContactController {
    private final ContactController contactService;

    public ContactController(ContactService contactService) {
		this.contactService = contactService;
	}

    @PostMapping
	public ResponseEntity<ContatoDTO> addContact(@RequestBody ContatoDTO contatoDTO) {
		return ResponseEntity.status(HttpStatus.CREATED).body(contactService.save(contatoDTO));
	}

    @PutMapping("/{id}")
	public ResponseEntity<String> updateContact(@RequestBody ContatoDTO contatoDTO, @PathVariable(value = "id") Long id) {
		contactService.update(contatoDTO, id);
	}

    @DeleteMapping("/{id}")
	public ResponseEntity<String> deleteContact(@PathVariable(value = "id") Long id) {
		contactService.delete(id);
	}

    @GetMapping("/{id}")
	public ResponseEntity<ContatoProjection> getContact(@PathVariable(value = "id") Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(contactService.findById(id));
	}
}

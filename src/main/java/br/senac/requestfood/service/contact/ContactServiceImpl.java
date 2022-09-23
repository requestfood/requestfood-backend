package br.senac.requestfood.service.contact;

import java.util.List;

import org.springframework.stereotype.Service;

import br.senac.requestfood.dto.contact.ContactDTO;
import br.senac.requestfood.exception.contact.ContactEmailRegisteredException;
import br.senac.requestfood.exception.contact.ContactNotFoundException;
import br.senac.requestfood.exception.contact.ContactPhoneRegisteredException;
import br.senac.requestfood.model.contact.Contact;
import br.senac.requestfood.projection.contact.ContactProjection;
import br.senac.requestfood.repository.contact.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {

	private final ContactRepository repository;
	
	public ContactServiceImpl(ContactRepository repository) {
		this.repository = repository;
	}
	
	public void update(ContactDTO dto, Long id) {
		
		Contact contact = repository.findById(id).orElseThrow(() -> new ContactNotFoundException("Contact "+ id +" was not found."));
		
		if(!dto.phone().equals(contact.getPhone())) {			
			if (repository.existsByPhone(dto.phone())) 
				throw new ContactPhoneRegisteredException("Phone "+ dto.phone() +" is already registered");
		}
		if(!dto.email().equals(contact.getEmail())) {			
			if (repository.existsByEmail(dto.email())) 
				throw new ContactEmailRegisteredException("Email "+ dto.email() +" is already registered");
		}
		
		contact.setEmail(dto.email());
		contact.setPhone(dto.phone());
		
		repository.save(contact);
	}
	
	public void delete(Long id) {

		if (!repository.existsById(id))
			throw new ContactNotFoundException("Contact "+ id +" was not found");

		repository.deleteById(id);
	}
	
	public ContactProjection findById(Long id) {

		ContactProjection contact = repository.findContactById(id).orElseThrow(() -> new ContactNotFoundException("Contact "+ id +" was not found."));
		
		return contact;
	}
	
	public List<ContactProjection> findAll() {

		return repository.findContacts();
	}
}

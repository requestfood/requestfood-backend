package br.senac.requestfood.service.contact;

import java.util.List;

import org.springframework.stereotype.Service;

import br.senac.requestfood.dto.contact.ContactDTO;
import br.senac.requestfood.exception.contact.ContactEmailRegisteredException;
import br.senac.requestfood.exception.contact.ContactNotFoundException;
import br.senac.requestfood.exception.contact.ContactPhoneRegisteredException;
import br.senac.requestfood.model.contact.Contact;
import br.senac.requestfood.projection.contact.ContactProjection;
import br.senac.requestfood.projection.user.UserProjection;
import br.senac.requestfood.repository.contact.ContactRepository;
import br.senac.requestfood.repository.user.UserRepository;

@Service
public class ContactServiceImpl implements ContactService {

	private final ContactRepository repository;
	private final UserRepository userRepository;
	
	public ContactServiceImpl(ContactRepository repository, UserRepository userRepository) {
		this.repository = repository;
		this.userRepository = userRepository;
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

		UserProjection user = userRepository.findUserById(id).orElseThrow(() -> new ContactNotFoundException("Contact "+ id +" was not found."));
		
		return user.getContact();
	}
	
	public List<ContactProjection> findAll() {

		return repository.findContacts();
	}
}

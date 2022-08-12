package br.senac.requestfood.service.contact;

import java.util.List;

import org.springframework.stereotype.Service;

import br.senac.requestfood.dto.contact.ContactDTO;
import br.senac.requestfood.exception.contact.ContactEmailRegisteredException;
import br.senac.requestfood.exception.contact.ContactNotFoundException;
import br.senac.requestfood.exception.contact.ContactPhoneRegisteredException;
import br.senac.requestfood.mapper.contact.ContactMapper;
import br.senac.requestfood.model.contact.Contact;
import br.senac.requestfood.projection.contact.ContactProjection;
import br.senac.requestfood.repository.contact.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {

	private final ContactRepository repository;
	private final ContactMapper mapper;
	
	public ContactServiceImpl(ContactRepository repository, ContactMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}
	
	public ContactDTO save(ContactDTO contactDTO) {
		
		if (repository.existsByEmail(contactDTO.email()))
			throw new ContactEmailRegisteredException("Email "+ contactDTO.email() +" is already registered.");
		
		if (repository.existsByPhone(contactDTO.phone()))
			throw new ContactPhoneRegisteredException("Phone "+ contactDTO.phone() +" is already registered.");
		
		Contact contact = mapper.toEntity(contactDTO);
		Contact contactSaved = repository.save(contact);
	
		
		return mapper.toDTO(contactSaved);
	}
	
	public void update(ContactDTO contactDTO, Long id) {
		
		Contact contact = repository.findById(id).orElseThrow(() -> new ContactNotFoundException("Contact "+ id +" was not found."));
		
		if (repository.existsByEmail(contactDTO.email()))
			throw new ContactEmailRegisteredException("Email "+ contactDTO.email() +" is already registered");
		
		contact.setEmail(contactDTO.email());
		contact.setPhone(contactDTO.phone());
		
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

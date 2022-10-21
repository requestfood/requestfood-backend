package br.senac.requestfood.mapper.contact;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.senac.requestfood.dto.contact.ContactDTO;
import br.senac.requestfood.model.contact.Contact;

@Service
public class ContactMapper {
	
	public ContactDTO toDTO(Contact contact) {
		return new ContactDTO(contact.getId(), contact.getPhone(), contact.getEmail());
	}
	
	public Contact toEntity(ContactDTO contactDTO) {
		return new Contact(contactDTO.id(), contactDTO.phone(), contactDTO.email());
	}
	
	public List<ContactDTO> toDTO(List<Contact> contacts){
		
		final List<ContactDTO> contactDTOs = new ArrayList<>();
		
		for (Contact contact : contacts) {
			contactDTOs.add(toDTO(contact));
		}
		
		return contactDTOs;
	}
	
	public List<Contact> toEntity(List<ContactDTO> contactDTOs) {
		
		final List<Contact> contacts = new ArrayList<>();
		
		for (ContactDTO contactDTO : contactDTOs) {
			contacts.add(toEntity(contactDTO));
		}
		
		return contacts;
	}
}

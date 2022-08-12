package br.senac.requestfood.service.contact;

import java.util.List;

import br.senac.requestfood.dto.contact.ContactDTO;
import br.senac.requestfood.projection.contact.ContactProjection;

public interface ContactService {
	
	ContactDTO save(ContactDTO contactDTO);
	
	void update(ContactDTO contactDTO, Long id);
	
	void delete(Long id);
	
	ContactProjection findById(Long id);
	
	List<ContactProjection> findAll();
}

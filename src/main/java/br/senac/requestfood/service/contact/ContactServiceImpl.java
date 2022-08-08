package br.senac.requestfood.service.contact;

import java.util.List;

import org.springframework.stereotype.Service;

import br.senac.requestfood.dto.contato.ContatoDTO;
import br.senac.requestfood.exception.contato.ContactNotFoundException;
import br.senac.requestfood.exception.contato.ContatoEmailRegisteredException;
import br.senac.requestfood.exception.contato.ContatoTelefoneRegisteredException;
import br.senac.requestfood.mapper.contato.ContatoMapper;
import br.senac.requestfood.model.contato.Contato;
import br.senac.requestfood.projection.contato.ContatoProjection;
import br.senac.requestfood.repository.contato.ContatoRepository;

@Service
public class ContactServiceImpl implements ContactService {

	private final ContatoRepository repository;
	private final ContatoMapper mapper;
	
	public ContactServiceImpl(ContatoRepository repository, ContatoMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}
	
	public ContatoDTO save(ContatoDTO contactDTO) {
		
		if (repository.existsByEmail(contactDTO.email()))
			throw new ContatoEmailRegisteredException("Email "+ contactDTO.email() +" is already registered.");
		
		if (repository.existsByTelefone(contactDTO.telefone()))
			throw new ContatoTelefoneRegisteredException("Telephone "+ contactDTO.telefone() +" is already registered.");
		
		Contato contact = mapper.toEntity(contactDTO);
		Contato contactSaved = repository.save(contact);
	
		
		return mapper.toDTO(contactSaved);
	}
	
	public void update(ContatoDTO contactDTO, Long id) {
		
		Contato contact = repository.findById(id).orElseThrow(() -> new ContactNotFoundException("Contact "+ id +" was not found."));
		
		if (repository.existsByEmail(contactDTO.email()))
			throw new ContatoEmailRegisteredException("Email "+ contactDTO.email() +" is already registered");
		
		contact.setEmail(contactDTO.email());
		contact.setTelefone(contactDTO.telefone());
		
		repository.save(contact);
	}
	
	public void delete(Long id) {

		if (!repository.existsById(id))
			throw new ContactNotFoundException("Contact "+ id +" was not found");

		repository.deleteById(id);
	}
	
	public ContatoProjection findById(Long id) {

		ContatoProjection contact = repository.findContactById(id).orElseThrow(() -> new ContactNotFoundException("Contact "+ id +" was not found."));
		
		return contact;
	}
	
	public List<ContatoProjection> findAll() {

		return repository.findContacts();
	}
}

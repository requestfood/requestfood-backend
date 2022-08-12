package br.senac.requestfood.service.client;

import java.util.List;

import org.springframework.stereotype.Service;

import br.senac.requestfood.dto.client.ClientDTO;
import br.senac.requestfood.exception.client.ClientNotFoundException;
import br.senac.requestfood.exception.client.ContactRegisteredException;
import br.senac.requestfood.mapper.client.ClientMapper;
import br.senac.requestfood.model.user.client.Client;
import br.senac.requestfood.projection.client.ClientProjection;
import br.senac.requestfood.projection.client.ClientWithCommandsProjection;
import br.senac.requestfood.repository.client.ClientRepository;

@Service
public class ClientServiceImpl implements ClientService {

	private final ClientRepository repository;
	private final ClientMapper mapper;
	
	public ClientServiceImpl (ClientRepository repository, ClientMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}
	
	public ClientDTO save(ClientDTO clientDTO) {
		
		if (repository.existsByContact(clientDTO.contact()))
			throw new ContactRegisteredException("Contact " + clientDTO.name() + " is already registered");
		
		Client client = mapper.toEntity(clientDTO);
		Client clientSaved = repository.save(client);
		
		return mapper.toDTO(clientSaved);
	}
	
	public void update(ClientDTO clientDTO, Long id) {
		
		Client client = repository.findById(id).orElseThrow(() -> new ClientNotFoundException("Client "+ id +" was not found"));
		
		if (repository.existsByContact(clientDTO.contact()))
			throw new ContactRegisteredException("Contact " + clientDTO.name() + " is already registered");
		
		client.setName(clientDTO.name());
		client.setContact(clientDTO.contact());
		
		repository.save(client);
	}
	
	public void delete(Long id) {
		
		if(!repository.existsById(id))
			throw new ClientNotFoundException("Client "+ id +" was not found");
		
		repository.deleteById(id);
	}
	
	public ClientProjection findById(Long id) {

		ClientProjection client = repository.findClientById(id).orElseThrow(() -> new ClientNotFoundException("Client "+ id +" was not found"));
		
		return client;
	}
	
	public ClientWithCommandsProjection findByidWithComandas(Long id) {

		ClientWithCommandsProjection client = repository.findClientWithCommandsById(id).orElseThrow(() -> new ClientNotFoundException("Client "+ id +" was not found"));
		
		return client;
	}
	
	public List<ClientProjection> findAll() {
		
		return repository.findClients();
	}
}

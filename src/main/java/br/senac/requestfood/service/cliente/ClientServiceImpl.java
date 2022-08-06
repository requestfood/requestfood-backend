package br.senac.requestfood.service.cliente;

import java.util.List;

import org.springframework.stereotype.Service;

import br.senac.requestfood.dto.cliente.ClienteDTO;
import br.senac.requestfood.exception.client.ClientContactRegisteredExeception;
import br.senac.requestfood.exception.client.ClientNotFoundException;
import br.senac.requestfood.mapper.cliente.ClienteMapper;
import br.senac.requestfood.model.usuario.cliente.Cliente;
import br.senac.requestfood.projection.cliente.ClienteProjection;
import br.senac.requestfood.projection.cliente.ClienteWithComandasProjection;
import br.senac.requestfood.repository.cliente.ClienteRepository;

@Service
public class ClientServiceImpl implements ClientService {

	private final ClienteRepository repository;
	private final ClienteMapper mapper;
	
	public ClientServiceImpl (ClienteRepository repository, ClienteMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}
	
	public ClienteDTO save(ClienteDTO clientDTO) {
		
		if (repository.existsByContact(clientDTO.contato()))
			throw new ClientContactRegisteredExeception("Contact " + clientDTO.nome() + " is already registered");
		
		Cliente client = mapper.toEntity(clientDTO);
		Cliente clientSaved = repository.save(client);
		
		return mapper.toDTO(clientSaved);
	}
	
	public void update(ClienteDTO clientDTO, Long id) {
		
		Cliente client = repository.findById(id).orElseThrow(() -> new ClientNotFoundException("Client "+ id +" was not found"));
		
		if (repository.existsByContact(clientDTO.contato()))
			throw new ClientContactRegisteredExeception("Contact " + clientDTO.nome() + " is already registered");
		
		client.setNome(clientDTO.nome());
		client.setContato(clientDTO.contato());
		
		repository.save(client);
	}
	
	public void delete(Long id) {
		
		if(!repository.existsById(id))
			throw new ClientNotFoundException("Client "+ id +" was not found");
		
		repository.deleteById(id);
	}
	
	public ClienteProjection findById(Long id) {

		ClienteProjection client = repository.findClientById(id).orElseThrow(() -> new ClientNotFoundException("Client "+ id +" was not found"));
		
		return client;
	}
	
	public ClienteWithComandasProjection findByidWithComandas(Long id) {

		ClienteWithComandasProjection client = repository.findClientWithCommandById(id).orElseThrow(() -> new ClientNotFoundException("Client "+ id +" was not found"));
		
		return client;
	}
	
	public List<ClienteProjection> findAll() {
		
		return repository.findClients();
	}
}

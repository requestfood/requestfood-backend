package br.senac.requestfood.service.client;

import java.util.List;

import org.springframework.stereotype.Service;

import br.senac.requestfood.dto.client.AllClientDTO;
import br.senac.requestfood.dto.client.ClientPasswordDTO;
import br.senac.requestfood.exception.client.ClientNotFoundException;
import br.senac.requestfood.mapper.client.ClientMapper;
import br.senac.requestfood.model.user.client.Client;
import br.senac.requestfood.projection.client.ClientProjection;
import br.senac.requestfood.projection.client.ClientWithOrdersProjection;
import br.senac.requestfood.repository.client.ClientRepository;

@Service
public class ClientServiceImpl implements ClientService {

	private final ClientRepository repository;
	private final ClientMapper mapper;
	
	public ClientServiceImpl (ClientRepository repository, ClientMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}
	
	public AllClientDTO save(AllClientDTO dto) {
		
		Client client = mapper.AllToEntity(dto);
		Client clientSaved = repository.save(client);
		
		return mapper.AllToDTO(clientSaved);
	}
	
	public void update(AllClientDTO dto, Long id) {
		
		Client client = repository.findById(id).orElseThrow(() -> new ClientNotFoundException("Client "+ id +" was not found"));
		
		client.setName(dto.name());
		client.setSurname(dto.surname());
		client.setGender(dto.gender());
		client.getContact().setPhone(dto.phone());
		
		repository.save(client);
	}
	
	public void updatePassword(ClientPasswordDTO dto, Long id) {
		
		Client client = repository.findById(id).orElseThrow(() -> new ClientNotFoundException("Client "+ id +" was not found"));

		client.setPassword(dto.newPassword());
		
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

	public ClientWithOrdersProjection findByIdWithOrders(Long id) {

		ClientWithOrdersProjection client = repository.findClientWithOrdersById(id).orElseThrow(() -> new ClientNotFoundException("Client "+ id +" was not found"));
		
		return client;
	}
	
	public List<ClientProjection> findAll() {
		
		return repository.findClients();
	}
}

package br.senac.requestfood.service.client;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.senac.requestfood.dto.client.AllClientDTO;
import br.senac.requestfood.dto.client.ClientOrdersDTO;
import br.senac.requestfood.dto.order.client.OrderToClientDTO;
import br.senac.requestfood.exception.client.ClientNotFoundException;
import br.senac.requestfood.exception.contact.ContactEmailRegisteredException;
import br.senac.requestfood.exception.contact.ContactPhoneRegisteredException;
import br.senac.requestfood.mapper.client.ClientMapper;
import br.senac.requestfood.model.user.client.Client;
import br.senac.requestfood.projection.client.ClientProjection;
import br.senac.requestfood.projection.client.ClientWithOrdersProjection;
import br.senac.requestfood.projection.order.OrderProjection;
import br.senac.requestfood.repository.client.ClientRepository;
import br.senac.requestfood.repository.contact.ContactRepository;

@Service
public class ClientServiceImpl implements ClientService {

	private final ClientRepository repository;
	private final ClientMapper mapper;
	private final PasswordEncoder encoder;
	private final ContactRepository contactRepository;
	
	public ClientServiceImpl (ClientRepository repository, ClientMapper mapper, PasswordEncoder encoder, ContactRepository contactRepository) {
		this.repository = repository;
		this.mapper = mapper;
		this.encoder = encoder;
		this.contactRepository = contactRepository;
	}
	
	public AllClientDTO save(AllClientDTO dto) {
		
		if(contactRepository.existsByEmail(dto.email())) {
			throw new ContactEmailRegisteredException("Email "+ dto.email() +" is already registered.");
		}
		if(contactRepository.existsByPhone(dto.phone())) {
			throw new ContactPhoneRegisteredException("Phone "+ dto.phone() +" is already registered.");
		}
		
		Client client = mapper.AllToEntity(dto);
		Client clientSaved = repository.save(client);
		
		return mapper.AllToDTO(clientSaved);
	}
	
	public void update(AllClientDTO dto, Long id) {
		
		Client client = repository.findById(id).orElseThrow(() -> new ClientNotFoundException("Client "+ id +" was not found"));
		
		client.setName(dto.name());
		client.setSurname(dto.surname());
		client.setGender(dto.gender());
		
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

	public ClientOrdersDTO findByIdWithOrders(Long id) {

		ClientWithOrdersProjection client = repository.findClientWithOrdersById(id).orElseThrow(() -> new ClientNotFoundException("Client "+ id +" was not found"));
		
		List<OrderToClientDTO> dtos = new ArrayList<>();
		List<OrderProjection> orders = client.getOrders();
		
		for (OrderProjection order : orders) {
			dtos.add(new OrderToClientDTO(order.getId(), order.getEstablishment().getImage(), order.getEstablishment().getName(), order.getOrderStatus(), order.getIssueDate()));
		}
		
		return new ClientOrdersDTO(client.getId() ,dtos);
	}

	public AllClientDTO encodePassword(AllClientDTO clientDTO) {
		
		Client client = mapper.AllToEntity(clientDTO);
		
		client.setPassword(encoder.encode(client.getPassword()));
		
		return mapper.AllToDTO(client);
		
	}

	public List<ClientProjection> findAll() {
		return repository.findClients();
	}
	
}

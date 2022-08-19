package br.senac.requestfood.mapper.client;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.senac.requestfood.dto.client.ClientDTO;
import br.senac.requestfood.dto.client.ClientRegisterDTO;
import br.senac.requestfood.model.contact.Contact;
import br.senac.requestfood.model.user.client.Client;

@Service
public class ClientMapper {
	
	public ClientDTO toDTO(Client client) {
		return new ClientDTO(client.getId(), client.getName(), client.getContact(), client.getPassword(), client.getSurname(), client.getGender(), client.getBirthDate());
	}
	
	public Client toEntity(ClientDTO dto) {
		return new Client(dto.id(), dto.name(), dto.contact(), dto.password(), dto.surname(), dto.gender(), dto.birthDate());
	}
	
	public ClientRegisterDTO RegisterToDTO(Client client) {
		return new ClientRegisterDTO(client.getId(), client.getName(), client.getContact().getPhone(), client.getContact().getEmail(), client.getPassword(), client.getSurname(), client.getGender(), client.getBirthDate());
	}
	
	public Client RegisterToEntity(ClientRegisterDTO dto) {	
		Contact contact = new Contact(dto.id(), dto.phone(), dto.email());
		return new Client(dto.id(), dto.name(), contact, dto.password(), dto.surname(), dto.gender(), dto.birthDate());
	}

	public List<ClientDTO> toDTO(List<Client> clients){
		
		final List<ClientDTO> clientDTOs = new ArrayList<>();
		
		for (Client client : clients) {
			clientDTOs.add(toDTO(client));
		}
		
		return clientDTOs;
	}
	
	public List<Client> toEntity(List<ClientDTO> clientDTOs) {
		
		final List<Client> clients= new ArrayList<>();
		
		for (ClientDTO clientDTO : clientDTOs) {
			clients.add(toEntity(clientDTO));
		}
		
		return clients;
	}
}

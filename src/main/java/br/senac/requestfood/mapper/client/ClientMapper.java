package br.senac.requestfood.mapper.client;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.senac.requestfood.dto.client.ClientDTO;
import br.senac.requestfood.dto.client.AllClientDTO;
import br.senac.requestfood.model.contact.Contact;
import br.senac.requestfood.model.user.client.Client;

@Service
public class ClientMapper {
	
	public ClientDTO toDTO(Client client) {
		return new ClientDTO(client.getId(), client.getName(), client.getContact(), client.getSurname(), client.getGender(), client.getBirthDate());
	}
	
	public Client toEntity(AllClientDTO dto) {
		Contact contact = new Contact(dto.id(), dto.phone(), dto.email());
		return new Client(dto.id(), dto.name(), contact, dto.password(), dto.surname(), dto.gender(), dto.birthDate());
	}
	
	public AllClientDTO AllToDTO(Client client) {
		return new AllClientDTO(client.getId(), client.getName(), client.getContact().getPhone(), client.getContact().getEmail(), client.getPassword(), client.getSurname(), client.getGender(), client.getBirthDate());
	}
	
	public Client AllToEntity(AllClientDTO dto) {	
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
	
	public List<Client> toEntity(List<AllClientDTO> DTOs) {
		
		final List<Client> clients= new ArrayList<>();
		
		for (AllClientDTO AllClientDTO : DTOs) {
			clients.add(toEntity(AllClientDTO));
		}
		
		return clients;
	}
}

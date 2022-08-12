package br.senac.requestfood.mapper.client;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.senac.requestfood.dto.client.ClientDTO;
import br.senac.requestfood.model.user.client.Client;

@Service
public class ClientMapper {
	
	public ClientDTO toDTO(Client client) {
		return new ClientDTO(client.getId(), client.getName(), client.getContact());
	}
	
	public Client toEntity(ClientDTO clientDTO) {
	//Not Completed, waiting response for Front-End
		return null;
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

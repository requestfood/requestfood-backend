package br.senac.requestfood.mapper.cliente;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.senac.requestfood.dto.cliente.ClienteDTO;
import br.senac.requestfood.model.consumivel.bebida.Bebida;
import br.senac.requestfood.model.usuario.cliente.Cliente;

@Service
public class ClienteMapper {
	
	public ClienteDTO toDTO(Cliente cliente) {
		return new ClienteDTO(cliente.getId(), cliente.getNome(), cliente.getContato());
	}
	
	public void toEntity(ClienteDTO clienteDTO) {
	//Not Completed, waiting response for Front-End
	}

	public List<ClienteDTO> toDTO(List<Cliente> clientes){
		
		final List<ClienteDTO> clienteDTOs = new ArrayList<>();
		
		for (Cliente cliente : clientes) {
			clienteDTOs.add(toDTO(cliente));
		}
		
		return clienteDTOs;
	}
	
	public List<Cliente> toEntity(List<ClienteDTO> clienteDTOs) {
		
		final List<Cliente> clientes= new ArrayList<>();
		
		for (ClienteDTO clienteDTO : clienteDTOs) {
		//	clientes.add(toEntity(clienteDTO));
		}
		
		return clientes;
	}
}

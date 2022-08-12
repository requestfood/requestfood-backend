package br.senac.requestfood.service.client;

import java.util.List;

import br.senac.requestfood.dto.client.ClientDTO;
import br.senac.requestfood.projection.client.ClientProjection;
import br.senac.requestfood.projection.client.ClientWithCommandsProjection;

public interface ClientService {
	
	ClientDTO save(ClientDTO clientDTO);
	
	void update(ClientDTO clientDTO, Long id);
	
	void delete(Long id);
	
	ClientProjection findById(Long id);
	
	ClientWithCommandsProjection findByidWithComandas(Long id);
	
	List<ClientProjection> findAll();
	
}

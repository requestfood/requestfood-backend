package br.senac.requestfood.service.client;

import java.util.List;

import br.senac.requestfood.dto.client.ClientRegisterDTO;
import br.senac.requestfood.projection.client.ClientProjection;
import br.senac.requestfood.projection.client.ClientWithOrdersProjection;

public interface ClientService {
	
	ClientRegisterDTO save(ClientRegisterDTO clientDTO);
	
	void update(ClientRegisterDTO clientDTO, Long id);
	
	void delete(Long id);
	
	ClientProjection findById(Long id);
	
	ClientWithOrdersProjection findByIdWithOrders(Long id);
	
	List<ClientProjection> findAll();
	
}

package br.senac.requestfood.service.client;

import java.util.List;

import br.senac.requestfood.dto.client.AllClientDTO;
import br.senac.requestfood.dto.client.ClientOrdersDTO;
import br.senac.requestfood.dto.client.ClientUpdateDTO;
import br.senac.requestfood.projection.client.ClientProjection;

public interface ClientService {
	
	AllClientDTO save(AllClientDTO clientDTO);
	
	void update(ClientUpdateDTO clientDTO, Long id);
	
	void delete(Long id);
	
	AllClientDTO encodePassword (AllClientDTO clientDTO);
	
	ClientProjection findById(Long id);
	
	ClientOrdersDTO findByIdWithOrders(Long id);
	
	List<ClientProjection> findAll();
	
}

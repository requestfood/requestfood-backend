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
	
	ClientUpdateDTO findById(Long id);
	
	ClientOrdersDTO findByIdWithOrders(Long id);
	
	Long findByIdWithCurrentOrder(Long id);
	
	ClientOrdersDTO findByWithOrdersByEstablishmentName(Long id, String name);
	
	List<ClientProjection> findAll();
	
}

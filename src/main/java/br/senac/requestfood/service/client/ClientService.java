package br.senac.requestfood.service.client;

import java.util.List;

import br.senac.requestfood.dto.client.AllClientDTO;
import br.senac.requestfood.dto.client.ClientUpdateDTO;
import br.senac.requestfood.dto.order.CreateOrderDTO;
import br.senac.requestfood.dto.order.client.ClientOrdersDTO;
import br.senac.requestfood.enumeration.order.OrderStatus;
import br.senac.requestfood.projection.client.ClientProjection;

public interface ClientService {
	
	AllClientDTO save(AllClientDTO clientDTO);
	
	void update(ClientUpdateDTO clientDTO, Long id);
	
	void delete(Long id);
	
	AllClientDTO encodePassword (AllClientDTO clientDTO);
	
	ClientUpdateDTO findById(Long id);
	
	ClientOrdersDTO findByIdWithOrders(Long id);
	
	CreateOrderDTO findByIdWithCurrentOrder(Long id);
	
	ClientOrdersDTO findByIdWithOrdersByEstablishmentName(Long id, String name);
	
	ClientOrdersDTO findByIdWithOrdersByStatus(Long id, OrderStatus status);
	
	List<ClientProjection> findAll();
	
}

package br.senac.requestfood.service.client;

import java.util.List;

import br.senac.requestfood.dto.client.AllClientDTO;
import br.senac.requestfood.dto.order.OrderByClientDTO;
import br.senac.requestfood.projection.client.ClientProjection;

public interface ClientService {
	
	AllClientDTO save(AllClientDTO clientDTO);
	
	void update(AllClientDTO clientDTO, Long id);
	
	void delete(Long id);
	
	AllClientDTO encodePassword (AllClientDTO clientDTO);
	
	ClientProjection findById(Long id);
	
	OrderByClientDTO findByIdWithOrders(Long id);
	
	List<ClientProjection> findAll();
	
}

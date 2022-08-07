package br.senac.requestfood.service.cliente;

import java.util.List;

import br.senac.requestfood.dto.cliente.ClienteDTO;
import br.senac.requestfood.projection.cliente.ClienteProjection;
import br.senac.requestfood.projection.cliente.ClienteWithComandasProjection;

public interface ClientService {
	
	ClienteDTO save(ClienteDTO clientDTO);
	
	void update(ClienteDTO clientDTO, Long id);
	
	void delete(Long id);
	
	ClienteProjection findById(Long id);
	
	ClienteWithComandasProjection findByidWithComandas(Long id);
	
	List<ClienteProjection> findAll();
	
}

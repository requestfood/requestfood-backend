package br.senac.requestfood.service.order;

import java.util.List;

import br.senac.requestfood.dto.order.OrderDTO;
import br.senac.requestfood.projection.order.OrderProjection;
import br.senac.requestfood.projection.order.OrderWithClosingDateProjection;
import br.senac.requestfood.projection.order.OrderWithItemProjection;

public interface OrderService {
	
	OrderDTO save(OrderDTO orderDTO);
	
	void update(OrderDTO orderDTO, Long id);
	
	void delete(Long id);
	
	//Double valorTotal(Double valor); falar com o professor
	
	OrderProjection findById(Long id);
	
	OrderWithItemProjection findByIdWithItem(Long id);
	
	OrderWithClosingDateProjection findByIdWithClosingDate(Long id);
	
	List<OrderProjection> findAll();

}

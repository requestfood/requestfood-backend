package br.senac.requestfood.service.order;

import java.util.List;

import br.senac.requestfood.dto.order.CreateOrderDTO;
import br.senac.requestfood.dto.order.OrderDTO;
import br.senac.requestfood.projection.order.OrderProjection;
import br.senac.requestfood.projection.order.OrderWithItemProjection;

public interface OrderService {
	
	OrderDTO save(CreateOrderDTO orderDTO);
	
	void update(OrderDTO orderDTO, Long id);
	
	void delete(Long id);
	
	void waitOrder(Long id);

	void preparOrder(Long id);
	
	void finishOrder(Long id);
	
	void cancelOrder(Long id);
		
	OrderProjection findById(Long id);
	
	OrderWithItemProjection findByIdWithItem(Long id);
	
	List<OrderProjection> findAll();
	
	List<OrderProjection> findAllByClient(String name);

}

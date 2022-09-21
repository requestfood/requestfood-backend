package br.senac.requestfood.service.order;

import java.util.List;

import br.senac.requestfood.dto.order.CreateOrderDTO;
import br.senac.requestfood.dto.order.OrderControlDTO;
import br.senac.requestfood.dto.order.OrderDTO;
import br.senac.requestfood.dto.order.OrderDetailsDTO;
import br.senac.requestfood.enumeration.order.OrderStatus;
import br.senac.requestfood.model.order.Order;
import br.senac.requestfood.projection.order.OrderProjection;
import br.senac.requestfood.projection.order.OrderWithItemProjection;

public interface OrderService {
	
	OrderDTO save(CreateOrderDTO orderDTO);
	
	void update(OrderDTO orderDTO, Long id);
	
	void delete(Long id);
	
	void alterOrderStatus(Long id, OrderStatus status);
	
	OrderProjection findById(Long id);
	
	OrderWithItemProjection findByIdWithItem(Long id);
	
	List<OrderProjection> findAll();
	
	List<OrderProjection> findAllByClient(String name);
	
	OrderControlDTO findByIdOrderControl(Long id);
	
	OrderDetailsDTO findByIdOrderDetails(Long id);
	
	Boolean checkDate(Order order);
	
	Boolean checkStatus(Order order);
	
}

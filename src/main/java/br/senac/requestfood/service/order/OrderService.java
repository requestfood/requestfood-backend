package br.senac.requestfood.service.order;

import java.util.List;

import br.senac.requestfood.dto.establishment.EstablishmentWithOrdersDTO;
import br.senac.requestfood.dto.order.CreateOrderDTO;
import br.senac.requestfood.dto.order.client.OrderDetailsDTO;
import br.senac.requestfood.dto.order.establishment.OrderControlDTO;
import br.senac.requestfood.enumeration.order.OrderStatus;
import br.senac.requestfood.model.order.Order;
import br.senac.requestfood.projection.order.OrderProjection;

public interface OrderService {
	
	CreateOrderDTO save(CreateOrderDTO orderDTO);
	
	void delete(Long id);
	
	void alterOrderStatus(Long id, OrderStatus status);
	
	EstablishmentWithOrdersDTO findById(Long id, Long idOrder);
	
	List<OrderProjection> findAll();
	
	List<OrderProjection> findAllByClient(String name);
	
	OrderControlDTO findByIdOrderControl(Long id);
	
	OrderDetailsDTO findByIdOrderDetails(Long id);
	
	Boolean checkStatus(Order order);
	
}

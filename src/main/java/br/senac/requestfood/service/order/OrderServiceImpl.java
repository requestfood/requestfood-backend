package br.senac.requestfood.service.order;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import br.senac.requestfood.dto.order.CreateOrderDTO;
import br.senac.requestfood.dto.order.OrderDTO;
import br.senac.requestfood.enumeration.order.OrderStatus;
import br.senac.requestfood.exception.order.OrderLimitDeleteDoNotCatchUpException;
import br.senac.requestfood.exception.order.OrderNotFoundException;
import br.senac.requestfood.mapper.order.OrderMapper;
import br.senac.requestfood.model.order.Order;
import br.senac.requestfood.projection.order.OrderProjection;
import br.senac.requestfood.projection.order.OrderWithItemProjection;
import br.senac.requestfood.repository.order.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService{

    private final OrderRepository repository;
    private final OrderMapper mapper;

    public OrderServiceImpl (OrderRepository repository, OrderMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public OrderDTO save(CreateOrderDTO orderDTO) {
		
		final LocalDateTime issueDate = LocalDateTime.now();
		
		Order order = new Order(orderDTO.id(), orderDTO.establishment(), orderDTO.client(), issueDate, null, OrderStatus.WAITING);
		Order orderSaved = repository.save(order);
		
		return mapper.toDTO(orderSaved);
	}	

    
    public void update(OrderDTO orderDTO, Long id) {

        Order order = repository.findById(id).orElseThrow(() -> new OrderNotFoundException("Order " + id + " was not found"));

        order.setClient(orderDTO.client());
        order.setClosingDate(orderDTO.closingDate());
        order.setOrderStatus(orderDTO.orderStatus());

        repository.save(order);
    }

    public void delete(Long id) {
    	
    	Order order = repository.findById(id).orElseThrow(() -> new OrderNotFoundException("Order " + id + " was not found"));
    	
        if(!repository.existsById(id))
            throw new OrderNotFoundException("Order " + id + " was not found");           
        
        if((LocalDateTime.now().getDayOfMonth() - order.getClosingDate().getDayOfMonth()) < 1 )
        	throw new OrderLimitDeleteDoNotCatchUpException("Limit to delete order don't catch up.");
        
        repository.deleteById(id);
    }
    
    public OrderProjection findById(Long id) {
        OrderProjection order = repository.findOrderById(id).orElseThrow(() -> new OrderNotFoundException("Order " + id + " was not found"));
        return order;
    }

    public OrderWithItemProjection findByIdWithItem(Long id) {
        OrderWithItemProjection order = repository.findOrderWithItemById(id).orElseThrow(() -> new OrderNotFoundException("Item " + id + " was not found"));
        return order;
    }

    public List<OrderProjection> findAll() {
        return repository.findOrders();
    }

	public void waitOrder(Long id) {
		Order order = repository.findById(id).orElseThrow(() -> new OrderNotFoundException("Order " + id + " was not found"));
		order.waitingOrder();
	}
	public void preparOrder(Long id) {
		Order order = repository.findById(id).orElseThrow(() -> new OrderNotFoundException("Order " + id + " was not found"));
		order.preparOrder();		
	}
	public void finishOrder(Long id) {
		Order order = repository.findById(id).orElseThrow(() -> new OrderNotFoundException("Order " + id + " was not found"));
		order.setClosingDate(LocalDateTime.now());
		order.finishOrder();		
	}
	public void cancelOrder(Long id) {
		Order order = repository.findById(id).orElseThrow(() -> new OrderNotFoundException("Order " + id + " was not found"));
		order.cancelOrder();
	}

}

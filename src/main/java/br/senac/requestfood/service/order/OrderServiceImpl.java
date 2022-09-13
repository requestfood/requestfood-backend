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
		OrderStatus status = OrderStatus.WAITING;
		
		Order order = new Order(orderDTO.id(), orderDTO.establishment(), orderDTO.client(), issueDate, null, status);
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
    	
    	if(!checkStatus(order))
    		throw new OrderNotFoundException("You need cancel or finish order to delete");
        if(!checkDate(order))
        	throw new OrderLimitDeleteDoNotCatchUpException("Wait 24 hours to delete Order " + id);
    
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

	public void alterOrderStatus(Long id, OrderStatus status) {
		
		Order order = repository.findById(id).orElseThrow(() -> new OrderNotFoundException("Order " + id + " was not found"));
		order.setOrderStatus(status);
		
		if(status == OrderStatus.FINISHED) {
			order.setClosingDate(LocalDateTime.now());
		}
	
		repository.save(order);
	}

	public List<OrderProjection> findAllByClient(String name) {
		return repository.findOrderByClientName(name);
	}

	
	public Boolean checkDate(Order order) {
		
		if(order.getClosingDate().getYear() == LocalDateTime.now().getYear()) {
        	if(order.getClosingDate().getMonth() == LocalDateTime.now().getMonth()){	
        		
        		if(order.getClosingDate().getDayOfMonth() == LocalDateTime.now().getDayOfMonth()){	
        			return false;
        		
        		} else if(order.getClosingDate().getDayOfMonth() == LocalDateTime.now().getDayOfMonth() - 1){
        				
        			if((order.getClosingDate().getHour() - 24) + LocalDateTime.now().getHour() < 24)
        			 	return false;        		
        		}
        	}
        }
		
		return true;
	}
	
	public Boolean checkStatus(Order order) {
		
		if(order.getOrderStatus() == OrderStatus.WAITING || order.getOrderStatus() == OrderStatus.PREPARING)
    		return false;
		
		return true;
	}
}

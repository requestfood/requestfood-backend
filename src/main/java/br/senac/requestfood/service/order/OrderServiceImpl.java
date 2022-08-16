package br.senac.requestfood.service.order;

import java.util.List;

import org.springframework.stereotype.Service;

import br.senac.requestfood.dto.order.OrderDTO;
import br.senac.requestfood.exception.order.OrderNotFoundException;
import br.senac.requestfood.mapper.order.OrderMapper;
import br.senac.requestfood.model.order.Order;
import br.senac.requestfood.projection.order.OrderProjection;
import br.senac.requestfood.projection.order.OrderWithClosingDateProjection;
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

    public OrderDTO save(OrderDTO orderDTO) {

        Order order = mapper.toEntity(orderDTO);
        Order orderSaved = repository.save(order);

        return mapper.toDTO(orderSaved);
    }

    public void update(OrderDTO orderDTO, Long id) {

        Order order = repository.findById(id).orElseThrow(() -> new OrderNotFoundException("Order " + id + " was not found"));

        order.setClient(orderDTO.client());
        order.setIssueDate(orderDTO.issueDate());
        order.setClosingDate(orderDTO.closingDate());
        order.setAmount(orderDTO.value());

        repository.save(order);
    }


    public void delete(Long id) {
        if(!repository.existsById(id))
            throw new OrderNotFoundException("Order " + id + " was not found");
    }

    public OrderProjection findById(Long id) {
        OrderProjection order = repository.findOrderById(id).orElseThrow(() -> new OrderNotFoundException("Order " + id + " was not found"));
        return order;
    }

    public OrderWithItemProjection findByIdWithItem(Long id) {
        OrderWithItemProjection order = repository.findOrderWithItemById(id).orElseThrow(() -> new OrderNotFoundException("Item " + id + " was not found"));
        return order;
    }

    public OrderWithClosingDateProjection findByIdWithClosingDate(Long id) {
        OrderWithClosingDateProjection order = repository.findOrderWithClosingDate(id).orElseThrow(() -> new OrderNotFoundException("Item " + id + " was not found"));
        return order;
    }

    public List<OrderProjection> findAll() {
        return repository.findOrders();
    }

}

package br.senac.requestfood.service.order;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.senac.requestfood.dto.item.ItemDetailsDTO;
import br.senac.requestfood.dto.order.CreateOrderDTO;
import br.senac.requestfood.dto.order.client.OrderDetailsDTO;
import br.senac.requestfood.dto.order.establishment.OrderControlDTO;
import br.senac.requestfood.enumeration.order.OrderStatus;
import br.senac.requestfood.exception.client.ClientNotFoundException;
import br.senac.requestfood.exception.establishment.EstablishmentNotFoundException;
import br.senac.requestfood.exception.order.OrderNotFoundException;
import br.senac.requestfood.mapper.order.OrderMapper;
import br.senac.requestfood.model.item.Item;
import br.senac.requestfood.model.order.Order;
import br.senac.requestfood.model.user.client.Client;
import br.senac.requestfood.model.user.establishment.Establishment;
import br.senac.requestfood.projection.order.OrderProjection;
import br.senac.requestfood.repository.client.ClientRepository;
import br.senac.requestfood.repository.establisment.EstablishmentRepository;
import br.senac.requestfood.repository.order.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService{

    private final OrderRepository repository;
    private final OrderMapper mapper;
    private final EstablishmentRepository establishmentRepository;
    private final ClientRepository clientRepository;

    public OrderServiceImpl (OrderRepository repository, OrderMapper mapper, 
    		EstablishmentRepository establishmentRepository, ClientRepository clientRepository) {
        this.repository = repository;
        this.mapper = mapper;
        this.clientRepository = clientRepository;
        this.establishmentRepository = establishmentRepository;
    }

    public CreateOrderDTO save(CreateOrderDTO orderDTO) {
		
		final LocalDateTime issueDate = LocalDateTime.now();
		OrderStatus status = OrderStatus.WAITING;
		
		Establishment establishment = establishmentRepository.findById(orderDTO.idEstablishment())
				.orElseThrow(() -> new EstablishmentNotFoundException("Establishment "+ orderDTO.idEstablishment() +" was not found"));
		Client client = clientRepository.findById(orderDTO.idClient())
				.orElseThrow(() -> new ClientNotFoundException("Client "+ orderDTO.idClient() +" was not found"));
		
		Order order = new Order(orderDTO.id(), establishment, client, issueDate, null, status);
		Order orderSaved = repository.save(order);
		
		return mapper.toDTO(orderSaved);
	}	

    public void delete(Long id) {
    	
    	Order order = repository.findById(id).orElseThrow(() -> new OrderNotFoundException("Order " + id + " was not found"));
    	
    	if(!checkStatus(order))
    		throw new OrderNotFoundException("You need cancel or finish order to delete");
    
    	repository.deleteById(id);
    }
    
    
    public OrderProjection findById(Long id) {
        OrderProjection order = repository.findOrderById(id).orElseThrow(() -> new OrderNotFoundException("Order " + id + " was not found"));
        return order;
    }

    public List<OrderProjection> findAll() {
        return repository.findOrders();
    }

	public void alterOrderStatus(Long id, OrderStatus status) {
		
		Order order = repository.findById(id).orElseThrow(() -> new OrderNotFoundException("Order " + id + " was not found"));
		order.setOrderStatus(status);
		
		if(status == OrderStatus.READY || status == OrderStatus.FINISHED || status == OrderStatus.CANCELED) {
			order.setClosingDate(LocalDateTime.now());
		}
	
		repository.save(order);
	}

	public List<OrderProjection> findAllByClient(String name) {
		return repository.findOrderByClientName(name);
	}
	
	public Boolean checkStatus(Order order) {
		
		if(order.getOrderStatus() == OrderStatus.WAITING)
    		return false;
		
		return true;
	}

	public OrderDetailsDTO findByIdOrderDetails(Long id) {

		Order order = repository.findById(id).orElseThrow(() -> new OrderNotFoundException("Order " + id + " was not found"));
		
		List<Item> items = order.getItems();
		List<ItemDetailsDTO> itemDetails = new ArrayList<>();		
		
		for (Item item : items) {
			itemDetails.add(new ItemDetailsDTO(item.getConsumable().getName(), item.getSubTotal(), item.getQuantity(), item.getObservation()));
		}
		
		return new OrderDetailsDTO(order.getId(), order.getEstablishment().getName(), order.getIssueDate(), itemDetails, order.getAmount());
	}

	public OrderControlDTO findByIdOrderControl(Long id) {
		
		Order order = repository.findById(id).orElseThrow(() -> new OrderNotFoundException("Order " + id + " was not found"));		
		
		List<Item> items = order.getItems();
		List<ItemDetailsDTO> itemDetails = new ArrayList<>();		
		
		for (Item item : items)  {
			itemDetails.add(new ItemDetailsDTO(item.getConsumable().getName(), item.getSubTotal(), item.getQuantity(), item.getObservation()));
		}
		
		return new OrderControlDTO(order.getId(), order.getClient().getName(), order.getAmount(), itemDetails);
	}
}







package br.senac.requestfood.controller.order;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.senac.requestfood.dto.order.CreateOrderDTO;
import br.senac.requestfood.dto.order.OrderDTO;
import br.senac.requestfood.projection.order.OrderProjection;
import br.senac.requestfood.projection.order.OrderWithItemProjection;
import br.senac.requestfood.service.order.OrderService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/order")

public class OrderController {
    
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}

	@PostMapping
	public ResponseEntity<OrderDTO> addOrder(@RequestBody CreateOrderDTO orderDTO) {
		return ResponseEntity.status(HttpStatus.CREATED).body(orderService.save(orderDTO));
	}

	@PutMapping("/{id}")
	public ResponseEntity<String> updatedOrder(@RequestBody OrderDTO orderDTO, @PathVariable(value = "id") Long id) {
		orderService.update(orderDTO, id);
		return ResponseEntity.status(HttpStatus.OK).body("Order updated successfully");
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletedOrder(@PathVariable(value = "id") Long id) {
		orderService.delete(id);
		return ResponseEntity.status(HttpStatus.OK).body("Order deleted successfully");
	}

	@GetMapping("/{id}")
	public ResponseEntity<OrderProjection> getOrder(@PathVariable(value = "id") Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(orderService.findById(id));
	}

	@GetMapping()
	public ResponseEntity<List<OrderProjection>> getAllOrder() {
		return ResponseEntity.status(HttpStatus.OK).body(orderService.findAll());
	}
	
	@GetMapping("/with-items/{id}")
	public ResponseEntity<OrderWithItemProjection> getOrderWithItems(@PathVariable(value = "id") Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(orderService.findByIdWithItem(id));
	}
}

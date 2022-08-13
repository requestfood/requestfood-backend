package br.senac.requestfood.repository.order;

import java.util.List;
import java.util.Optional;

import br.senac.requestfood.model.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.senac.requestfood.projection.order.OrderProjection;
import br.senac.requestfood.projection.order.OrderWithClosureDateProjection;
import br.senac.requestfood.projection.order.OrderWithItemProjection;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

	Optional<OrderProjection> findOrderById(Long id);

	Optional<OrderWithItemProjection> findOrderWithItemById(Long id);

	Optional<OrderWithClosureDateProjection> findOrderWithClosureDate(Long id);
	
	@Query(value = "SELECT c.id AS id, c.client AS client, c.IssueDate AS issueDate, c.closingDate AS closingDate FROM Order c")
	List<OrderProjection> findOrders();
}

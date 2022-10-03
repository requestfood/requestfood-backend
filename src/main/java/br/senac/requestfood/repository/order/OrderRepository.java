package br.senac.requestfood.repository.order;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.senac.requestfood.enumeration.order.OrderStatus;
import br.senac.requestfood.model.order.Order;
import br.senac.requestfood.projection.order.OrderProjection;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

	Optional<OrderProjection> findOrderById(Long id);
	
	List<OrderProjection> findOrderByClientName(String name);

	Page<OrderProjection> findOrderByOrderStatus(Pageable pageable,OrderStatus orderstatus);
	
	List<OrderProjection> findAllByOrderStatusAndEstablishmentId(OrderStatus orderstatus, Long id);
	
	List<OrderProjection> findAllByClientIdAndEstablishmentNameContainingIgnoreCase(Long id, String name);
	
	@Query(value = "SELECT o.id AS id, o.establishment AS establishment, o.client AS client, o.issueDate AS issueDate, o.closingDate AS closingDate, o.orderStatus AS orderStatus FROM Order o")
	List<OrderProjection> findOrders();
}


package br.senac.requestfood.repository.item;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.senac.requestfood.model.item.Item;
import br.senac.requestfood.projection.item.ItemProjection;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

	Optional<ItemProjection> findItemById(Long id);
	
	@Query(value = "SELECT i.id AS id, i.order AS order, i.quantity AS quantity, i.consumable AS consumable, i.observation AS observation FROM Item i")
	List<ItemProjection> findItems();
}

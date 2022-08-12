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
	
	@Query(value = "SELECT i.id_item AS id, i.id_order AS order, i.quantity_item AS quantity, i.id_consumable AS consumable, i.observation_item AS observation FROM Item i")
	List<ItemProjection> findItems();
}

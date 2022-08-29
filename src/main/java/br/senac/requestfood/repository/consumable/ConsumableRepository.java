package br.senac.requestfood.repository.consumable;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.senac.requestfood.model.consumable.Consumable;
import br.senac.requestfood.projection.consumable.ConsumableProjection;
import br.senac.requestfood.projection.dish.DishProjection;

public interface ConsumableRepository extends JpaRepository<Consumable, Long>{
	
    Optional<ConsumableProjection> findConsumableById(Long id);

    Optional<ConsumableProjection> findByNameContainingIgnoreCase(String name);
    
    Optional<ConsumableProjection> findCById(Long id);
    
    @Query(value = "SELECT c.id AS id, c.name AS name, c.establishment AS establishment, c.price AS price, c.description AS description, c.image AS image FROM Consumable c")
    List<DishProjection> findConsumable();
}

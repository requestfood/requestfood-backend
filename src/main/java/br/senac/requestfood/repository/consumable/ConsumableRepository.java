package br.senac.requestfood.repository.consumable;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.senac.requestfood.dto.consumable.ConsumableCardDTO;
import br.senac.requestfood.model.consumable.Consumable;
import br.senac.requestfood.projection.consumable.ConsumableProjection;

@Repository
public interface ConsumableRepository extends JpaRepository<Consumable, Long>{
	
    Optional<ConsumableProjection> findConsumableById(Long id);

    Page<ConsumableCardDTO> findByNameContainingIgnoreCase(String name, Pageable pageable);
        
    @Query(value = "SELECT c.id AS id, c.name AS name, c.price AS price, c.description AS description, c.image AS image FROM Consumable c")
    Page<ConsumableCardDTO> findConsumables(Pageable page);
    
    @Query(value = "SELECT c.id AS id, c.name AS name, c.price AS price, c.description AS description, c.image AS image FROM Consumable c")
    List<ConsumableProjection> findConsumables();
    
}

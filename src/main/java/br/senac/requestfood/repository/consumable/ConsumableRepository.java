package br.senac.requestfood.repository.consumable;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.senac.requestfood.model.consumable.Consumable;
import br.senac.requestfood.projection.consumable.ConsumableProjection;

@Repository
public interface ConsumableRepository extends JpaRepository<Consumable, Long>{
	
    Optional<ConsumableProjection> findConsumableById(Long id);

    Page<ConsumableProjection> findByNameContainingIgnoreCase(String name, Pageable pageable);
    
}

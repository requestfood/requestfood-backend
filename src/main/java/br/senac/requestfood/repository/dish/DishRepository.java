package br.senac.requestfood.repository.dish;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.senac.requestfood.enumeration.dish.CategoryDish;
import br.senac.requestfood.model.consumable.dish.Dish;
import br.senac.requestfood.projection.consumable.ConsumableCardProjection;
import br.senac.requestfood.projection.dish.DishProjection;

@Repository
public interface DishRepository extends JpaRepository<Dish, Long> {

    Optional<DishProjection> findDishById(Long id);
    
    Page<ConsumableCardProjection> findByNameContainingIgnoreCaseAndEstablishmentId(String name, Long id, Pageable pageable); 
    
    Page<ConsumableCardProjection> findDishByTypeDishAndEstablishmentId(CategoryDish typeDish, Long id, Pageable pageable);
    
    Page<ConsumableCardProjection> findDishesByEstablishmentId(Long id, Pageable pageable);
}
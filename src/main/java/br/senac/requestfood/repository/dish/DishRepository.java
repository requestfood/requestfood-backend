package br.senac.requestfood.repository.dish;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.senac.requestfood.enumeration.dish.CategoryDish;
import br.senac.requestfood.model.consumable.dish.Dish;
import br.senac.requestfood.projection.consumable.ConsumableCardProjection;
import br.senac.requestfood.projection.dish.DishProjection;

@Repository
public interface DishRepository extends JpaRepository<Dish, Long> {

	boolean existsByName (String name);

    Optional<DishProjection> findDishById(Long id);
    
    Page<ConsumableCardProjection> findByNameContainingIgnoreCase(String name, Pageable pageable); 
    
    Page<ConsumableCardProjection> findDishByTypeDish(CategoryDish typeDish, Pageable pageable);
    
    @Query(value = "SELECT c.id AS id, c.name AS name, c.price AS price, c.description AS description, c.establishment AS establishment, c.image AS image, d.typeDish AS typeDish FROM Consumable c JOIN Dish d ON c.id = d.id")
    Page<ConsumableCardProjection> findDishes(Pageable pageable);
}
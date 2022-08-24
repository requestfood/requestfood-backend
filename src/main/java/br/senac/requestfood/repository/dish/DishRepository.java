package br.senac.requestfood.repository.dish;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.senac.requestfood.model.consumable.dish.Dish;
import br.senac.requestfood.projection.dish.DishProjection;

@Repository
public interface DishRepository extends JpaRepository<Dish, Long> {

	boolean existsByName (String name);

    Optional<DishProjection> findDishById(Long id);

    @Query(value = "SELECT d.id AS id, d.name AS name, d.establishment AS establishment, d.price AS price, d.description AS description, d.image AS image, d.typeDish AS typeDish FROM Dish d")
    List<DishProjection> findDishes();
}
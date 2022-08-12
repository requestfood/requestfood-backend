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

    @Query(value = "SELECT d.id_consumable AS id, d.name_consumable AS Name, d.id_user AS Establishment, d.value_consumable AS Value, d.description_consumable AS Description, d.image_consumable AS Image, d.type_dish FROM dish d")
    List<DishProjection> findDishes();
    
}

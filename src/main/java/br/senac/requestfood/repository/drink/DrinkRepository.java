package br.senac.requestfood.repository.drink;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.senac.requestfood.model.consumable.drink.Drink;
import br.senac.requestfood.projection.drink.DrinkProjection;

@Repository
public interface DrinkRepository extends JpaRepository<Drink, Long> {

    boolean existsByName (String name);

    Optional<DrinkProjection> findDrinkById(Long id);

    @Query(value = "SELECT c.id AS id, c.name AS name, c.price AS price, c.establishment AS establishment, c.description AS description, c.image AS image, d.categoryDrink AS categoryDrink, d.alcoholic AS alcoholic FROM Consumable c JOIN Drink d ON c.id = d.id")
    List<DrinkProjection> findDrinks();
}

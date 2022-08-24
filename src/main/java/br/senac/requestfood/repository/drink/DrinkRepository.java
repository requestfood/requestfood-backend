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

    @Query(value = "SELECT d.id AS id, d.name AS name, d.establishment AS establishment, d.price AS price, d.description AS description, d.image AS image, d.typeDrink AS typeDrink, d.alcoholic AS alcoholic FROM Drink d")
    List<DrinkProjection> findDrinks();
}

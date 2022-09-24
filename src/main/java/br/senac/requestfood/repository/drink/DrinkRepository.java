package br.senac.requestfood.repository.drink;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.senac.requestfood.enumeration.drink.CategoryDrink;
import br.senac.requestfood.model.consumable.drink.Drink;
import br.senac.requestfood.projection.consumable.ConsumableCardProjection;
import br.senac.requestfood.projection.drink.DrinkProjection;

@Repository
public interface DrinkRepository extends JpaRepository<Drink, Long> {

    Optional<DrinkProjection> findDrinkById(Long id);
    
    Page<ConsumableCardProjection> findDrinkByAlcoholic(Pageable pageable, Boolean alcoholic);
    
    Page<ConsumableCardProjection> findByNameContainingIgnoreCase(String name, Pageable pageable);
    
    Page<ConsumableCardProjection> findDrinkByCategoryDrink(Pageable pageable, CategoryDrink categoryDrink);

    @Query(value = "SELECT c.id AS id, c.name AS name, c.price AS price, c.description AS description, d.establishment AS establishment, c.image AS image, d.categoryDrink AS categoryDrink, d.alcoholic AS alcoholic FROM Consumable c JOIN Drink d ON c.id = d.id")
    Page<ConsumableCardProjection> findDrinks(Pageable pageable);
    
    @Query(value = "SELECT c.id AS id, c.name AS name, c.price AS price, c.description AS description, d.establishment AS establishment, c.image AS image, d.categoryDrink AS categoryDrink, d.alcoholic AS alcoholic FROM Consumable c JOIN Drink d ON c.id = d.id")
    List<DrinkProjection> findDrinks();
}

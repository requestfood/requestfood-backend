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

    @Query(value = "SELECT d.id_consumable AS id, d.name_consumable AS name, d.id_user AS establishment, d.value_consumable AS value, d.description_consumable AS description, d.image_consumable AS image, d.type_drink AS typeDrink, d.alcoholic_drink AS alcoholic FROM drink d")
    List<DrinkProjection> findDrinks();
}

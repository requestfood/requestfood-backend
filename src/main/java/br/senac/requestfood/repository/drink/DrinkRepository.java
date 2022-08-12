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

    @Query(value = "SELECT d.id_consumable AS id, d.name_consumable AS Name, d.id_user AS Establishment, d.value_consumable AS Value, d.description_consumable AS Description, d.image_consumable AS Image, d.type_drink FROM drink d")
    List<DrinkProjection> findDrinks();
}

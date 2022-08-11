package br.senac.requestfood.repository.bebida;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.senac.requestfood.model.consumivel.bebida.Bebida;
import br.senac.requestfood.projection.bebida.BebidaProjection;

@Repository
public interface BebidaRepository extends JpaRepository<Bebida, Long> {

    boolean existsByName (String name);

    Optional<BebidaProjection> findDrinkById(Long id);

    @Query(value = "SELECT d.name_consumable AS Name, d.value_consumable AS Value, d.description_consumable AS Description, d.image_consumable AS Image FROM drink d")
    List<BebidaProjection> findDrinks();
}

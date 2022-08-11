package br.senac.requestfood.repository.prato;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.senac.requestfood.model.consumivel.prato.Prato;
import br.senac.requestfood.projection.prato.PratoProjection;

@Repository
public interface PratoRepository extends JpaRepository<Prato, Long> {

	boolean existsByName (String name);

    Optional<PratoProjection> findDishById(Long id);

    @Query(value = "SELECT d.id_consumable AS id, d.name_consumable AS Name, d.id_user AS Establishment, d.value_consumable AS Value, d.description_consumable AS Description, d.image_consumable AS Image, d.type_dish AS TipoLouça FROM dish d")
    List<PratoProjection> findDishes();
    
}

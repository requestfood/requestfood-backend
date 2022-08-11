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

    @Query(value = "SELECT d.id_consumivel AS id, d.name_consumable AS name, d.id_user AS establishment, d.value_consumable AS value, d.description_consumable AS description, d.image_consumable AS image, d.type_dish FROM dish d")
    List<PratoProjection> findDishs();
    
}

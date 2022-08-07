package br.senac.requestfood.repository.consumivel;

import br.senac.requestfood.model.consumivel.Consumivel;
import br.senac.requestfood.model.usuario.estabelecimento.Estabelecimento;
import br.senac.requestfood.projection.consumable.ConsumableProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ConsumivelRepository extends JpaRepository<Consumivel, Long> {


    Optional<ConsumableProjection> findConsumivelRepositoryById(Long id);
    boolean existsEstabelecimento (Estabelecimento estabelecimento);
    boolean existsId (Long id);
    boolean existsName (String name);

    boolean existsValue (Float value);

    boolean existsDescription (String Description);

    @Query(value = "SELECT u.id AS id, u.name AS name FROM Estabelecimento u")
    List<ConsumableProjection> findConsumable();


}

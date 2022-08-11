package br.senac.requestfood.repository.mesa;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.senac.requestfood.model.mesa.Mesa;
import br.senac.requestfood.projection.mesa.TableProjection;
import br.senac.requestfood.projection.mesa.TableWithCommandProjection;

@Repository
public interface MesaRepository extends JpaRepository<Mesa, Long> {

	boolean TableLimitUserNumber(Integer limitUserNumber);

    Optional<TableProjection> findTableById(Long id);

    Optional<TableWithCommandProjection> findTableWithCommandById(Long id);

    @Query(value = "SELECT t.id_table AS id, t.id_user AS Establishment, t.password_table AS Password, t.limitusernumber_table AS NúmeroLimite FROM table t")
    List<TableProjection> findTables();
}


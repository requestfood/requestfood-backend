package br.senac.requestfood.repository.desk;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.senac.requestfood.model.table.Desk;
import br.senac.requestfood.projection.desk.DeskProjection;
import br.senac.requestfood.projection.desk.DeskWithCommandProjection;

@Repository
public interface DeskRepository extends JpaRepository<Desk, Long> {

	boolean DeskLimitUserNumber(Integer limitUserNumber);

    Optional<DeskProjection> findDeskById(Long id);

    Optional<DeskWithCommandProjection> findDeskWithCommandById(Long id);

    @Query(value = "SELECT t.id_table AS id, t.id_user AS establishment, t.password_table AS password, t.limitusernumber_table FROM Table t")
    List<DeskProjection> findTables();
}


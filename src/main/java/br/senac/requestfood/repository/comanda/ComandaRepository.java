package br.senac.requestfood.repository.comanda;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.senac.requestfood.model.comanda.Comanda;
import br.senac.requestfood.projection.comanda.ComandaProjection;
import br.senac.requestfood.projection.comanda.ComandaWithClosureDateProjection;
import br.senac.requestfood.projection.comanda.ComandaWithItemProjection;

@Repository
public interface ComandaRepository extends JpaRepository<Comanda, Long>{

	Optional<ComandaProjection> findComandaById(Long id);

	Optional<ComandaWithItemProjection> findComandaWithItemById(Long id);

	Optional<ComandaWithClosureDateProjection> findComandaWithClosureDate(Long id);
	
	@Query(value = "SELECT c.id_command AS id, c.id_client AS Client, c.data_hora_emissao_command AS DataEmissao, c.id_mesa AS Mesa, c.id_establishment AS Establishment FROM command c")
	List<ComandaProjection> findCommands();
}

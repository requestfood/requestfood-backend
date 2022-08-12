package br.senac.requestfood.repository.command;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.senac.requestfood.model.command.Command;
import br.senac.requestfood.projection.command.CommandProjection;
import br.senac.requestfood.projection.command.CommandWithClosureDateProjection;
import br.senac.requestfood.projection.command.CommandWithItemProjection;

@Repository
public interface CommandRepository extends JpaRepository<Command, Long>{

	Optional<CommandProjection> findCommandById(Long id);

	Optional<CommandWithItemProjection> findCommandWithItemById(Long id);

	Optional<CommandWithClosureDateProjection> findCommandWithClosureDate(Long id);
	
	@Query(value = "SELECT c.id_command AS id, c.id_client AS Client, c.date_hour_emission_command AS EmissionDate, c.id_establishment AS Establishment FROM command c")
	List<CommandProjection> findCommands();
}

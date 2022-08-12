package br.senac.requestfood.repository.command;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.senac.requestfood.model.order.Command;
import br.senac.requestfood.projection.order.CommandProjection;
import br.senac.requestfood.projection.order.CommandWithClosureDateProjection;
import br.senac.requestfood.projection.order.CommandWithItemProjection;

@Repository
public interface CommandRepository extends JpaRepository<Command, Long>{

	Optional<CommandProjection> findCommandById(Long id);

	Optional<CommandWithItemProjection> findCommandWithItemById(Long id);

	Optional<CommandWithClosureDateProjection> findCommandWithClosureDate(Long id);
	
	@Query(value = "SELECT c.id AS id, c.client AS client, c.IssueDate AS issueDate, c.closingDate AS closingDate FROM Command c")
	List<CommandProjection> findCommands();
}

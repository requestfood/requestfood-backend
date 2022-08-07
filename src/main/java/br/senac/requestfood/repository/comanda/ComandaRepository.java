package br.senac.requestfood.repository.comanda;

import br.senac.requestfood.projection.comanda.ComandaProjection;
import br.senac.requestfood.projection.comanda.ComandaWithItemProjection;
import br.senac.requestfood.projection.item.ItemProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.senac.requestfood.model.comanda.Comanda;
import br.senac.requestfood.model.mesa.Mesa;
import br.senac.requestfood.model.usuario.cliente.Cliente;
import br.senac.requestfood.model.usuario.estabelecimento.Estabelecimento;

import java.util.List;
import java.util.Optional;

@Repository
public interface ComandaRepository extends JpaRepository<Comanda, Long>{

	Optional<ComandaProjection> findComandaById(Long id);

	Optional<ComandaWithItemProjection> findComandaWithItemProjectionById(Long id);

	boolean existsEstabelecimento(Estabelecimento estabelecimento);
	
	boolean existsCliente(Cliente cliente);

	boolean existsMesa(Mesa mesa);

	boolean existsvalorTotal(double valorTotal);

	@Query(value = "SELECT u.name AS name FROM Comanda u")
	List<ItemProjection> findItem();
	


}

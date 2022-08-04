package br.senac.requestfood.repository.comanda;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.senac.requestfood.model.comanda.Comanda;
import br.senac.requestfood.model.item.Item;
import br.senac.requestfood.model.mesa.Mesa;
import br.senac.requestfood.model.usuario.cliente.Cliente;
import br.senac.requestfood.model.usuario.estabelecimento.Estabelecimento;

@Repository
public interface ComandaRepository extends JpaRepository<Comanda, Long>{
	//usem oque o professor mandou de exemplo
	
	boolean existsEstabelecimento(Estabelecimento estabelecimento);
	
	boolean existsCliente(Cliente cliente);
	
	boolean existsItem(Item item);
	
	boolean existsMesa(Mesa mesa);
	
	Optional<ComandaProjection> findComandaById(Long id);
	
	Optional<ComandaMesasProjection> findComandaWithMesaById(Long id);
	
	Optional<ComandaClienteProjection> findComandaWithClienteById(Long id);
	
	Optional<ComandaEstabelecimentoProjection> findComandaWithEstabelecimentoById(Long id);

}

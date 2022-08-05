package br.senac.requestfood.repository.comanda;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.senac.requestfood.model.comanda.Comanda;
import br.senac.requestfood.model.mesa.Mesa;
import br.senac.requestfood.model.usuario.cliente.Cliente;
import br.senac.requestfood.model.usuario.estabelecimento.Estabelecimento;

@Repository
public interface ComandaRepository extends JpaRepository<Comanda, Long>{
	
	boolean existsEstabelecimento(Estabelecimento estabelecimento);
	
	boolean existsCliente(Cliente cliente);

	boolean existsMesa(Mesa mesa);
	


}

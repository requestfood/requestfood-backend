package br.senac.requestfood.projection.comanda;

import java.time.LocalDateTime;

import br.senac.requestfood.model.mesa.Mesa;
import br.senac.requestfood.model.usuario.cliente.Cliente;
import br.senac.requestfood.model.usuario.estabelecimento.Estabelecimento;

public interface ComandaProjection {

	Long getId();
	
	Cliente getCliente();

	LocalDateTime getDataEmissao();
	
	Mesa getMesa();
	
	Estabelecimento getEstabelecimento();
	
}

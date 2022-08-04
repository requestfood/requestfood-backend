package br.senac.requestfood.projection.comanda;

import java.time.LocalDateTime;
import java.util.List;

import br.senac.requestfood.model.item.Item;
import br.senac.requestfood.model.mesa.Mesa;
import br.senac.requestfood.model.usuario.cliente.Cliente;
import br.senac.requestfood.model.usuario.estabelecimento.Estabelecimento;
import br.senac.requestfood.projection.item.ItemProjection;

public interface ComandaProjection {

	Long getId();
	
	Cliente getCliente();
	
	LocalDateTime getDataFechamento();
	
	List<ItemProjection> getItens();
	
	Mesa getMesa();
	
	Double getValorTotal();
	
	Estabelecimento getEstabelecimento();
	
}

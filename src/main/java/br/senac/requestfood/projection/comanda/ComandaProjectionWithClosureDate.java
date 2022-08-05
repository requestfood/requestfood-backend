package br.senac.requestfood.projection.comanda;

import br.senac.requestfood.model.mesa.Mesa;
import br.senac.requestfood.model.usuario.cliente.Cliente;
import br.senac.requestfood.model.usuario.estabelecimento.Estabelecimento;
import br.senac.requestfood.projection.item.ItemProjection;

import java.time.LocalDateTime;
import java.util.List;

public interface ComandaProjectionWithClosureDate {

    Long getId();

    Cliente getCliente();

    LocalDateTime getDataEmissao();

    LocalDateTime getDataFechamento();

    List<ItemProjection> getItens();

    Mesa getMesa();

    Double getValorTotal();

    Estabelecimento getEstabelecimento();
}

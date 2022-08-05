package br.senac.requestfood.projection.mesa;

import br.senac.requestfood.model.usuario.estabelecimento.Estabelecimento;
import br.senac.requestfood.projection.comanda.ComandaProjection;

import java.util.List;

public interface MesaProjectionWithCommand {

    Long getId();

    Estabelecimento getEstablishment();

    String getPassword();

    Integer getLimitUserNumber();

    List<ComandaProjection> getBills();
}

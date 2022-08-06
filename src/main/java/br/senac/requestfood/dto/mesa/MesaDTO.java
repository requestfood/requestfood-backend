package br.senac.requestfood.dto.mesa;

import java.util.List;

import br.senac.requestfood.model.comanda.Comanda;
import br.senac.requestfood.model.usuario.estabelecimento.Estabelecimento;

public record MesaDTO(Long id, Estabelecimento estabelecimento, String password ,Integer limitUserNumber, List<Comanda> comandas) {}

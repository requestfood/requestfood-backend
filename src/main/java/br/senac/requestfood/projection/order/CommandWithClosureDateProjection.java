package br.senac.requestfood.projection.order;

import java.time.LocalDateTime;
import java.util.List;

import br.senac.requestfood.model.user.client.Client;
import br.senac.requestfood.model.user.establishment.Establishment;
import br.senac.requestfood.projection.item.ItemProjection;

public interface CommandWithClosureDateProjection {

    Long getId();

    Client getCliente();

    LocalDateTime getIssueDate();

    LocalDateTime getClosingDate();

    List<ItemProjection> getItens();

    Double getAmount();

    Establishment getEstablishment();
}

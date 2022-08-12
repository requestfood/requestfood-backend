package br.senac.requestfood.projection.command;

import br.senac.requestfood.model.table.Desk;
import br.senac.requestfood.model.user.client.Client;
import br.senac.requestfood.model.user.establishment.Establishment;
import br.senac.requestfood.projection.item.ItemProjection;

import java.time.LocalDateTime;
import java.util.List;

public interface CommandWithItemProjection {

    Long getId();

    Client getClient();

    LocalDateTime getIssueDate();

    List<ItemProjection> getItens();

    Desk getDesk();

    Double getAmount();

    Establishment getEstablishment();
}

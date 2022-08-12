package br.senac.requestfood.projection.desk;

import br.senac.requestfood.model.user.establishment.Establishment;
import br.senac.requestfood.projection.command.CommandProjection;

import java.util.List;

public interface DeskWithCommandProjection {

    Long getId();

    Establishment getEstablishment();

    String getPassword();

    Integer getLimitUserNumber();

    List<CommandProjection> getCommands();
}

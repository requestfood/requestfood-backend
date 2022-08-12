package br.senac.requestfood.model.user.establishment;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.senac.requestfood.model.command.Command;
import br.senac.requestfood.model.consumable.Consumable;
import br.senac.requestfood.model.table.Desk;
import br.senac.requestfood.model.user.User;

@Entity
@Table(name = "establishment")
public class Establishment extends User {

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "establishment", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Consumable> consumable;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "establishment", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Desk> desks;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "establishment", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Command> commands;

    public Establishment() {}
    
	public Establishment(List<Consumable> consumable, List<Desk> desks, List<Command> commands) {
		this.consumable = consumable;
		this.desks = desks;
		this.commands = commands;
	}

	public List<Consumable> getConsumables() {
		return consumable;
	}
	public void setConsumables(List<Consumable> consumable) {
		this.consumable = consumable;
	}
	public List<Desk> getDesks() {
		return desks;
	}
	public void setDesks(List<Desk> desks) {
		this.desks = desks;
	}
	public List<Command> getCommands() {
		return commands;
	}
	public void setCommands(List<Command> commands) {
		this.commands = commands;
	}
}
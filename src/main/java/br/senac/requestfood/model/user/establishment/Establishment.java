package br.senac.requestfood.model.user.establishment;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.senac.requestfood.model.command.Command;
import br.senac.requestfood.model.consumable.Consumable;
import br.senac.requestfood.model.user.User;

@Entity
@Table(name = "establishment")
public class Establishment extends User {

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "establishment", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Consumable> consumables;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "establishment", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Command> commands;
    
    @Lob
	@Column(name = "image_establishment")
	private Byte[] image;

    public Establishment() {}
    
	public Establishment(List<Consumable> consumable, List<Command> commands) {
		this.consumables = consumable;
		this.commands = commands;
	}

	public List<Consumable> getConsumables() {
		return consumables;
	}
	public List<Command> getCommands() {
		return commands;
	}
	public void setCommands(List<Command> commands) {
		this.commands = commands;
	}
	public Byte[] getImage() {
		return image;
	}
	public void setImage(Byte[] image) {
		this.image = image;
	}
	
}
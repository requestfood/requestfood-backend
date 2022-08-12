package br.senac.requestfood.model.user.establishment;

import java.util.ArrayList;
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
import br.senac.requestfood.model.contact.Contact;
import br.senac.requestfood.model.user.User;

@Entity
@Table(name = "establishment")
public class Establishment extends User {

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "establishment", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Consumable> consumables = new ArrayList<>();
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "establishment", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Command> commands = new ArrayList<>() ;
    
    @Lob
	@Column(name = "image_establishment")
	private Byte[] image;
    
    @Column(name = "biography_establishment", length = 200, nullable = false)
    private String biography;

    public Establishment() {}

	public Establishment(Long id, String nome, Contact contact, String password, Byte[] image, String biography) {
		super(id, nome, contact, password);
		this.image = image;
		this.biography = biography;
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
	public String getBiography() {
		return biography;
	}
	public void setBiography(String biography) {
		this.biography = biography;
	}
}
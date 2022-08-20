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

import br.senac.requestfood.model.consumable.Consumable;
import br.senac.requestfood.model.contact.Contact;
import br.senac.requestfood.model.order.Order;
import br.senac.requestfood.model.user.User;

@Entity
@Table(name = "establishment")
public class Establishment extends User {

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "establishment", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Consumable> consumables = new ArrayList<>();
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "establishment", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> orders = new ArrayList<>() ;
    
    @Lob
	@Column(name = "image_establishment")
	private Byte[] image;
    
    @Column(name = "cep_establishment", length = 9, nullable = false)
    private String cep;
    
    @Column(name = "description_establishment", length = 200, nullable = true)
    private String description;

    public Establishment() {}

	public Establishment(Long id, String nome, Contact contact, String password, Byte[] image, String cep, String description) {
		super(id, nome, contact, password);
		this.image = image;
		this.cep = cep;
		this.description = description;
	}

	public List<Consumable> getConsumables() {
		return consumables;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public List<Order> getOrders() {
		return orders;
	}
	public Byte[] getImage() {
		return image;
	}
	public void setImage(Byte[] image) {
		this.image = image;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
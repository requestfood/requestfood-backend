package br.senac.requestfood.model.user.establishment;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.senac.requestfood.model.consumable.Consumable;
import br.senac.requestfood.model.contact.Contact;
import br.senac.requestfood.model.order.Order;
import br.senac.requestfood.model.user.User;

@Entity
@Table(name = "establishment")
public class Establishment extends User {

	@JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "establishment", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<Consumable> consumables = new ArrayList<>();
    
	@JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "establishment", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<Order> orders = new ArrayList<>();
    
    @Column(name = "time_to_open_establishment")
    private LocalTime timeToOpen;
    
    @Column(name = "time_to_close_establishment")
    private LocalTime timeToClose;
    
	@Transient
    private Boolean open;
    
	@Lob
	@Column(name = "image_establishment")
	private Byte[] image;
    
    public Establishment() {}

	public Establishment(Long id, String nome, Contact contact, String password, Byte[] image, LocalTime timeToOpen, LocalTime timeToClose) {
		super(id, nome, contact, password);
		this.image = image;
		this.timeToOpen = timeToOpen;
		this.timeToClose = timeToClose;
	}

	public List<Consumable> getConsumables() {
		return consumables;
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
	
	public Boolean getOpen() {
		return open;
	}
	
	public void setOpen(Boolean open) {
		this.open = open;
	}
	public LocalTime getTimeToOpen() {
		return timeToOpen;
	}
	
	public void setTimeToOpen(LocalTime timeToOpen) {
		this.timeToOpen = timeToOpen;
	}
	
	public LocalTime getTimeToClose() {
		return timeToClose;
	}
	
	public void setTimeToClose(LocalTime timeToClose) {
		this.timeToClose = timeToClose;
	}
}
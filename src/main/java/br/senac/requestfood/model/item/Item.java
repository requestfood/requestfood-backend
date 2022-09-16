package br.senac.requestfood.model.item;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.senac.requestfood.model.consumable.Consumable;
import br.senac.requestfood.model.order.Order;

@Entity
@Table(name = "item")
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_item")
	private Long id;

    @JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_order", nullable = false)
	private Order order;

	@Column(name = "quantity_item", nullable = false)
	private Integer quantity;

	@OneToOne(fetch = FetchType.LAZY)
    @MapsId
	@JoinColumn(name = "id_consumable", nullable = false)
	private Consumable consumable;

	@Column(name = "observation_item", length = 100)
	private String observation;

	public Item() {}

	public Item(Long id, Order order, Integer quantity, Consumable consumable, String observation) {
		this.id = id;
		this.order = order;
		this.quantity = quantity;
		this.consumable = consumable;
		this.observation = observation;
	}

	public boolean equals(Object object) {

		if (this == object)
			return true;

		if (object == null)
			return false;

		if (getClass() != object.getClass())
			return false;

		Item item = ((Item) object);

		return this.getId() == item.getId() && this.getOrder() == item.getOrder()
				&& this.getQuantity() == item.getQuantity() && this.getConsumable() == item.getConsumable()
				&& this.getObservation().equals(getObservation());
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Consumable getConsumable() {
		return consumable;
	}
	public void setConsumable(Consumable consumable) {
		this.consumable = consumable;
	}
	public String getObservation() {
		return observation;
	}
	public void setObservation(String observation) {
		this.observation = observation;
	}
	
	public Double getSubTotal() {
		return quantity * consumable.getPrice();
	}
}
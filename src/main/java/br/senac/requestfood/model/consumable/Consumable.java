package br.senac.requestfood.model.consumable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.senac.requestfood.model.user.establishment.Establishment;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "consumable")
public abstract class Consumable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_consumable")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_user")
	private Establishment establishment;

	@Column(name = "name_consumable", length = 45, nullable = false)
	private String name;

	@Column(name = "price_consumable", nullable = false)
	private Double price;

	@Column(name = "description_consumable", length = 200)
	private String description;

	@Lob
	@Column(name = "image_consumable")
	private Byte[] image;

	protected Consumable() {}

	protected Consumable(Long id, String name, Establishment establishment, Double price, String description,Byte[] image) {
		this.id = id;
		this.establishment = establishment;
		this.name = name;
		this.price = price;
		this.description = description;
		this.image = image;
	}



	public boolean equals(Object object) {
		if (object == null)
			return false;
		if (this == object)
			return true;
		if (this.getClass() != object.getClass())
			return false;
		
		Consumable consumable = ((Consumable) object);
		
		return this.getId() == consumable.getId() && this.getEstablishment().equals(consumable.getEstablishment())
				&& this.getName().equals(consumable.getName()) && this.getPrice() == consumable.getPrice()
				&& this.getDescription().equals(consumable.getDescription())
				&& this.getImage().equals(consumable.getImage());
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Establishment getEstablishment() {
		return establishment;
	}
	public void setEstablishment(Establishment establishment) {
		this.establishment = establishment;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Byte[] getImage() {
		return image;
	}
	public void setImage(Byte[] image) {
		this.image = image;
	}
}
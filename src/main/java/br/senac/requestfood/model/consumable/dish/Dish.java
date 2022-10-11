package br.senac.requestfood.model.consumable.dish;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import br.senac.requestfood.enumeration.dish.CategoryDish;
import br.senac.requestfood.model.consumable.Consumable;
import br.senac.requestfood.model.user.establishment.Establishment;

@Entity
@Table(name="dish")
public class Dish extends Consumable {

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "type_dish", nullable = false)
    private CategoryDish typeDish;

    public Dish() {}

	public Dish(Long id, Establishment establishment, String name, Double price, String description, byte[] image, CategoryDish typeDish) {
		super(id, name, establishment, price, description, image);
		this.typeDish = typeDish;
	}

	public CategoryDish getTypeDish() {
		return typeDish;
	}

	public void setTypeDish(CategoryDish typeDish) {
		this.typeDish = typeDish;
	}

}
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
    private CategoryDish typoDish;

    public Dish() {}

	public Dish(CategoryDish typoDish) {
		this.typoDish = typoDish;
	}

	public CategoryDish getTypoDish() {
		return typoDish;
	}

	public void setTypoDish(CategoryDish typoDish) {
		this.typoDish = typoDish;
	}

}
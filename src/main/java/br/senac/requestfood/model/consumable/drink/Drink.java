package br.senac.requestfood.model.consumable.drink;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import br.senac.requestfood.enumeration.drink.CategoryDrink;
import br.senac.requestfood.model.consumable.Consumable;
import br.senac.requestfood.model.user.establishment.Establishment;

@Entity
@Table(name = "drink")
public class Drink extends Consumable {

	@Column(name = "alcoholic_drink", nullable = false)
    private Boolean alcoholic;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "type_drink", nullable = false)
    private CategoryDrink categoryDrink;

	public Drink() {}
	
	public Drink(Long id, String name, Establishment establishment, Double price, String description, Byte[] image, Boolean alcoholic, CategoryDrink categoryDrink){
		super(id, name, establishment, price, description, image);
		this.alcoholic = alcoholic;
		this.categoryDrink = categoryDrink;
	}

	public Boolean getAlcoholic() {
		return alcoholic;
	}
	public void setAlcoholic(Boolean alcoholic) {
		this.alcoholic = alcoholic;
	}
	public CategoryDrink getCategoryDrink() {
		return categoryDrink;
	}
	public void setCategoryDrink(CategoryDrink categoryDrink) {
		this.categoryDrink = categoryDrink;
	}
}
package br.senac.requestfood.model.addicionalItem;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.senac.requestfood.model.item.Item;

@Entity
@Table(name = "item_adicional")
public class AdditionalItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_additional")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_item", nullable = false)
    private Item item;

    @Column(name = "name_additional", nullable = false)
    private String name;

    @Column(name = "quantity_additional", nullable = false)
    private Integer quantity;

    public AdditionalItem() {}

    public AdditionalItem(Long id, Item item, String name, Integer quantity) {
        setId(id);
        setItem(item);
        setName(name);
        setQuantity(quantity);
    }

    public boolean equals(Object objeto) {
    	
    	if(objeto == null)
    		return false;
    	
    	if(objeto == this)
    		return true;

    	if(objeto.getClass() != this.getClass())
    		return false;
    				
    	AdditionalItem itemAdicional = ((AdditionalItem) objeto);
    	
    	return this.getId() == itemAdicional.getId() && this.getItem().equals(itemAdicional.getItem()) && this.getName().equals(itemAdicional.getName()) && this.getQuantity() == itemAdicional.getQuantity();
    }
    
    public long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Item getItem() {
        return item;
    }
    public void setItem(Item item) {
        this.item = item;
    }
    public String getName() {
        return name;
    }
    public void setName(String nomeAdicional) {
        this.name= nomeAdicional;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantidade) {
        this.quantity = quantidade;
    }
}
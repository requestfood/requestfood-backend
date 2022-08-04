package br.senac.requestfood.model.itemadicional;

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
public class ItemAdicional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_item_adicional")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_item", nullable = false)
    private Item item;

    @Column(name = "nome_adicional", nullable = false)
    private String nomeAdicional;

    @Column(name = "quantidade_adicional", nullable = false)
    private Integer quantidade;

    public ItemAdicional() {}

    public ItemAdicional(Long id, Item item, String nomeAdicional, Integer quantidade) {
        setId(id);
        setItem(item);
        setNomeAdicional(nomeAdicional);
        setQuantidade(quantidade);
    }

    public boolean equals(Object objeto) {
    	
    	if(objeto == null)
    		return false;
    	
    	if(objeto == this)
    		return true;

    	if(objeto.getClass() != this.getClass())
    		return false;
    				
    	ItemAdicional itemAdicional = ((ItemAdicional) objeto);
    	
    	return this.getId() == itemAdicional.getId() && this.getItem().equals(itemAdicional.getItem()) && this.getNomeAdicional().equals(itemAdicional.getNomeAdicional()) && this.getQuantidade() == itemAdicional.getQuantidade();
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
    public String getNomeAdicional() {
        return nomeAdicional;
    }
    public void setNomeAdicional(String nomeAdicional) {
        this.nomeAdicional = nomeAdicional;
    }
    public Integer getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
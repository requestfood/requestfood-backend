package br.senac.requestfood.projection.consumable;

public interface ConsumableCardProjection {

	Long getId();
	
	Byte[] getImage();
	
	String getName();
	
	Double getPrice();
	
	String getDescription();
	
}

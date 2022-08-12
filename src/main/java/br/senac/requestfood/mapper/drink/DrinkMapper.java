package br.senac.requestfood.mapper.drink;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.senac.requestfood.dto.drink.DrinkDTO;
import br.senac.requestfood.model.consumable.drink.Drink;

@Service
public class DrinkMapper {

	public DrinkDTO toDTO(Drink drink) {
		return new DrinkDTO(drink.getId(), drink.getName(), drink.getEstablishment(),drink.getValue());
	}
	
	public Drink toEntity(DrinkDTO drinkDTO) {
		// Not completed, waiting response for Front-End
		return null;
	}
	
	public List<DrinkDTO> toDTO(List<Drink> drinks){
		
		final List<DrinkDTO> drinkDTOs = new ArrayList<>();
		
		for (Drink drink : drinks) {
			drinkDTOs.add(toDTO(drink));
		}
		
		return drinkDTOs;
	}
	
	public List<Drink> toEntity(List<DrinkDTO> drinkDTOs) {
		
		final List<Drink> drinks = new ArrayList<>();
		
		for (DrinkDTO drinkDTO : drinkDTOs) {
			drinks.add(toEntity(drinkDTO));
		}
		
		return drinks;
	}
}
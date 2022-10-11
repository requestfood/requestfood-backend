package br.senac.requestfood.mapper.drink;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.senac.requestfood.dto.drink.DrinkDTO;
import br.senac.requestfood.exception.establishment.EstablishmentNotFoundException;
import br.senac.requestfood.model.consumable.drink.Drink;
import br.senac.requestfood.model.user.establishment.Establishment;
import br.senac.requestfood.repository.establisment.EstablishmentRepository;

@Service
public class DrinkMapper {
	
	private EstablishmentRepository establishmentRepository;

	public DrinkMapper(EstablishmentRepository establishmentRepository) {
		this.establishmentRepository = establishmentRepository;
	}

	public DrinkDTO toDTO(Drink drink) {
		return new DrinkDTO(drink.getId(), drink.getName(), drink.getEstablishment().getId(),drink.getPrice(), drink.getDescription(), drink.getAlcoholic(), drink.getCategoryDrink());
	}
	
	public Drink toEntity(DrinkDTO drinkDTO) {
		Establishment establishment = establishmentRepository.findById(drinkDTO.idEstablishment())
				.orElseThrow(() -> new EstablishmentNotFoundException(null));
		
		return new Drink(drinkDTO.id(), drinkDTO.name(), establishment, drinkDTO.price(), drinkDTO.description(), null, drinkDTO.alcoholic(), drinkDTO.categoryDrink());
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

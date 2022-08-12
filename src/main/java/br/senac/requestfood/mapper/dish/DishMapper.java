package br.senac.requestfood.mapper.dish;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.senac.requestfood.dto.dish.DishDTO;
import br.senac.requestfood.model.consumable.dish.Dish;

@Service
public class DishMapper {

	public DishDTO toDTO(Dish dish) {
		return new DishDTO(dish.getId(), dish.getName(), dish.getEstablishment(),dish.getValue());
	}
	
	public Dish toEntity(DishDTO dishDTO) {
	//Not Completed, waiting response for Front-End
		return null;
	}

	public List<DishDTO> toDTO(List<Dish> dishs){
		
		final List<DishDTO> dishDTOs = new ArrayList<>();
		
		for (Dish dish : dishs) {
			dishDTOs.add(toDTO(dish));
		}
		
		return dishDTOs;
	}
	
	public List<Dish> toEntity(List<DishDTO> dishDTOs) {
		
		final List<Dish> pratos= new ArrayList<>();
		
		for (DishDTO dishDTO : dishDTOs) {
			pratos.add(toEntity(dishDTO));
		}
		
		return pratos;
	}
}

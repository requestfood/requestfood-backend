package br.senac.requestfood.mapper.dish;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.senac.requestfood.dto.dish.DishDTO;
import br.senac.requestfood.model.consumable.dish.Dish;

@Service
public class DishMapper {

	public DishDTO toDTO(Dish dish) {
		return new DishDTO(dish.getId(), dish.getEstablishment(), dish.getName(), dish.getDescription(), dish.getImage(), dish.getValue(), dish.getTypeDish());
	}
	
	public Dish toEntity(DishDTO dishDTO) {
		return new Dish(dishDTO.id(), dishDTO.establishment(), dishDTO.name(), dishDTO.value(), dishDTO.description(), dishDTO.image(),  dishDTO.typeDish());
	}

	public List<DishDTO> toDTO(List<Dish> dishes){
		
		final List<DishDTO> dishDTOs = new ArrayList<>();
		
		for (Dish dish : dishes) {
			dishDTOs.add(toDTO(dish));
		}
		
		return dishDTOs;
	}
	
	public List<Dish> toEntity(List<DishDTO> dishDTOs) {
		
		final List<Dish> dishes= new ArrayList<>();
		
		for (DishDTO dishDTO : dishDTOs) {
			dishes.add(toEntity(dishDTO));
		}
		
		return dishes;
	}
}

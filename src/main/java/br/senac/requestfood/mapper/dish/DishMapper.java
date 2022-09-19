package br.senac.requestfood.mapper.dish;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.senac.requestfood.dto.dish.DishDTO;
import br.senac.requestfood.exception.establishment.EstablishmentNotFoundException;
import br.senac.requestfood.model.consumable.dish.Dish;
import br.senac.requestfood.model.user.establishment.Establishment;
import br.senac.requestfood.repository.establisment.EstablishmentRepository;

@Service
public class DishMapper {
	
	private EstablishmentRepository establishmentRepository;

	public DishMapper(EstablishmentRepository establishmentRepository) {
		this.establishmentRepository = establishmentRepository;
	}

	public DishDTO toDTO(Dish dish) {
		return new DishDTO(dish.getId(), dish.getEstablishment().getId(), dish.getName(), dish.getDescription(), dish.getImage(), dish.getPrice(), dish.getTypeDish());
	}
	
	public Dish toEntity(DishDTO dishDTO) {
		Establishment establishment = establishmentRepository.findById(dishDTO.idEstablishment())
				.orElseThrow(() -> new EstablishmentNotFoundException("Establishment "+ dishDTO.idEstablishment() +" was not found."));
		
		return new Dish(dishDTO.id(), establishment, dishDTO.name(), dishDTO.price(), dishDTO.description(), dishDTO.image(),  dishDTO.typeDish());
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

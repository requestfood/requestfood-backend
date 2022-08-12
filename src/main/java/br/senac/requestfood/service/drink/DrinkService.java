package br.senac.requestfood.service.drink;

import java.util.List;

import br.senac.requestfood.dto.drink.DrinkDTO;
import br.senac.requestfood.projection.drink.DrinkProjection;

public interface DrinkService {

	DrinkDTO save(DrinkDTO drinkDTO);

	void update(DrinkDTO drinkDTO, Long id);

	void delete(Long id);
	
	DrinkProjection findById(Long id);
	
	List<DrinkProjection> findAll();
}

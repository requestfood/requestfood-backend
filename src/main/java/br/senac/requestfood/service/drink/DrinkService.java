package br.senac.requestfood.service.drink;

import java.util.List;

import br.senac.requestfood.dto.drink.DrinkDTO;
import br.senac.requestfood.dto.establishment.EstablishmentWithConsumablesDTO;
import br.senac.requestfood.enumeration.drink.CategoryDrink;
import br.senac.requestfood.projection.drink.DrinkProjection;

public interface DrinkService {

	DrinkDTO save(DrinkDTO drinkDTO);

	void update(DrinkDTO drinkDTO, Long id);

	void delete(Long id);
	
	DrinkProjection findById(Long id);
	
	EstablishmentWithConsumablesDTO findByName(String name, Long id);
	
	EstablishmentWithConsumablesDTO findByPriceByOrdemByAsc(Long id);
	
	EstablishmentWithConsumablesDTO findByPriceByOrdemByDesc(Long id);
	
	EstablishmentWithConsumablesDTO findByAlcoholic(Boolean alcoholic, Long id);
	
	EstablishmentWithConsumablesDTO findByCategoryDrink(CategoryDrink categoryDrink, Long id);
	
	EstablishmentWithConsumablesDTO findAll(Long id);
	
	List<DrinkProjection> findAll();
}

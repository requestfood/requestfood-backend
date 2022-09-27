package br.senac.requestfood.service.drink;

import java.util.List;

import org.springframework.data.domain.Pageable;

import br.senac.requestfood.dto.drink.DrinkDTO;
import br.senac.requestfood.dto.establishment.EstablishmentWithConsumablesDTO;
import br.senac.requestfood.enumeration.drink.CategoryDrink;
import br.senac.requestfood.projection.drink.DrinkProjection;

public interface DrinkService {

	DrinkDTO save(DrinkDTO drinkDTO);

	void update(DrinkDTO drinkDTO, Long id);

	void delete(Long id);
	
	DrinkProjection findById(Long id);
	
	EstablishmentWithConsumablesDTO findByName(Long id, String name, Integer page, Pageable pageable);
	
	EstablishmentWithConsumablesDTO findByPriceByOrdemByAsc(Long id, Integer page, Pageable pageable);
	
	EstablishmentWithConsumablesDTO findByPriceByOrdemByDesc(Long id, Integer page, Pageable pageable);
	
	EstablishmentWithConsumablesDTO findByAlcoholic(Long id, Boolean alcoholic, Integer page, Pageable pageable);
	
	EstablishmentWithConsumablesDTO findByCategoryDrink(Long id, CategoryDrink categoryDrink, Integer page, Pageable pageable);
	
	EstablishmentWithConsumablesDTO findAll(Long id, Integer page, Pageable pageable);
	
	List<DrinkProjection> findAll();
}

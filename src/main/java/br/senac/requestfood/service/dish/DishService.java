package br.senac.requestfood.service.dish;

import org.springframework.stereotype.Service;

import br.senac.requestfood.dto.dish.DishDTO;
import br.senac.requestfood.dto.establishment.EstablishmentWithConsumablesDTO;
import br.senac.requestfood.enumeration.dish.CategoryDish;
import br.senac.requestfood.projection.dish.DishProjection;

@Service
public interface DishService {

	DishDTO save(DishDTO dishDTO);
	
	void update(DishDTO dishDTO, Long id);
	
	void delete(Long id);
	
	DishProjection findById(Long id);
	
	EstablishmentWithConsumablesDTO findByName(String name, Long id);
	
	EstablishmentWithConsumablesDTO findByPriceByOrdemByAsc(Long id);
	
	EstablishmentWithConsumablesDTO findByPriceByOrdemByDesc(Long id);
	
	EstablishmentWithConsumablesDTO findByTypeDish(CategoryDish typeDish, Long id);
	
	EstablishmentWithConsumablesDTO findAll(Long id);
	
}

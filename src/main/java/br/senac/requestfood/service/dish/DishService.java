package br.senac.requestfood.service.dish;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.senac.requestfood.dto.dish.DishDTO;
import br.senac.requestfood.dto.dish.DishImageDTO;
import br.senac.requestfood.dto.establishment.EstablishmentWithConsumablesDTO;
import br.senac.requestfood.enumeration.dish.CategoryDish;
import br.senac.requestfood.projection.dish.DishProjection;

@Service
public interface DishService {

	DishDTO save(DishDTO dishDTO);
	
	void update(DishDTO dishDTO, Long id);
	
	void delete(Long id);
	
	void saveImage(byte[] image, Long id);

	DishImageDTO findByIdImage(Long id);
	
	DishProjection findById(Long id);
	
	EstablishmentWithConsumablesDTO findByName(Long id, String name, Integer page, Pageable pageable);
	
	EstablishmentWithConsumablesDTO findByPriceByOrdemByAsc(Long id, Integer page, Pageable pageable);
	
	EstablishmentWithConsumablesDTO findByPriceByOrdemByDesc(Long id, Integer page, Pageable pageable);
	
	EstablishmentWithConsumablesDTO findByTypeDish(Long id, CategoryDish typeDish, Integer page, Pageable pageable);
	
	EstablishmentWithConsumablesDTO findAll(Long id, Integer page, Pageable pageable);
	
}

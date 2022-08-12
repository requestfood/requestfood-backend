package br.senac.requestfood.service.dish;

import java.util.List;

import org.springframework.stereotype.Service;

import br.senac.requestfood.dto.dish.DishDTO;
import br.senac.requestfood.projection.dish.DishProjection;

@Service
public interface DishService {

	DishDTO save(DishDTO dishDTO);
	
	void update(DishDTO dishDTO, Long id);
	
	void delete(Long id);
	
	DishProjection findById(Long id);
	
	List<DishProjection> findAll();
}

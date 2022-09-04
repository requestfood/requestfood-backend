package br.senac.requestfood.service.dish;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.senac.requestfood.dto.dish.DishDTO;
import br.senac.requestfood.projection.dish.DishProjection;

@Service
public interface DishService {

	DishDTO save(DishDTO dishDTO);
	
	void update(DishDTO dishDTO, Long id);
	
	void delete(Long id);
	
	DishProjection findById(Long id);
	
	Page<DishProjection> findByName(String name, Pageable pageable);
	
	Page<DishProjection> findByPriceByOrdemByAsc(Pageable pageable, Integer page);
	
	Page<DishProjection> findByPriceByOrdemByDesc(Pageable pageable, Integer page);
	
	Page<DishProjection> findAll(Pageable pageable, Integer page);
	
	List<DishProjection> findAll();
}

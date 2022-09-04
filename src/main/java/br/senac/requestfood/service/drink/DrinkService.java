package br.senac.requestfood.service.drink;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.senac.requestfood.dto.drink.DrinkDTO;
import br.senac.requestfood.projection.drink.DrinkProjection;

public interface DrinkService {

	DrinkDTO save(DrinkDTO drinkDTO);

	void update(DrinkDTO drinkDTO, Long id);

	void delete(Long id);
	
	DrinkProjection findById(Long id);
	
	Page<DrinkProjection> findByName(String name, Pageable pageable);
	
	Page<DrinkProjection> findByPriceByOrdemByAsc(Pageable pageable, Integer page);
	
	Page<DrinkProjection> findByPriceByOrdemByDesc(Pageable pageable, Integer page);
	
	Page<DrinkProjection> findAll(Pageable pageable, Integer page);
	
	List<DrinkProjection> findAll();
}

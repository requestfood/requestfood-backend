package br.senac.requestfood.service.drink;

import java.util.List;

import br.senac.requestfood.dto.bebida.BebidaDTO;
import br.senac.requestfood.projection.bebida.BebidaProjection;

public interface DrinkService {

	BebidaDTO save(BebidaDTO bebidaDTO);

	void update(BebidaDTO bebidaDTO, Long id);

	void delete(Long id);
	
	BebidaProjection findById(Long id);
	
	List<BebidaProjection> findAll();
}

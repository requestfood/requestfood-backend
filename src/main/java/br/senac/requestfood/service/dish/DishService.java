package br.senac.requestfood.service.dish;

import java.util.List;

import org.springframework.stereotype.Service;

import br.senac.requestfood.dto.prato.PratoDTO;
import br.senac.requestfood.projection.prato.PratoProjection;

@Service
public interface DishService {

	PratoDTO save(PratoDTO pratoDTO);
	
	void update(PratoDTO pratoDTO, Long id);
	
	void delete(Long id);
	
	PratoProjection findById(Long id);
	
	List<PratoProjection> findAll();
}

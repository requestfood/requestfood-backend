package br.senac.requestfood.service.comanda;

import java.util.List;

import br.senac.requestfood.dto.bebida.BebidaDTO;
import br.senac.requestfood.dto.comanda.ComandaDTO;
import br.senac.requestfood.dto.item.ItemDTO;
import br.senac.requestfood.model.consumivel.Consumivel;
import br.senac.requestfood.projection.comanda.ComandaProjection;
import br.senac.requestfood.projection.comanda.ComandaWithClosureDateProjection;
import br.senac.requestfood.projection.comanda.ComandaWithItemProjection;

public interface ComandaService {
	
	ComandaDTO save(ComandaDTO comandaDTO);
	
	void update(ComandaDTO comandaDTO, Long id);
	
	void delete(Long id);
	
	//Double valorTotal(Double valor); falar com o professor
	
	ComandaProjection findById(Long id);
	
	ComandaWithItemProjection findByIdWithItem(Long id);
	
	ComandaWithClosureDateProjection findByIdWithClosureDate(Long id);
	
	List<ComandaProjection> findAll();

}

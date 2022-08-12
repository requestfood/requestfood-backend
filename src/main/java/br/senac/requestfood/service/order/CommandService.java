package br.senac.requestfood.service.order;

import java.util.List;

import br.senac.requestfood.dto.order.CommandDTO;
import br.senac.requestfood.projection.order.CommandProjection;
import br.senac.requestfood.projection.order.CommandWithClosureDateProjection;
import br.senac.requestfood.projection.order.CommandWithItemProjection;

public interface CommandService {
	
	CommandDTO save(CommandDTO comandaDTO);
	
	void update(CommandDTO comandaDTO, Long id);
	
	void delete(Long id);
	
	//Double valorTotal(Double valor); falar com o professor
	
	CommandProjection findById(Long id);
	
	CommandWithItemProjection findByIdWithItem(Long id);
	
	CommandWithClosureDateProjection findByIdWithClosureDate(Long id);
	
	List<CommandProjection> findAll();

}

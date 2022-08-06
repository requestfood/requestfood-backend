package br.senac.requestfood.service.table;

import java.util.List;

import br.senac.requestfood.dto.mesa.MesaDTO;
import br.senac.requestfood.projection.mesa.TableProjection;
import br.senac.requestfood.projection.mesa.TableWithCommandProjection;

public interface TableService {

	MesaDTO save(MesaDTO mesaDTO);

	void update(MesaDTO mesaDTO, Long id);

	void delete(Long id);
	
	boolean TableLimitUserNumber(Long id);

	TableProjection findById(Long id);

	TableWithCommandProjection findCommandById(Long id);
	
	List<TableProjection> findAll();
}

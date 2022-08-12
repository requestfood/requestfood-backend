package br.senac.requestfood.service.desk;

import java.util.List;

import br.senac.requestfood.dto.table.DeskDTO;
import br.senac.requestfood.projection.desk.DeskProjection;
import br.senac.requestfood.projection.desk.DeskWithCommandProjection;

public interface DeskService {

	DeskDTO save(DeskDTO deskDTO);

	void update(DeskDTO deskDTO, Long id);

	void delete(Long id);
	
	boolean TableLimitUserNumber(Long id);

	DeskProjection findById(Long id);

	DeskWithCommandProjection findCommandById(Long id);
	
	List<DeskProjection> findAll();
}

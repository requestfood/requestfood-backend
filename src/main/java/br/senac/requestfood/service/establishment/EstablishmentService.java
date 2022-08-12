package br.senac.requestfood.service.establishment;

import java.util.List;

import br.senac.requestfood.dto.establishment.EstablishmentDTO;
import br.senac.requestfood.projection.establishment.EstablishmentProjection;
import br.senac.requestfood.projection.establishment.EstablishmentWithAllProjection;
import br.senac.requestfood.projection.establishment.EstablishmentWithCommandProjection;
import br.senac.requestfood.projection.establishment.EstablishmentWithConsumableProjection;

public interface EstablishmentService {

	EstablishmentDTO save(EstablishmentDTO establishmentDTO);
	
	void update(EstablishmentDTO establishmentDTO, Long id);
	
	void delete(Long id);
	
	EstablishmentProjection findById(Long id);
	
	EstablishmentWithAllProjection findByIdWithAll(Long id);
	
	EstablishmentWithCommandProjection findByIdWithCommand(Long id);
	
	EstablishmentWithConsumableProjection findByIdWithComsumable(Long id);
	
	List<EstablishmentProjection> findAll();
}

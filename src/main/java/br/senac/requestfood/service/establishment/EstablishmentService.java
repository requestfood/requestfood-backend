package br.senac.requestfood.service.establishment;

import java.util.List;

import br.senac.requestfood.dto.establishment.EstablishmentDTO;
import br.senac.requestfood.projection.establishment.EstablishmentProjection;
import br.senac.requestfood.projection.establishment.EstablishmentWithAllProjection;
import br.senac.requestfood.projection.establishment.EstablishmentWithConsumableProjection;
import br.senac.requestfood.projection.establishment.EstablishmentWithOrderProjection;

public interface EstablishmentService {

	EstablishmentDTO save(EstablishmentDTO establishmentDTO);
	
	void update(EstablishmentDTO establishmentDTO, Long id);
	
	void delete(Long id);
	
	EstablishmentProjection findById(Long id);
	
	EstablishmentWithAllProjection findByIdWithAll(Long id);
	
	EstablishmentWithOrderProjection findByIdWithOrder(Long id);
	
	EstablishmentWithConsumableProjection findByIdWithConsumable(Long id);
	
	List<EstablishmentProjection> findAll();
}

package br.senac.requestfood.service.establishment;

import java.util.List;

import br.senac.requestfood.dto.establishment.AllEstablishmentDTO;
import br.senac.requestfood.dto.establishment.EstablishmentPasswordDTO;
import br.senac.requestfood.projection.establishment.EstablishmentProjection;
import br.senac.requestfood.projection.establishment.EstablishmentWithAllProjection;
import br.senac.requestfood.projection.establishment.EstablishmentWithConsumableProjection;
import br.senac.requestfood.projection.establishment.EstablishmentWithOrderProjection;

public interface EstablishmentService {

	AllEstablishmentDTO save(AllEstablishmentDTO establishmentDTO);
	
	void update(AllEstablishmentDTO establishmentDTO, Long id);
	
	void updatePassword(EstablishmentPasswordDTO establishmentDTO, Long id);
	
	void delete(Long id);
	
	EstablishmentProjection findById(Long id);
	
	EstablishmentWithAllProjection findByIdWithAll(Long id);
	
	EstablishmentWithOrderProjection findByIdWithOrder(Long id);
	
	EstablishmentWithConsumableProjection findByIdWithConsumable(Long id);
	
	List<EstablishmentProjection> findEstablishmentByName(String name);
	
	List<EstablishmentProjection> findAll();
}

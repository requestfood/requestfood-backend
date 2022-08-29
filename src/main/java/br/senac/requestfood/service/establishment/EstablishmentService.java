package br.senac.requestfood.service.establishment;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.senac.requestfood.dto.establishment.EstablishmentAllDTO;
import br.senac.requestfood.dto.establishment.EstablishmentPasswordDTO;
import br.senac.requestfood.projection.establishment.EstablishmentProjection;
import br.senac.requestfood.projection.establishment.EstablishmentWithAllProjection;
import br.senac.requestfood.projection.establishment.EstablishmentWithConsumableProjection;
import br.senac.requestfood.projection.establishment.EstablishmentWithOrderProjection;

public interface EstablishmentService {

	EstablishmentAllDTO save(EstablishmentAllDTO establishmentDTO);
	
	void update(EstablishmentAllDTO establishmentDTO, Long id);
	
	void updatePassword(EstablishmentPasswordDTO establishmentDTO, Long id);
	
	void delete(Long id);
	
	EstablishmentProjection findById(Long id);
	
	EstablishmentWithAllProjection findByIdWithAll(Long id);
	
	EstablishmentWithOrderProjection findByIdWithOrder(Long id);
	
	EstablishmentWithConsumableProjection findByIdWithConsumable(Long id);
	
	List<EstablishmentProjection> findByName(String name);
	
	Page<EstablishmentProjection> findAll(Pageable pageable);
	
	List<EstablishmentProjection> findAll();
}

package br.senac.requestfood.service.establishment;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.senac.requestfood.dto.establishment.EstablishmentAllDTO;
import br.senac.requestfood.dto.establishment.EstablishmentWithConsumablesDTO;
import br.senac.requestfood.projection.establishment.EstablishmentCardProjection;
import br.senac.requestfood.projection.establishment.EstablishmentProjection;
import br.senac.requestfood.projection.establishment.EstablishmentWithOrderProjection;

public interface EstablishmentService {

	EstablishmentAllDTO save(EstablishmentAllDTO establishmentDTO);
	
	void update(EstablishmentAllDTO establishmentDTO, Long id);
	
	void delete(Long id);
	
	Boolean setOpen(Long id);
	
	EstablishmentProjection findById(Long id);
	
	EstablishmentWithOrderProjection findByIdWithOrder(Long id);
	
	EstablishmentWithConsumablesDTO findByIdWithConsumable(Long id);
	
	List<EstablishmentCardProjection> findByName(String name);

	Page<EstablishmentCardProjection> findNameByOrderByAsc(Pageable pageable, Integer page);
	
	Page<EstablishmentCardProjection> findNameByOrderByDesc(Pageable pageable, Integer page);
	
	Page<EstablishmentCardProjection> findAll(Pageable pageable, Integer page);
	
	Page<EstablishmentCardProjection> findAllToCard(Pageable pageable, Integer page);
	
}

package br.senac.requestfood.service.establishment;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.senac.requestfood.dto.establishment.EstablishmentAllDTO;
import br.senac.requestfood.dto.establishment.EstablishmentImageDTO;
import br.senac.requestfood.dto.establishment.EstablishmentUpdateDTO;
import br.senac.requestfood.dto.establishment.EstablishmentWithOrdersDTO;
import br.senac.requestfood.dto.establishment.EstablishmentWithOrdersReadyDTO;
import br.senac.requestfood.projection.establishment.EstablishmentCardProjection;
import br.senac.requestfood.projection.establishment.EstablishmentProjection;
import br.senac.requestfood.projection.establishment.EstablishmentStartOrderProjection;
import br.senac.requestfood.projection.establishment.EstablishmentUpdateProjection;

public interface EstablishmentService {

	EstablishmentAllDTO save(EstablishmentAllDTO establishmentDTO);
	
	void saveImage(byte[] image, Long id);
	
	void update(EstablishmentUpdateDTO establishmentDTO, Long id);
	
	void delete(Long id);
	
	Boolean setOpen(Long id);
	
	EstablishmentUpdateProjection findById(Long id);
	
	EstablishmentImageDTO findByIdImage(Long id);
	
	EstablishmentStartOrderProjection findByIdStartOrder(Long id);
	
	EstablishmentWithOrdersReadyDTO findByIdWithOrderReady(Long id);
	
	EstablishmentWithOrdersDTO findByIdWithOrder(Long id);
	
	Page<EstablishmentCardProjection> findByName(Pageable pageable, Integer page,String name);

	Page<EstablishmentCardProjection> findAllToCard(Pageable pageable, Integer page);
	
	List<EstablishmentProjection> findAll();
	
	
}

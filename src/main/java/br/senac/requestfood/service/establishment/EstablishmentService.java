package br.senac.requestfood.service.establishment;

import java.util.List;

import br.senac.requestfood.dto.estabelecimento.EstabelecimentoDTO;
import br.senac.requestfood.projection.estabelecimento.EstabelecimentoProjection;
import br.senac.requestfood.projection.estabelecimento.EstablishmentWithAllProjection;
import br.senac.requestfood.projection.estabelecimento.EstablishmentWithCommandProjection;
import br.senac.requestfood.projection.estabelecimento.EstablishmentWithConsumableProjection;
import br.senac.requestfood.projection.estabelecimento.EstablishmentWithTableProjection;

public interface EstablishmentService {

	EstabelecimentoDTO save(EstabelecimentoDTO establishmentDTO);
	
	void update(EstabelecimentoDTO establishmentDTO, Long id);
	
	void delete(Long id);
	
	EstabelecimentoProjection findById(Long id);
	
	EstablishmentWithAllProjection findByIdWithAll(Long id);
	
	EstablishmentWithCommandProjection findByIdWithCommand(Long id);
	
	EstablishmentWithConsumableProjection findByIdWithComsumable(Long id);
	
	EstablishmentWithTableProjection findByIdWithTable(Long id);
	
	List<EstabelecimentoProjection> findAll();
}

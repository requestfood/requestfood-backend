package br.senac.requestfood.service.establishment;

import java.util.List;

import org.springframework.stereotype.Service;

import br.senac.requestfood.dto.estabelecimento.EstabelecimentoDTO;
import br.senac.requestfood.exception.client.ContactRegisteredExeception;
import br.senac.requestfood.exception.establishment.EstablishmentNotFoundException;
import br.senac.requestfood.mapper.estabelecimento.EstabelecimentoMapper;
import br.senac.requestfood.model.usuario.estabelecimento.Estabelecimento;
import br.senac.requestfood.projection.estabelecimento.EstabelecimentoProjection;
import br.senac.requestfood.projection.estabelecimento.EstablishmentWithAllProjection;
import br.senac.requestfood.projection.estabelecimento.EstablishmentWithCommandProjection;
import br.senac.requestfood.projection.estabelecimento.EstablishmentWithConsumableProjection;
import br.senac.requestfood.projection.estabelecimento.EstablishmentWithTableProjection;
import br.senac.requestfood.repository.estabelecimento.EstabelecimentoRepository;

@Service
public class EstablishmentServiceImpl implements EstablishmentService {
	
	private final EstabelecimentoRepository repository;
	private final EstabelecimentoMapper mapper;
	
	public EstablishmentServiceImpl (EstabelecimentoRepository repository, EstabelecimentoMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}
	
	public EstabelecimentoDTO save(EstabelecimentoDTO establishmentDTO) {

		if (repository.existsByContact(establishmentDTO.contato()))
			throw new ContactRegisteredExeception("Contact " + establishmentDTO.nome() + " is already registered");
		
		Estabelecimento establishment = mapper.toEntity(establishmentDTO);
		Estabelecimento establishmentSaved = repository.save(establishment);
		
		return mapper.toDTO(establishmentSaved);
	}
	
	public void update(EstabelecimentoDTO establishmentDTO, Long id) {

		Estabelecimento establishment = repository.findById(id).orElseThrow(() -> new EstablishmentNotFoundException("Establishment "+ id +" was not found"));
		
		if (repository.existsByContact(establishmentDTO.contato()))
			throw new ContactRegisteredExeception("Contact " + establishmentDTO.nome() + " is already registered");
		
		establishment.setNome(establishmentDTO.nome());
		establishment.setContato(establishmentDTO.contato());
		
		repository.save(establishment);
	}
	
	public void delete(Long id) {

		if(!repository.existsById(id))
			throw new EstablishmentNotFoundException("Establishment "+ id +" was not found");
		
		repository.deleteById(id);
	}
	
	public EstabelecimentoProjection findById(Long id) {

		EstabelecimentoProjection establishment = repository.findEstablishmentById(id).orElseThrow(() -> new EstablishmentNotFoundException("Establishment "+ id +" was not found"));
		
		return establishment;
	}
	
	public EstablishmentWithAllProjection findByIdWithAll(Long id) {

		EstablishmentWithAllProjection establishment = repository.findEstablishmentWithAllById(id).orElseThrow(() -> new EstablishmentNotFoundException("Establishment "+ id +" was not found"));
		
		return establishment;
	}
	
	public EstablishmentWithCommandProjection findByIdWithCommand(Long id) {

		EstablishmentWithCommandProjection establishment = repository.findEstablishmentWithCommandById(id).orElseThrow(() -> new EstablishmentNotFoundException("Establishment "+ id +" was not found"));
		
		return establishment;
	}
	
	public EstablishmentWithConsumableProjection findByIdWithComsumable(Long id) {

		EstablishmentWithConsumableProjection establishment = repository.findEstablishmentWithConsumableById(id).orElseThrow(() -> new EstablishmentNotFoundException("Establishment "+ id +" was not found"));
		
		return establishment;
	}
	
	public EstablishmentWithTableProjection findByIdWithTable(Long id) {

		EstablishmentWithTableProjection establishment = repository.findEstablishmentWithTableById(id).orElseThrow(() -> new EstablishmentNotFoundException("Establishment "+ id +" was not found"));
		
		return establishment;
	}
	
	public List<EstabelecimentoProjection> findAll() {

		return repository.findEstablishments();
	}
}

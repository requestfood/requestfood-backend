package br.senac.requestfood.service.establishment;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.senac.requestfood.dto.establishment.EstablishmentAllDTO;
import br.senac.requestfood.dto.establishment.EstablishmentPasswordDTO;
import br.senac.requestfood.exception.establishment.EstablishmentNotFoundException;
import br.senac.requestfood.mapper.establishment.EstablishmentMapper;
import br.senac.requestfood.model.user.establishment.Establishment;
import br.senac.requestfood.projection.establishment.EstablishmentProjection;
import br.senac.requestfood.projection.establishment.EstablishmentWithAllProjection;
import br.senac.requestfood.projection.establishment.EstablishmentWithConsumableProjection;
import br.senac.requestfood.projection.establishment.EstablishmentWithOrderProjection;
import br.senac.requestfood.repository.establisment.EstablishmentRepository;

@Service
public class EstablishmentServiceImpl implements EstablishmentService {
	
	private final EstablishmentRepository repository;
	private final EstablishmentMapper mapper;
	
	public EstablishmentServiceImpl (EstablishmentRepository repository, EstablishmentMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}
	
	public EstablishmentAllDTO save(EstablishmentAllDTO dto) {

		Establishment establishment = mapper.AllToEntity(dto);
		Establishment establishmentSaved = repository.save(establishment);
		
		return mapper.AllToDTO(establishmentSaved);
	}
	
	public void update(EstablishmentAllDTO dto, Long id) {

		Establishment establishment = repository.findById(id).orElseThrow(() -> new EstablishmentNotFoundException("Establishment "+ id +" was not found"));
		
		establishment.setName(dto.name());
		establishment.getContact().setPhone(dto.phone());
		establishment.setCep(dto.cep());
		establishment.setDescription(dto.description());
		establishment.setImage(dto.image());
		
		repository.save(establishment);
	}
	
	public void updatePassword(EstablishmentPasswordDTO dto, Long id) {

		Establishment establishment = repository.findById(id).orElseThrow(() -> new EstablishmentNotFoundException("Establishment "+ id +" was not found"));
		
		establishment.setPassword(dto.password());
		
		repository.save(establishment);
	}
	
	public void delete(Long id) {

		if(!repository.existsById(id))
			throw new EstablishmentNotFoundException("Establishment "+ id +" was not found");
		
		repository.deleteById(id);
	}
	
	public EstablishmentProjection findById(Long id) {

		EstablishmentProjection establishment = repository.findEstablishmentById(id).orElseThrow(() -> new EstablishmentNotFoundException("Establishment "+ id +" was not found"));
		return establishment;
	}
	
	public EstablishmentWithAllProjection findByIdWithAll(Long id) {

		EstablishmentWithAllProjection establishment = repository.findEstablishmentWithAllById(id).orElseThrow(() -> new EstablishmentNotFoundException("Establishment "+ id +" was not found"));
		return establishment;
	}
	
	public EstablishmentWithOrderProjection findByIdWithOrder(Long id) {

		EstablishmentWithOrderProjection establishment = repository.findEstablishmentWithCommandById(id).orElseThrow(() -> new EstablishmentNotFoundException("Establishment "+ id +" was not found"));
		return establishment;
	}
	
	public EstablishmentWithConsumableProjection findByIdWithConsumable(Long id) {

		EstablishmentWithConsumableProjection establishment = repository.findEstablishmentWithConsumableById(id).orElseThrow(() -> new EstablishmentNotFoundException("Establishment "+ id +" was not found"));
		return establishment;
	}

	public List<EstablishmentProjection> findByName(String name) {
		return repository.findByNameContainingIgnoreCase(name);
	}

	public Page<EstablishmentProjection> findAll(Pageable pageable) {
		return repository.findEstablishments(pageable);
	}

	public List<EstablishmentProjection> findAll() {
		return repository.findEstablishments();
	}
}

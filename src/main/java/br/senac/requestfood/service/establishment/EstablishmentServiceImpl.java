package br.senac.requestfood.service.establishment;

import java.util.List;

import org.springframework.stereotype.Service;

import br.senac.requestfood.dto.establishment.EstablishmentRegisterDTO;
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
	
	public EstablishmentRegisterDTO save(EstablishmentRegisterDTO dto) {

		Establishment establishment = mapper.RegisterToEntity(dto);
		Establishment establishmentSaved = repository.save(establishment);
		
		return mapper.RegisterToDTO(establishmentSaved);
	}
	
	public void update(EstablishmentRegisterDTO dto, Long id) {

		Establishment establishment = repository.findById(id).orElseThrow(() -> new EstablishmentNotFoundException("Establishment "+ id +" was not found"));
		
		establishment.setName(dto.name());
		establishment.getContact().setEmail(dto.email());
		establishment.getContact().setPhone(dto.phone());
		establishment.setCep(dto.cep());
		establishment.setDescription(dto.description());
		establishment.setImage(dto.image());
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
	
	public List<EstablishmentProjection> findAll() {
		return repository.findEstablishments();
	}
}

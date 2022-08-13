package br.senac.requestfood.service.establishment;

import java.util.List;

import org.springframework.stereotype.Service;

import br.senac.requestfood.dto.establishment.EstablishmentDTO;
import br.senac.requestfood.exception.client.ContactRegisteredException;
import br.senac.requestfood.exception.establishment.EstablishmentNotFoundException;
import br.senac.requestfood.mapper.establishment.EstablishmentMapper;
import br.senac.requestfood.model.user.establishment.Establishment;
import br.senac.requestfood.projection.establishment.EstablishmentProjection;
import br.senac.requestfood.projection.establishment.EstablishmentWithAllProjection;
import br.senac.requestfood.projection.establishment.EstablishmentWithCommandProjection;
import br.senac.requestfood.projection.establishment.EstablishmentWithConsumableProjection;
import br.senac.requestfood.repository.establisment.EstablishmentRepository;

@Service
public class EstablishmentServiceImpl implements EstablishmentService {
	
	private final EstablishmentRepository repository;
	private final EstablishmentMapper mapper;
	
	public EstablishmentServiceImpl (EstablishmentRepository repository, EstablishmentMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}
	
	public EstablishmentDTO save(EstablishmentDTO establishmentDTO) {

		if (repository.existsByContact(establishmentDTO.contact()))
			throw new ContactRegisteredException("Contact " + establishmentDTO.name() + " is already registered");
		
		Establishment establishment = mapper.toEntity(establishmentDTO);
		Establishment establishmentSaved = repository.save(establishment);
		
		return mapper.toDTO(establishmentSaved);
	}
	
	public void update(EstablishmentDTO establishmentDTO, Long id) {

		Establishment establishment = repository.findById(id).orElseThrow(() -> new EstablishmentNotFoundException("Establishment "+ id +" was not found"));
		
		if (repository.existsByContact(establishmentDTO.contact()))
			throw new ContactRegisteredException("Contact " + establishmentDTO.name() + " is already registered");
		
		establishment.setName(establishmentDTO.name());
		establishment.setContact(establishmentDTO.contact());
		establishment.setCep(establishmentDTO.cep());
		establishment.setDescription(establishmentDTO.description());
		establishment.setImage(establishmentDTO.image());
		
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
	
	public EstablishmentWithCommandProjection findByIdWithCommand(Long id) {

		EstablishmentWithCommandProjection establishment = repository.findEstablishmentWithCommandById(id).orElseThrow(() -> new EstablishmentNotFoundException("Establishment "+ id +" was not found"));
		
		return establishment;
	}
	
	public EstablishmentWithConsumableProjection findByIdWithComsumable(Long id) {

		EstablishmentWithConsumableProjection establishment = repository.findEstablishmentWithConsumableById(id).orElseThrow(() -> new EstablishmentNotFoundException("Establishment "+ id +" was not found"));
		
		return establishment;
	}
	
	public List<EstablishmentProjection> findAll() {

		return repository.findEstablishments();
	}
}

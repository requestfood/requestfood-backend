package br.senac.requestfood.service.consumable;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.senac.requestfood.dto.establishment.EstablishmentWithConsumablesDTO;
import br.senac.requestfood.exception.consumable.ConsumableNotFoundException;
import br.senac.requestfood.exception.establishment.EstablishmentNotFoundException;
import br.senac.requestfood.projection.consumable.ConsumableProjection;
import br.senac.requestfood.projection.establishment.EstablishmentProjection;
import br.senac.requestfood.repository.consumable.ConsumableRepository;
import br.senac.requestfood.repository.establisment.EstablishmentRepository;

@Service
public class ConsumableServiceImpl implements ConsumableService{

	private final ConsumableRepository repository;
	private final EstablishmentRepository establishmentRepository;
	
	public ConsumableServiceImpl(ConsumableRepository repository, EstablishmentRepository establishmentRepository) {
		this.repository = repository;
		this.establishmentRepository = establishmentRepository;
	}

	public ConsumableProjection findById(Long id) {
		
		ConsumableProjection consumable = repository.findConsumableById(id).orElseThrow(() -> new ConsumableNotFoundException("Consumable "+ id +" was not found."));
		
		return consumable;
	}
	
	public EstablishmentWithConsumablesDTO findByName(Long id, String name, Integer page, Pageable pageable) {

		int size = 4;
		pageable = PageRequest.of(page,size, Sort.Direction.ASC, "name");
		
		EstablishmentProjection establishment = establishmentRepository.findEstablishmentById(id).orElseThrow(() -> new EstablishmentNotFoundException("Establishment " + id + " was not found"));
		return new EstablishmentWithConsumablesDTO(establishment.getId(), establishment.getName(), repository.findByNameContainingIgnoreCase(name, pageable));
	}

	public EstablishmentWithConsumablesDTO findByPriceByOrdemByAsc(Long id, Integer page, Pageable pageable) {

		int size = 4;
		pageable = PageRequest.of(page,size, Sort.Direction.ASC, "price");

		EstablishmentProjection establishment = establishmentRepository.findEstablishmentById(id).orElseThrow(() -> new EstablishmentNotFoundException("Establishment " + id + " was not found"));
		return new EstablishmentWithConsumablesDTO(establishment.getId(), establishment.getName(), repository.findConsumables(pageable));
	}
	
	public EstablishmentWithConsumablesDTO findByPriceByOrdemByDesc(Long id, Integer page, Pageable pageable) {
		
		int size = 4;
		pageable = PageRequest.of(page,size, Sort.Direction.DESC, "price");
		
		EstablishmentProjection establishment = establishmentRepository.findEstablishmentById(id).orElseThrow(() -> new EstablishmentNotFoundException("Establishment " + id + " was not found"));
		return new EstablishmentWithConsumablesDTO(establishment.getId(), establishment.getName(), repository.findConsumables(pageable));
	}
	
	public EstablishmentWithConsumablesDTO findAll(Long id, Integer page, Pageable pageable) {

		int size = 4;
		pageable = PageRequest.of(page,size, Sort.Direction.ASC, "name");
		
		EstablishmentProjection establishment = establishmentRepository.findEstablishmentById(id).orElseThrow(() -> new EstablishmentNotFoundException("Establishment " + id + " was not found"));
		return new EstablishmentWithConsumablesDTO(establishment.getId(), establishment.getName(), repository.findConsumables(pageable));
	}
	
	public List<ConsumableProjection> findAll() {
		return repository.findConsumables();
	}
}

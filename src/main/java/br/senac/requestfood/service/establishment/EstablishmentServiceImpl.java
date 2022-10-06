package br.senac.requestfood.service.establishment;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.senac.requestfood.dto.establishment.EstablishmentAllDTO;
import br.senac.requestfood.dto.establishment.EstablishmentImageDTO;
import br.senac.requestfood.dto.establishment.EstablishmentUpdateDTO;
import br.senac.requestfood.dto.establishment.EstablishmentWithOrdersDTO;
import br.senac.requestfood.dto.establishment.EstablishmentWithOrdersReadyDTO;
import br.senac.requestfood.dto.order.establishment.OrderReadyDTO;
import br.senac.requestfood.enumeration.order.OrderStatus;
import br.senac.requestfood.exception.contact.ContactEmailRegisteredException;
import br.senac.requestfood.exception.contact.ContactPhoneRegisteredException;
import br.senac.requestfood.exception.establishment.EstablishmentNotFoundException;
import br.senac.requestfood.mapper.establishment.EstablishmentMapper;
import br.senac.requestfood.model.user.establishment.Establishment;
import br.senac.requestfood.projection.establishment.EstablishmentCardProjection;
import br.senac.requestfood.projection.establishment.EstablishmentProjection;
import br.senac.requestfood.projection.establishment.EstablishmentStartOrderProjection;
import br.senac.requestfood.projection.order.OrderProjection;
import br.senac.requestfood.repository.contact.ContactRepository;
import br.senac.requestfood.repository.establisment.EstablishmentRepository;
import br.senac.requestfood.repository.order.OrderRepository;

@Service
public class EstablishmentServiceImpl implements EstablishmentService {
	
	private final EstablishmentRepository repository;
	private final ContactRepository contactRepository;
	private final OrderRepository orderRepository;
	private final EstablishmentMapper mapper;
	
	public EstablishmentServiceImpl (EstablishmentRepository repository, ContactRepository repositoryContact,EstablishmentMapper mapper, OrderRepository orderRepository) {
		this.repository = repository;
		this.contactRepository = repositoryContact;
		this.mapper = mapper;
		this.orderRepository = orderRepository;
	}
	
	public EstablishmentAllDTO save(EstablishmentAllDTO dto) {
		
		if (contactRepository.existsByPhone(dto.phone())) 
			throw new ContactPhoneRegisteredException("Phone "+ dto.phone() +" is already registered");
		if (contactRepository.existsByEmail(dto.email())) 
			throw new ContactEmailRegisteredException("Email "+ dto.email() +" is already registered");
		
		Establishment establishment = mapper.toEntity(dto);
		
		Establishment establishmentSaved = repository.save(establishment);
		
		return mapper.toDTO(establishmentSaved);
	}
	
	public EstablishmentImageDTO saveImage(EstablishmentImageDTO dto, Long id) {
		
		Establishment establishment = repository.findById(id).orElseThrow(() -> new EstablishmentNotFoundException("Establishment "+ id +" was not found"));
		
		Establishment establishmentSaved = repository.save(establishment);
		
		return new EstablishmentImageDTO(establishmentSaved.getImage());
	}
	
	public void update(EstablishmentUpdateDTO dto, Long id) {

		Establishment establishment = repository.findById(id).orElseThrow(() -> new EstablishmentNotFoundException("Establishment "+ id +" was not found"));

		establishment.setName(dto.name());
		// establishment.setImage(dto.image());
		establishment.setTimeToOpen(dto.timeToOpen());
		establishment.setTimeToClose(dto.timeToClose());
		
		
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
	
	public EstablishmentStartOrderProjection findByIdStartOrder(Long id) {
		
		EstablishmentStartOrderProjection establishment = repository.findEstablishmentStartOrderById(id).orElseThrow(() -> new EstablishmentNotFoundException("Establishment "+ id +" was not found"));
		return establishment;
	}
	
	public EstablishmentWithOrdersDTO findByIdWithOrder(Long id) {

		Establishment establishment = repository.findById(id).orElseThrow(() -> new EstablishmentNotFoundException("Establishment "+ id +" was not found"));
		EstablishmentWithOrdersDTO establishmentWithOrders = mapper.toEWOrdersDTO(establishment);
		
		return establishmentWithOrders;
	}

	public Page<EstablishmentCardProjection> findByName(Pageable pageable, Integer page, String name) {	
		int size = 4;
		
		pageable = PageRequest.of(page,size, Sort.Direction.ASC, "name");
		return repository.findByNameContainingIgnoreCase(pageable, name);
	}

	public Page<EstablishmentCardProjection> findAllToCard(Pageable pageable, Integer page) {
		int size = 4;
		
		pageable = PageRequest.of(page,size, Sort.Direction.ASC, "name");
		return repository.findEstablishments(pageable);
	}

	public List<EstablishmentProjection> findAll() {
		return repository.findEstablishments();
	}
	
	public Boolean setOpen(Long id) {
		
		Establishment establishment =  repository.findById(id).orElseThrow(() -> new EstablishmentNotFoundException("Establishment "+ id +" was not found"));
		
		if (LocalTime.now().getHour() > establishment.getTimeToOpen().getHour() && LocalTime.now().getHour() < establishment.getTimeToClose().getHour()) {
			
			if(LocalTime.now().getHour() == establishment.getTimeToOpen().getHour()) {
				
				if(LocalTime.now().getMinute() <= establishment.getTimeToOpen().getMinute())		
					establishment.setOpen(true);
					return establishment.getOpen();
			}
			
			if(LocalTime.now().getHour() == establishment.getTimeToClose().getHour()) {
				
				if(LocalTime.now().getMinute() <= establishment.getTimeToClose().getMinute())
					establishment.setOpen(false);
					return establishment.getOpen();
			}
		}
		establishment.setOpen(false);
		return establishment.getOpen();	
	}

	public EstablishmentWithOrdersReadyDTO findByIdWithOrderReady(Long id) {
		
		Establishment establishment = repository.findById(id).orElseThrow(() -> new EstablishmentNotFoundException("Establishment "+ id +" was not found"));
		
		List<OrderProjection> orders = orderRepository.findAllByOrderStatusAndEstablishmentId(OrderStatus.READY, establishment.getId());
		List<OrderReadyDTO> dtos = new ArrayList<>();
		
		for (OrderProjection order : orders) {
			dtos.add(new OrderReadyDTO(order.getId(), order.getClient().getName(), order.getClosingDate()));
		}
		
		return new EstablishmentWithOrdersReadyDTO(establishment.getId(), establishment.getName(), dtos);
	}

}






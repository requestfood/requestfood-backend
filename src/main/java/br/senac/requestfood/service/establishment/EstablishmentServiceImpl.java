package br.senac.requestfood.service.establishment;

import java.util.ArrayList;
import java.util.Base64;
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
import br.senac.requestfood.projection.establishment.EstablishmentUpdateProjection;
import br.senac.requestfood.projection.establishment.EstablishmentWithOrdersProjection;
import br.senac.requestfood.projection.order.OrderProjection;
import br.senac.requestfood.repository.contact.ContactRepository;
import br.senac.requestfood.repository.establisment.EstablishmentRepository;
import br.senac.requestfood.repository.order.OrderRepository;
import br.senac.requestfood.util.ImageUtil;

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
	
	public void saveImage(byte[] image, Long id) {
		
		Establishment establishment = repository.findById(id).orElseThrow(() -> new EstablishmentNotFoundException("Establishment "+ id +" was not found"));
		
		establishment.setImage(image);
		
		repository.save(establishment);
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
	
	public EstablishmentUpdateProjection findById(Long id) {

		EstablishmentUpdateProjection establishment = repository.findEstablishmentUpdateById(id).orElseThrow(() -> new EstablishmentNotFoundException("Establishment "+ id +" was not found"));
		return establishment;
	}
	
	public EstablishmentStartOrderProjection findByIdStartOrder(Long id) {
		
		EstablishmentStartOrderProjection establishment = repository.findEstablishmentStartOrderById(id).orElseThrow(() -> new EstablishmentNotFoundException("Establishment "+ id +" was not found"));
		return establishment;
	}
	
	public EstablishmentWithOrdersDTO findByIdWithOrder(Long id) {
		
		EstablishmentWithOrdersProjection establishment = repository.findEstablishmentWithOrdersById(id).orElseThrow(() -> new EstablishmentNotFoundException("No orders was found."));
		List<OrderProjection> orders = new ArrayList<>();
		
		for (OrderProjection order: establishment.getOrders()) {
			
			if(order.getOrderStatus() != OrderStatus.WAITING)
				orders.add(order);
		}
		
		EstablishmentWithOrdersDTO establishmentWithOrders = mapper.toEWOrdersDTO(establishment, orders);
		
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
	
	public EstablishmentImageDTO findByIdImage(Long id) {
		
		final Establishment dbImage = repository.findById(id).orElseThrow(() -> new EstablishmentNotFoundException("Establishment "+ id +" was not found"));
		
		if(dbImage.getImage() == null)
			return new EstablishmentImageDTO("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");
		else
			return new EstablishmentImageDTO(Base64.getEncoder().encodeToString(ImageUtil.decompressBytes(dbImage.getImage())));
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






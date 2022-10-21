package br.senac.requestfood.service.user;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.senac.requestfood.dto.user.LoginUserDTO;
import br.senac.requestfood.dto.user.RoleDTO;
import br.senac.requestfood.dto.user.UserPasswordDTO;
import br.senac.requestfood.exception.contact.ContactNotFoundException;
import br.senac.requestfood.exception.user.UserNotFoundException;
import br.senac.requestfood.exception.user.UserPasswordException;
import br.senac.requestfood.model.user.User;
import br.senac.requestfood.model.user.establishment.Establishment;
import br.senac.requestfood.projection.contact.ContactProjection;
import br.senac.requestfood.projection.user.UserProjection;
import br.senac.requestfood.repository.contact.ContactRepository;
import br.senac.requestfood.repository.establisment.EstablishmentRepository;
import br.senac.requestfood.repository.user.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	private final UserRepository repository;
	private final ContactRepository contactRepository;
	private final PasswordEncoder encoder;
	private final EstablishmentRepository establishmentRepository;
	
	
	public UserServiceImpl(UserRepository repository, ContactRepository contactRepository, PasswordEncoder encoder, EstablishmentRepository establishmentRepository) {
		this.repository = repository;
		this.contactRepository = contactRepository;
		this.encoder = encoder;
		this.establishmentRepository = establishmentRepository;
	}

	public RoleDTO findByUser(LoginUserDTO dto) {
		
		if(!contactRepository.existsByEmail(dto.email())) {
			throw new ContactNotFoundException("Email " + dto.email() + " was not found");
		}
	
		ContactProjection contact = contactRepository.findByEmailContainsIgnoreCase(dto.email()).orElseThrow(() -> new UserNotFoundException("User with " + dto.email() + " was not found"));
		UserProjection user = repository.findUserByContactId(contact.getId()).orElseThrow(() -> new ContactNotFoundException("Contact " + contact.getId() + " was not found"));
		
		if(!dto.password().equals(user.getPassword())) {
			System.out.println(encoder.encode(dto.password()));
			throw new UserPasswordException("Incorrect password");
		}
		
		Establishment establishment = establishmentRepository.findById(user.getId()).orElse(null);
		
			if(establishment == null) {
				return new RoleDTO(user.getId(), "CLIENT_USER");
			}else {
				return new RoleDTO(user.getId(), "ESTABLISHMENT_USER");
			}
			
		}

	public void updatePassword(UserPasswordDTO dto, Long id) {

		User user = repository.findById(id).orElseThrow(() -> new UserNotFoundException("User " + id + " was not found"));
		
		if(!dto.currentPassword().equals(user.getPassword())) {
			throw new UserPasswordException("Incorrect password");
		}
		
		user.setPassword(dto.newPassword());
		
		repository.save(user);
	}
}

package br.senac.requestfood.service.user;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.senac.requestfood.dto.user.LoginUserDTO;
import br.senac.requestfood.dto.user.UserDTO;
import br.senac.requestfood.exception.contact.ContactNotFoundException;
import br.senac.requestfood.exception.user.UserNotFoundException;
import br.senac.requestfood.exception.user.UserPasswordException;
import br.senac.requestfood.projection.contact.ContactProjection;
import br.senac.requestfood.projection.user.UserProjection;
import br.senac.requestfood.repository.contact.ContactRepository;
import br.senac.requestfood.repository.user.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	private final UserRepository repository;
	private final ContactRepository contactRepository;
	private final PasswordEncoder encoder;
	
	
	public UserServiceImpl(UserRepository repository, ContactRepository contactRepository, PasswordEncoder encoder) {
		this.repository = repository;
		this.contactRepository = contactRepository;
		this.encoder = encoder;
	}

	public UserDTO findByUser(LoginUserDTO dto) {
		
		
					
		if(!contactRepository.existsByEmail(dto.email())) {
			throw new ContactNotFoundException("Email " + dto.email() + " was not found");
		}
	
		ContactProjection contact = contactRepository.findByEmailContainsIgnoreCase(dto.email()).orElseThrow(() -> new UserNotFoundException("User with " + dto.email() + " was not found"));
		
		UserProjection user = repository.findUserByContactId(contact.getId()).orElseThrow(() -> new ContactNotFoundException("Contact " + contact.getId() + " was not found"));
		
		
		
		if(!dto.password().equals(user.getPassword())) {
			System.out.println(encoder.encode(dto.password()));
			throw new UserPasswordException("Incorrect password");
		}
			
		return new UserDTO(user.getId(), user.getName(), user.getContact(), user.getPassword());
	}
}

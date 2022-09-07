package br.senac.requestfood.controller.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.senac.requestfood.dto.user.LoginUserDTO;
import br.senac.requestfood.dto.user.UserDTO;
import br.senac.requestfood.service.user.UserService;

@Controller
public class UserController {
	
	private final UserService service;
	
	public UserController(UserService service) {
		this.service = service;
	}

	@GetMapping("/login")
	public ResponseEntity<UserDTO> getUser(@RequestBody LoginUserDTO dto ) {
		return ResponseEntity.status(HttpStatus.OK).body(service.findByUser(dto));
	}
	
}

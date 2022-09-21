package br.senac.requestfood.controller.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.senac.requestfood.dto.user.LoginUserDTO;
import br.senac.requestfood.dto.user.UserPasswordDTO;
import br.senac.requestfood.service.user.UserService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/user")
public class UserController {
	
	private final UserService service;
	
	public UserController(UserService service) {
		this.service = service;
	}

	@PostMapping("/login")
	public ResponseEntity<Long> getUser(@RequestBody LoginUserDTO dto ) {
		return ResponseEntity.status(HttpStatus.OK).body(service.findByUser(dto));
	}
	
	@PutMapping("/{id}/password")
	public ResponseEntity<String> updatedUserPassword(@RequestBody UserPasswordDTO dto, @PathVariable(value = "id") Long id) {
		service.updatePassword(dto, id);
		return ResponseEntity.status(HttpStatus.OK).body("Password update successfully");
	}
	
}

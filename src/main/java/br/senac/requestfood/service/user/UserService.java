package br.senac.requestfood.service.user;

import br.senac.requestfood.dto.user.LoginUserDTO;
import br.senac.requestfood.dto.user.UserDTO;
import br.senac.requestfood.dto.user.UserPasswordDTO;

public interface UserService {

	UserDTO findByUser(LoginUserDTO dto);
	
	void updatePassword(UserPasswordDTO establishmentDTO, Long id);
}

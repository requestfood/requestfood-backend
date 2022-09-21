package br.senac.requestfood.service.user;

import br.senac.requestfood.dto.user.LoginUserDTO;
import br.senac.requestfood.dto.user.UserPasswordDTO;

public interface UserService {

	Long findByUser(LoginUserDTO dto);
	
	void updatePassword(UserPasswordDTO establishmentDTO, Long id);
}

package br.senac.requestfood.service.user;

import br.senac.requestfood.dto.user.LoginUserDTO;
import br.senac.requestfood.dto.user.UserPasswordDTO;
import br.senac.requestfood.projection.user.UserProjection;

public interface UserService {

	UserProjection findByUser(LoginUserDTO dto);
	
	void updatePassword(UserPasswordDTO establishmentDTO, Long id);
}

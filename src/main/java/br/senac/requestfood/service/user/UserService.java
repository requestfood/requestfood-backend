package br.senac.requestfood.service.user;

import br.senac.requestfood.dto.user.LoginUserDTO;
import br.senac.requestfood.dto.user.UserDTO;

public interface UserService {

	UserDTO findByUser(LoginUserDTO dto);
}

package br.senac.requestfood.repository.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.senac.requestfood.model.user.User;
import br.senac.requestfood.projection.user.UserProjection;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	String findPasswordById(Long id);
	
	Optional<UserProjection> findUserByContactId(Long id);
}

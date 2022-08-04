package br.senac.requestfood.repository.usuario;

import br.senac.requestfood.model.contato.Contato;
import br.senac.requestfood.model.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ConcurrentModificationException;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	//usem oque o professor mandou de exemplo

    boolean existsContato (Contato contato);

}

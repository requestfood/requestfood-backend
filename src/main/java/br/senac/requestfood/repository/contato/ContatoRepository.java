package br.senac.requestfood.repository.contato;

import br.senac.requestfood.model.contato.Contato;
import br.senac.requestfood.model.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long> {

    boolean existsEmail (String email);
    boolean existsTelefone (String Telefone);
    boolean existsUsuario (Usuario usuario);


	
}

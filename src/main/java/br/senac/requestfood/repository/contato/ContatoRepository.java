package br.senac.requestfood.repository.contato;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.senac.requestfood.model.contato.Contato;
import br.senac.requestfood.model.usuario.Usuario;
import br.senac.requestfood.projection.contato.ContatoProjection;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long> {

    boolean existsByEmail (String email);
    
    boolean existsByTelefone (String Telefone);
    
    boolean existsByUsuario (Usuario usuario);

    Optional<ContatoProjection> findContactById(Long id);
    
    @Query(value = "SELECT c.id_user AS id, c.name_user AS Name, c.id_contact AS Contact, c.password.user AS Password, c.genera_client AS Genre, c.data_nascimento_client AS DataNascimento FROM Client c")
    List<ContatoProjection> findContacts();
}

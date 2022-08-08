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
    
    @Query(value = "SELECT c.id_user AS id, c.name_user AS name, c.id_contact AS contact, c.password.user AS password, c.genero_client AS genero, c.data_nascimento_cliente AS data_nascimento FROM cliente c")
    List<ContatoProjection> findContacts();
}

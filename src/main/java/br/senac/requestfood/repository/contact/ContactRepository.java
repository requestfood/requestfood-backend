package br.senac.requestfood.repository.contact;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.senac.requestfood.model.contact.Contact;
import br.senac.requestfood.model.user.User;
import br.senac.requestfood.projection.contact.ContactProjection;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

    boolean existsByEmail (String email);
    
    boolean existsByPhone (String phone);
    
    boolean existsByUser (User user);

    Optional<ContactProjection> findContactById(Long id);
    
    @Query(value = "SELECT c.id_user AS id, c.name_user AS Name, c.id_contact AS Contact, c.password.user AS Password, c.genera_client AS Genre, c.data_nascimento_client AS DataNascimento FROM Client c")
    List<ContactProjection> findContacts();
}

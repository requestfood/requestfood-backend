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
    
    @Query(value = "SELECT c.id_user AS id, c.name_user AS name, c.id_contact AS id, c.phone_contact AS phone, c.email_contact AS email, c.password.user AS password, c.gender_client AS gender, c.date_birth_client AS birthDate FROM Client c")
    List<ContactProjection> findContacts();
}

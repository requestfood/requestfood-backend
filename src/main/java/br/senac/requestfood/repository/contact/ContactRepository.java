package br.senac.requestfood.repository.contact;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.senac.requestfood.model.contact.Contact;
import br.senac.requestfood.projection.contact.ContactProjection;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

    boolean existsByEmail (String email);
    
    boolean existsByPhone (String phone);

    Optional<ContactProjection> findContactById(Long id);
    
    Optional<ContactProjection> findByEmailContainsIgnoreCase(String email);
    
    @Query(value = "SELECT c.id AS id, c.phone AS phone, c.email AS email FROM Contact c")
    List<ContactProjection> findContacts();
}

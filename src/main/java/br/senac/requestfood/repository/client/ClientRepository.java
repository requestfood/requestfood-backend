package br.senac.requestfood.repository.client;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.senac.requestfood.model.contact.Contact;
import br.senac.requestfood.model.user.client.Client;
import br.senac.requestfood.projection.client.ClientProjection;
import br.senac.requestfood.projection.client.ClientWithOrdersProjection;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
  
    boolean existsByContact (Contact contact);
    
    Optional<ClientProjection> findClientById(Long id);

    Optional<ClientWithOrdersProjection> findClientWithOrdersById(Long id);
    
    @Query(value = "SELECT c.id AS id, c.name AS name, c.contact AS contact, c.password AS password, c.surname AS surname, c.gender AS gender, c.birthDate AS birthdate FROM Client c")
    List<ClientProjection> findClients();
}

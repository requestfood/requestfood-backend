package br.senac.requestfood.repository.client;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.senac.requestfood.enumeration.order.OrderStatus;
import br.senac.requestfood.model.user.client.Client;
import br.senac.requestfood.projection.client.ClientProjection;
import br.senac.requestfood.projection.client.ClientWithOrdersProjection;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
	
    Optional<ClientProjection> findClientById(Long id);

    Optional<ClientWithOrdersProjection> findClientWithOrdersById(Long id);
    
    @Query(value = "SELECT u.id AS id, u.name AS name, u.contact AS contact, u.password AS password, c.surname AS surname, c.gender AS gender, c.birthDate AS birthDate FROM User u JOIN Client c ON u.id = c.id")
    List<ClientProjection> findClients();
}

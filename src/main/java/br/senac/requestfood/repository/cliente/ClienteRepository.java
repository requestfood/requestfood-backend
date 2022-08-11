package br.senac.requestfood.repository.cliente;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.senac.requestfood.model.contato.Contato;
import br.senac.requestfood.model.usuario.cliente.Cliente;
import br.senac.requestfood.projection.cliente.ClienteProjection;
import br.senac.requestfood.projection.cliente.ClienteWithComandasProjection;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
  
    boolean existsByContact (Contato contato);
    
    Optional<ClienteProjection> findClientById(Long id);

    Optional<ClienteWithComandasProjection> findClienteWithCommandsById(Long id);
    
    @Query(value = "SELECT c.id_user AS id, c.name_user AS Name, c.id_contact AS Contact, c.password.user AS Password, c.genero_client AS Genero, c.data_nascimento_cliente AS DataNascimento FROM cliente c")
    List<ClienteProjection> findClients();
}

package br.senac.requestfood.repository.cliente;

import br.senac.requestfood.enumeration.genero.Genero;
import br.senac.requestfood.model.usuario.cliente.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    boolean existsGenero (Genero genero);



	
}

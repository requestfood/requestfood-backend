package br.senac.requestfood.repository.cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.senac.requestfood.enumeration.genero.Genero;
import br.senac.requestfood.model.usuario.cliente.Cliente;

import java.time.LocalDate;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {


    boolean existsName(String name);
    boolean existsContato (String contato);

    boolean existsPassword (String password);

    boolean existsGenero (Genero genero);




	
}

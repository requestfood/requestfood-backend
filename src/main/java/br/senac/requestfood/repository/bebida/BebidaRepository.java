package br.senac.requestfood.repository.bebida;

import br.senac.requestfood.model.consumivel.bebida.Bebida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BebidaRepository extends JpaRepository<Bebida, Long> {

	
}

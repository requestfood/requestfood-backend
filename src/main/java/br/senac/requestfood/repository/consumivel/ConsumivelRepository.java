package br.senac.requestfood.repository.consumivel;

import br.senac.requestfood.model.consumivel.Consumivel;
import br.senac.requestfood.model.usuario.estabelecimento.Estabelecimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsumivelRepository extends JpaRepository<Consumivel, Long> {

    boolean existsEstabelecimento (Estabelecimento estabelecimento);


}

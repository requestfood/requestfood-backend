package br.senac.requestfood.repository.estabelecimento;

import br.senac.requestfood.model.usuario.estabelecimento.Estabelecimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstabelecimentoRepository extends JpaRepository<Estabelecimento, Long> {




}

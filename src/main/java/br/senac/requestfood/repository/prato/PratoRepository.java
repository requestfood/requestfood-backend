package br.senac.requestfood.repository.prato;

import br.senac.requestfood.model.consumivel.prato.Prato;
import br.senac.requestfood.model.usuario.estabelecimento.Estabelecimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PratoRepository extends JpaRepository<Prato, Long> {
	//usem oque o professor mandou de exemplo

boolean existsEstabelecimento (Estabelecimento estabelecimento);
	
}

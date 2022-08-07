package br.senac.requestfood.repository.prato;

import br.senac.requestfood.model.consumivel.prato.Prato;
import br.senac.requestfood.model.usuario.estabelecimento.Estabelecimento;
import br.senac.requestfood.projection.bebida.BebidaProjection;
import br.senac.requestfood.projection.prato.PratoProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PratoRepository extends JpaRepository<Prato, Long> {
	//usem oque o professor mandou de exemplo

    Optional<PratoProjection> findPratoById(Long id);

    boolean existsId (Long id);
    boolean existsName (String name);

    boolean existsEstabelecimento (Estabelecimento estabelecimento);

    boolean existsValue (Float value);

    boolean existsDescription (String Description);

    boolean existsImage (Byte[] image);
	
}

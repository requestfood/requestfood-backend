package br.senac.requestfood.repository.bebida;

import br.senac.requestfood.model.consumivel.bebida.Bebida;
import br.senac.requestfood.model.usuario.estabelecimento.Estabelecimento;
import br.senac.requestfood.projection.bebida.BebidaProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BebidaRepository extends JpaRepository<Bebida, Long> {


    Optional<BebidaProjection> findBebidaById(Long id);
    boolean existsId (Long id);
    boolean existsName (String name);

    boolean existsEstabelecimento (Estabelecimento estabelecimento);

    boolean existsValue (Float value);

    boolean existsDescription (String Description);

    boolean existsImage (Byte[] image);

}

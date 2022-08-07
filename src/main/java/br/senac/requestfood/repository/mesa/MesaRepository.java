package br.senac.requestfood.repository.mesa;

import br.senac.requestfood.model.mesa.Mesa;
import br.senac.requestfood.model.usuario.Usuario;
import br.senac.requestfood.model.usuario.estabelecimento.Estabelecimento;
import br.senac.requestfood.projection.mesa.TableProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MesaRepository extends JpaRepository<Mesa, Long> {
    //usem oque o professor mandou de exemplo

    boolean existsId (Long id);

    boolean existsPassword (String password);
    boolean existsLimitUserNumber(Integer limitUserNumber);

    boolean existsEstabelecimento(Estabelecimento estabelecimento);

    @Query(value = "SELECT u.id AS id, u.name AS name, u.email AS email FROM University u")
    List<TableProjection> findComandas();

}


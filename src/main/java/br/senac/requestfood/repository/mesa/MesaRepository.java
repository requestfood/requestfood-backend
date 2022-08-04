package br.senac.requestfood.repository.mesa;

import br.senac.requestfood.model.mesa.Mesa;
import br.senac.requestfood.model.usuario.Usuario;
import br.senac.requestfood.model.usuario.estabelecimento.Estabelecimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MesaRepository extends JpaRepository<Mesa, Long> {
    //usem oque o professor mandou de exemplo

    boolean existsUsuario(Usuario usuario);

    boolean existsEstabelecimento(Estabelecimento estabelecimento);

}


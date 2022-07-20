package br.senac.requestfood.model.usuario.estabelecimento;

import br.senac.requestfood.model.consumivel.Consumivel;
import br.senac.requestfood.model.contato.Contato;
import br.senac.requestfood.model.mesa.Mesa;
import br.senac.requestfood.model.usuario.Usuario;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "estabelecimento")
@PrimaryKeyJoinColumn(name="id_usuario")
public class Estabelecimento extends Usuario {

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "estabelecimento", cascade = CascadeType.ALL)
    private List<Consumivel> consumiveis;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "estabelecimento", cascade = CascadeType.ALL)
    private List<Mesa> mesas;

    public Estabelecimento() {
    }

    public Estabelecimento(long id , String nome, Contato contato){
        super(id, nome, contato);
        mesas = new ArrayList<>();
        consumiveis = new ArrayList<>();
    }

    public List<Mesa> getMesas() {
        return mesas;
    }
    public List<Consumivel> getConsumiveis() {
        return consumiveis;
    }
}

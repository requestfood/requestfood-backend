package br.senac.requestfood.model.mesa;

import br.senac.requestfood.model.comanda.Comanda;
import br.senac.requestfood.model.usuario.estabelecimento.Estabelecimento;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

    @Entity
    @Table(name = "mesa")
    public class Mesa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numero_mesa")
    private long numero;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "id_usuario", nullable = false)
    private Estabelecimento estabelecimento;

    @Column(name = "mesa_disponivel")
    private boolean disponivel;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "mesa", cascade = CascadeType.ALL)
    private List<Comanda> comandas;


        public Mesa() {
        }

        public Mesa(Estabelecimento estabelecimento, long numero, boolean disponivelMesa) {
        setEstabelecimento(estabelecimento);
        setNumero(numero);
        setDisponivelMesa(disponivelMesa);
        comandas = new ArrayList<>();
    }

        public boolean equals(Object objeto) {

        if (this == objeto)
            return true;

        if (objeto == null)
            return false;

        if (getClass() != objeto.getClass())
            return false;

        Mesa mesa = ((Mesa) objeto);

        return this.getEstabelecimento() == mesa.getEstabelecimento() && this.getNumero() == this.getNumero() && this.getDisponivel() == mesa.getDisponivel() && this.getComandas() == mesa.getComandas();
    }
    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }
    public void setEstabelecimento(Estabelecimento estabelecimento) {
        this.estabelecimento = estabelecimento;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }
    public long getNumero() {
        return numero;
    }
    public void setDisponivelMesa(boolean disponivel) {
        this.disponivel = disponivel;
    }
    public boolean getDisponivel() {
        return disponivel;
    }
    public List<Comanda> getComandas() {
        return comandas;
    }
}

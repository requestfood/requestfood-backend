package br.senac.requestfood.modelo.entidade.mesa;

import java.util.ArrayList;
import java.util.List;

import br.senac.requestfood.modelo.entidade.comanda.Comanda;
import br.senac.requestfood.modelo.entidade.usuario.estabelecimento.Estabelecimento;

public class Mesa {

    private Estabelecimento estabelecimento;
    private long numero;
    private boolean disponivel;
    private List<Comanda> comandas;


    public Mesa(Estabelecimento estabelecimento, long numero, boolean disponivelMesa) {
        setNumero(numero);
        setDisponivelMesa(disponivelMesa);
        comandas = new ArrayList<>();
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

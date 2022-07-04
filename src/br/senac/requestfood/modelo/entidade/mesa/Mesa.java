package br.senac.requestfood.modelo.entidade.mesa;

import java.util.ArrayList;
import java.util.List;

public class Mesa {

    private int numero;
    private boolean disponivel;
    private List<Comanda> comandas;

    public Mesa(int numero, boolean disponivelMesa) {
        setNumero(numero);
        setDisponivelMesa(disponivelMesa);
        comandas = new ArrayList<>();
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public int getNumero() {
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

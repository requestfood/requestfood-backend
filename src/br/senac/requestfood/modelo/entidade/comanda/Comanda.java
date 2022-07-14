package br.senac.requestfood.modelo.entidade.comanda;

import br.senac.requestfood.modelo.entidade.item.Item;
import br.senac.requestfood.modelo.entidade.mesa.Mesa;
import br.senac.requestfood.modelo.entidade.usuario.cliente.Cliente;
import br.senac.requestfood.modelo.entidade.usuario.estabelecimento.Estabelecimento;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Comanda {

//    ATTRIBUTES

    private long id;
    private Estabelecimento estabelecimento;
    private Cliente cliente;
    private LocalDateTime dataHoraEmissao;
    private List<Item> itens;
    private Mesa mesa;
    private double valorTotal;

//    CONSTRUCTOR

    protected Comanda(long id, Estabelecimento estabelecimento, Cliente cliente, LocalDateTime dataHoraEmissao, Mesa mesa, double valorTotal){
        setCliente(cliente);
        setDataHora(dataHoraEmissao);
        setMesa(mesa);
        setValorTotal(valorTotal);
        itens = new ArrayList<>();
    }

    public boolean equals(Object objeto) {
        if (objeto == null)
            return false;
        if (this == objeto)
            return true;
        if (this.getClass() != objeto.getClass())
            return false;
        Comanda comanda = ((Comanda) objeto);
        return this.getId() == comanda.getId()
                && this.getEstabelecimento().equals(comanda.getEstabelecimento())
                && this.getCliente().equals(comanda.getCliente())
                && this.getDataHora().equals(comanda.getDataHora())
                && this.getItens().equals(comanda.getItens())
                && this.getMesa().equals(comanda.getMesa())
                && this.getValorTotal() == comanda.getValorTotal();
    }

    //    GET AND SET

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDateTime getDataHora() {
        return dataHoraEmissao;
    }

    public void setDataHora(LocalDateTime dataHoraEmissao) {
        this.dataHoraEmissao = dataHoraEmissao;
    }

    public List<Item> getItens() {
        return itens;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }
    public void setEstabelecimento(Estabelecimento estabelecimento) {
        this.estabelecimento = estabelecimento;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    //    METHODS
}

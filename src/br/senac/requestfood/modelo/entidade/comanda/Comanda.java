package br.senac.requestfood.modelo.entidade.comanda;

import br.senac.requestfood.modelo.entidade.item.Item;
import br.senac.requestfood.modelo.entidade.mesa.Mesa;
import br.senac.requestfood.modelo.entidade.usuario.cliente.Cliente;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Comanda {

//    ATTRIBUTES

    private Cliente cliente;
    private LocalDateTime dataHoraEmissao;
    private List<Item> itens;
    private Mesa mesa;
    private double valorTotal;

//    CONSTRUCTOR

    protected Comanda(Cliente cliente, LocalDateTime dataHoraEmissao, Mesa mesa, double valorTotal){
        setCliente(cliente);
        setDataHora(dataHoraEmissao);
        setMesa(mesa);
        setValorTotal(valorTotal);
        itens = new ArrayList<>();
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

//    METHODS
}

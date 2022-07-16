package br.senac.requestfood.model.comanda;

import br.senac.requestfood.model.item.Item;
import br.senac.requestfood.model.mesa.Mesa;
import br.senac.requestfood.model.usuario.cliente.Cliente;
import br.senac.requestfood.model.usuario.estabelecimento.Estabelecimento;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "comanda")
public class Comanda {

//    ATTRIBUTES

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comanda")
    private long id;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "estabelecimento_id_usuario")
    private Estabelecimento estabelecimento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id_usuario")
    private Cliente cliente;

    @Column(name = "data_hora_emissao_comanda", nullable = false)
    private LocalDateTime dataHoraEmissao;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "item", cascade = CascadeType.ALL)
    private List<Item> itens;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "numero_mesa")
    private Mesa mesa;

    private double valorTotal;

//    CONSTRUCTOR

    protected Comanda(long id, Estabelecimento estabelecimento, Cliente cliente, LocalDateTime dataHoraEmissao, Mesa mesa, double valorTotal) {
        setCliente(cliente);
        setDataHora(dataHoraEmissao);
        setMesa(mesa);
        setValorTotal(valorTotal);
        itens = new ArrayList<>();
    }

    public Comanda() {
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

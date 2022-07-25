package br.senac.requestfood.model.comanda;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.senac.requestfood.model.item.Item;
import br.senac.requestfood.model.mesa.Mesa;
import br.senac.requestfood.model.usuario.cliente.Cliente;
import br.senac.requestfood.model.usuario.estabelecimento.Estabelecimento;

@Entity
@Table(name = "comanda")
public class Comanda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comanda")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "id_estabelecimento")
    private Estabelecimento estabelecimento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @Column(name = "data_hora_emissao_comanda", nullable = false)
    private LocalDateTime dataEmissao;

    @Column(name = "data_hora_fechamento_comanda")
    private LocalDateTime dataFechamento;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "comanda", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Item> itens;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_mesa")
    private Mesa mesa;

    @Transient
    private double valorTotal;

    protected Comanda(long id, Estabelecimento estabelecimento, Cliente cliente, LocalDateTime dataHoraEmissao, Mesa mesa, double valorTotal) {
        setCliente(cliente);
        setDataEmissao(dataHoraEmissao);
        setMesa(mesa);
        setValorTotal(valorTotal);
        itens = new ArrayList<>();
    }
    
    public Comanda() {}
    
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
                && this.getDataEmissao().equals(comanda.getDataEmissao())
                && this.getDataFechamento().equals(comanda.getDataFechamento())
                && this.getItens().equals(comanda.getItens())
                && this.getMesa().equals(comanda.getMesa())
                && this.getValorTotal() == comanda.getValorTotal();
    }

    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDateTime getDataEmissao() {
        return dataEmissao;
    }
    public void setDataEmissao(LocalDateTime dataHoraEmissao) {
        this.dataEmissao = dataHoraEmissao;
    }

    public LocalDateTime getDataFechamento() {
		return dataFechamento;
	}
	public void setDataFechamento(LocalDateTime dataFechamento) {
		this.dataFechamento = dataFechamento;
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

    public void adicionarItem(Item item) {
    	itens.add(item);
    } 
    
    public void removerItem(Item item) {
    	itens.remove(item);
    }    
}
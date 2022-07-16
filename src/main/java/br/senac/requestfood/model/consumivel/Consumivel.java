package br.senac.requestfood.model.consumivel;

import br.senac.requestfood.model.usuario.estabelecimento.Estabelecimento;

import javax.persistence.*;

@Entity
@Table(name = "consumivel")
public abstract class Consumivel {

//    ATTRIBUTES

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_consumivel")
    private long id;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "id_usuario")
    private Estabelecimento estabelecimento;

    @Column(name = "nome_consumivel", length = 45, nullable = false)
    private String nome;

    @Column(name = "valor_consumivel", nullable = false)
    private float valor;

    @Column(name = "descricao_consumivel", length = 200)
    private String descricao;

    @Column(name = "imagem_consumivel")
    private Byte[] imagem;

//    CONSTRUCTOR

    protected Consumivel(long id, Estabelecimento estabelecimento, String nome, float valor, String descricao, Byte[] imagem){
        setId(id);
        setEstabelecimento(estabelecimento);
        setNome(nome);
        setValor(valor);
        setDescricao(descricao);
        setImagem(imagem);
    }

    protected Consumivel() {
    }

    //    equals

    public boolean equals(Object objeto) {
        if (objeto == null)
            return false;
        if (this == objeto)
            return true;
        if (this.getClass() != objeto.getClass())
            return false;
        Consumivel consumivel = ((Consumivel)objeto);
        return this.getId() == consumivel.getId()
                && this.getEstabelecimento().equals(consumivel.getEstabelecimento())
                && this.getNome().equals(consumivel.getNome())
                && this.getValor() == consumivel.getValor()
                && this.getDescricao().equals(consumivel.getDescricao())
                && this.getImagem().equals(consumivel.getImagem());
    }


//    GET AND SET


    public void setId(long id) {
        this.id = id;
    }
    public long getId() {
        return id;
    }

    public void setEstabelecimento(Estabelecimento estabelecimento) {
        this.estabelecimento = estabelecimento;
    }

    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setImagem(Byte[] imagem) {
        this.imagem = imagem;
    }

    public Byte[] getImagem() {
        return imagem;
    }


    //    METHODS


}
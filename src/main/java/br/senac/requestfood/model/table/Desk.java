package br.senac.requestfood.model.table;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.senac.requestfood.model.command.Command;
import br.senac.requestfood.model.user.establishment.Establishment;


@Entity
@Table(name = "desk")
public class Desk {

   	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_desk")
    private Long id;

   	@Column(name = "password_desk", unique = true, nullable = false)
    private String password;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user", nullable = false)
    private Establishment establishment;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "desk", cascade = CascadeType.PERSIST)
    private List<Command> commands;
    
    @Column(name = "limitusernumber_desk", nullable = false)
    private Integer limitUserNumber;

    public Desk() {}
     
    public Desk(Long id, String password, Establishment establishment, Integer limitUserNumber) {
        setId(id);
        setPassword(password);
        setEstablishment(establishment);
        setLimitUserNumber(limitUserNumber);
        commands = new ArrayList<>();
    }

    public boolean equals(Object objeto) {

        if (this == objeto)
            return true;

        if (objeto == null)
            return false;

        if (getClass() != objeto.getClass())
            return false;

        Desk mesa = ((Desk) objeto);

        return this.getEstablishment() == mesa.getEstablishment() && this.getId() == this.getId() && this.getComandas() == mesa.getComandas() && this.getPassword() == mesa.getPassword() && this.getLimitUserNumber() == mesa.getLimitUserNumber();
    }
        
    public Establishment getEstablishment() {
        return establishment;
    }
    public void setEstablishment(Establishment establishment) {
        this.establishment = establishment;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }
    public List<Command> getComandas() {
        return commands;
    }
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getLimitUserNumber() {
		return limitUserNumber;
	}
	public void setLimitUserNumber(Integer limitUserNumber) {
		this.limitUserNumber = limitUserNumber;
	}
	
	public void adicionarComanda(Command command) {
    	commands.add(command);
    }
    public void removerComanda(Command comanda) {
    	commands.remove(comanda);
    }
}
package br.senac.requestfood.model.command;

import java.time.LocalDateTime;
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
import javax.persistence.Transient;

import br.senac.requestfood.model.item.Item;
import br.senac.requestfood.model.table.Desk;
import br.senac.requestfood.model.user.client.Client;
import br.senac.requestfood.model.user.establishment.Establishment;

@Entity
@Table(name = "command")
public class Command {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_command")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_establishment")
    private Establishment establishment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_client")
    private Client client;

    @Column(name = "issue_date_command", nullable = false)
    private LocalDateTime IssueDate;

    @Column(name = "closing_date_command")
    private LocalDateTime closingDate;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "command", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Item> itens;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_desk")
    private Desk desk;

    @Transient
    private Double amount;

	public Command(Long id, Establishment establishment, Client client, LocalDateTime issueDate,LocalDateTime closingDate, List<Item> itens, Desk desk, Double amount) {
		this.id = id;
		this.establishment = establishment;
		this.client = client;
		this.IssueDate = issueDate;
		this.closingDate = closingDate;
		this.itens = itens;
		this.desk = desk;
		this.amount = amount;
	}

	public Command() {}
    
    public boolean equals(Object object) {
        
    	if (object == null)
            return false;
        if (this == object)
            return true;
        if (this.getClass() != object.getClass())
            return false;
        
        Command command = ((Command) object);
        return this.getId() == command.getId()
                && this.getEstablishment().equals(command.getEstablishment())
                && this.getClient().equals(command.getClient())
                && this.getIssueDate().equals(command.getIssueDate())
                && this.getClosingDate().equals(command.getClosingDate())
                && this.getItens().equals(command.getItens())
                && this.getDesk().equals(command.getDesk())
                && this.getAmount() == command.getAmount();
    }

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Establishment getEstablishment() {
		return establishment;
	}
	public void setEstablishment(Establishment establishment) {
		this.establishment = establishment;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public LocalDateTime getIssueDate() {
		return IssueDate;
	}
	public void setIssueDate(LocalDateTime issueDate) {
		IssueDate = issueDate;
	}
	public LocalDateTime getClosingDate() {
		return closingDate;
	}
	public void setClosingDate(LocalDateTime closingDate) {
		this.closingDate = closingDate;
	}
	public List<Item> getItens() {
		return itens;
	}
	public void setItens(List<Item> itens) {
		this.itens = itens;
	}
	public Desk getDesk() {
		return desk;
	}
	public void setDesk(Desk desk) {
		this.desk = desk;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
}
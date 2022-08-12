package br.senac.requestfood.model.user.client;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.senac.requestfood.enumeration.gender.Gender;
import br.senac.requestfood.model.command.Command;
import br.senac.requestfood.model.user.User;

@Entity
@Table(name = "client")
public class Client extends User {

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "gender_client", nullable = false)
    private Gender gender;
	
	@Column(name = "birth_date_client", nullable = false)
    private LocalDate birthDate;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "client", cascade = CascadeType.PERSIST)
    private List<Command> commands;
    
	public Client() {}

	public Client(Gender gender, LocalDate birthDate, List<Command> commands) {
		this.gender = gender;
		this.birthDate = birthDate;
		this.commands = commands;
	}

	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public LocalDate getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	public List<Command> getCommands() {
		return commands;
	}
	public void setCommands(List<Command> commands) {
		this.commands = commands;
	}
}
package br.senac.requestfood.model.user.client;

import java.time.LocalDate;
import java.util.ArrayList;
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
import br.senac.requestfood.model.contact.Contact;
import br.senac.requestfood.model.order.Order;
import br.senac.requestfood.model.user.User;

@Entity
@Table(name = "client")
public class Client extends User {

	@Column(name = "surname_client", length = 20, nullable = false)
	private String surname;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "gender_client", nullable = false)
    private Gender gender;
	
	@Column(name = "birth_date_client", nullable = false)
    private LocalDate birthDate;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "client", cascade = CascadeType.PERSIST)
    private List<Order> orders = new ArrayList<>();
    
	public Client() {}

	public Client(Long id, String name, Contact contact, String password, String surname, Gender gender, LocalDate birthDate) {
		super(id, name, contact, password);
		this.surname = surname;
		this.gender = gender;
		this.birthDate = birthDate;
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
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
}
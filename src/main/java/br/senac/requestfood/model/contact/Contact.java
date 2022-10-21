package br.senac.requestfood.model.contact;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "contact")
public class Contact {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_contact")
	private Long id;

	@Column(name = "phone_contact", nullable = false, length = 11, unique = true)
	private String phone;

	@Column(name = "email_contact", nullable = false, length = 50, unique = true)
	private String email;

	public Contact() {}

	public Contact(Long id ,String phone, String email) {
		setId(id);
		setPhone(phone);
		setEmail(email);
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
}
package cn.it.shop.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

public class Account implements java.io.Serializable {
	private Integer id;
	private String login;
	private String name;
	private String pass;
	private Set<Category> categories;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "account")  
	public Set<Category> getCategories() {  
	    return this.categories;  
	}
	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}
	@Column(name = "login", length = 20)
	public String getLogin() {
		return login;
	}
	@Column(name = "name", length = 20)
	public String getName() {
		return name;
	}
	@Column(name = "pass", length = 20)
	public String getPass() {
		return pass;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	} 
	
}

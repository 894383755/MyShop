package cn.it.shop.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
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
}

package cn.it.shop.model;

public class Category implements java.io.Serializable {
	private Integer id;
	//private Account account;
	private String type;
	
	public Category(){
	}
	public Category(Integer id,String type){
		this.id = id;
		this.type = type;
	}
	public Integer getId() {
		return id;
	}
	public String getType() {
		return type;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}

package cn.it.shop.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Product implements java.io.Serializable{
	/** 商品编号 **/
	private Integer id;
	/** 商品名称**/
	private String name;
	/** 商品价格**/
	private BigDecimal price;
	/** 商品图片**/
	private String pic;
	/** 商品简单介绍**/
	private String remark;
	/** 商品详细介绍**/
	private String xremark;
	/** 商品日期**/
	private Date date;
	/** 是否为推荐商品**/
	private Boolean commend;
	/** 是否为有效商品**/
	private Boolean open;
	/** 商品所在类别编号**/
	private Category category;
	
	/** default constructor */
	Product(){
	}
	@Override
	public String toString(){
		return "id : "+id+"name : " + name;
	}
	
	/** get set 方法**/
	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}
	@Column(name = "name", length = 20)
	public String getName() {
		return name;
	}
	@Column(name = "price" ,precision = 8)
	public BigDecimal getPrice() {
		return price;
	}
	@Column(name = "pic", length = 200)
	public String getPic() {
		return pic;
	}
	@Column(name = "remark")
	public String getRemark() {
		return remark;
	}
	@Column(name = "xremark")
	public String getXremark() {
		return xremark;
	}
	@Column(name = "commend")
	public Boolean getCommend() {
		return commend;
	}
	@Column(name = "open")
	public Boolean getOpen() {
		return open;
	}
	@Column(name = "date", nullable = true, length = 19)
	public Date getDate() {
		return date;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id")
	public Category getCategory() {
		return category;
	}
	
	
	public void setId(Integer id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public void setXremark(String xremark) {
		this.xremark = xremark;
	}
	public void setCommend(Boolean commend) {
		this.commend = commend;
	}
	public void setOpen(Boolean open) {
		this.open = open;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public void setCategory(Category category) {
		this.category = category;
	}

	
}

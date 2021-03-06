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

/**
 * 商品类
 * @author 王
 */
@Entity
public class Product implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = -5102917489458854913L;

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

	@Override
	public String toString() {
		return "Product [id=" + id + ", name="
				+ name + ", price=" + price + ", pic=" + pic + ", remark="
				+ remark + ", xremark=" + xremark + ", commend=" + commend + ", open=" + open + "]";
	}

	// Constructors
	/** default constructor */
	public Product() {
	}

	/** minimal constructor */
//	public Product(Timestamp date) {
//		this.date = date;
//	}


	/** full constructor */
	public Product(Category category, String name, BigDecimal price, String pic,
			String remark, String xremark, Date date, Boolean commend,
			Boolean open) {
		this.category = category;
		this.name = name;
		this.price = price;
		this.pic = pic;
		this.remark = remark;
		this.xremark = xremark;
//		this.date = date;
		this.commend = commend;
		this.open = open;
	}

	public Product(Integer id, String name, BigDecimal price, String pic,
			String remark, String xremark, Boolean commend, Boolean open) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.pic = pic;
		this.remark = remark;
		this.xremark = xremark;
		this.commend = commend;
		this.open = open;
	}


	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cid")
	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Column(name = "name", length = 20)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "price", precision = 8)
	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Column(name = "pic", length = 200)
	public String getPic() {
		return this.pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	@Column(name = "remark")
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "xremark")
	public String getXremark() {
		return this.xremark;
	}

	public void setXremark(String xremark) {
		this.xremark = xremark;
	}

	@Column(name = "date", nullable = true, length = 19)
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Column(name = "commend")
	public Boolean getCommend() {
		return this.commend;
	}

	public void setCommend(Boolean commend) {
		this.commend = commend;
	}

	@Column(name = "open")
	public Boolean getOpen() {
		return this.open;
	}

	public void setOpen(Boolean open) {
		this.open = open;
	}

}
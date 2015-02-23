package pl.cudlax.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCTS")
public class Product {
	@Id
	@GeneratedValue
	@Column(name = "PRODUCT_ID")
	private Long productId;

	@Column(name = "NAME", unique = true)
	private String name;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "AMOUNT")
	private Double amount;

	@Column(name = "CATALOG_NUM")
	private String catalogNum;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "PRODUCT_CATEGORY", joinColumns = { @JoinColumn(name = "PRODUCT_ID") }, inverseJoinColumns = { @JoinColumn(name = "CATEGORY_ID") })
	private List<Category> categories;
	
	
	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double ammount) {
		this.amount = ammount;
	}

	public String getCatalogNum() {
		return catalogNum;
	}

	public void setCatalogNum(String catalogNum) {
		this.catalogNum = catalogNum;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

}

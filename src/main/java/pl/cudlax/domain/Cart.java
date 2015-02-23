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
@Table(name = "CART")
public class Cart {
	@Id
	@GeneratedValue
	@Column(name = "CART_ID")
	private Long cartId;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "CART_PRODUCT", joinColumns = { @JoinColumn(name = "CART_ID") }, inverseJoinColumns = { @JoinColumn(name = "PRODUCT_ID") })
	private List<Product> list;

	public Long getCartId() {
		return cartId;
	}

	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}

	public List<Product> getList() {
		return list;
	}

	public void setList(List<Product> list) {
		this.list = list;
	}

}

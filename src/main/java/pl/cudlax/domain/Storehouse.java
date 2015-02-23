package pl.cudlax.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "STOREHOUSE_PRODUCTS")
public class Storehouse {
	
	@Id
	@GeneratedValue
	@Column(name = "STOREHOUSE_PRODUCT_ID")
	private Long storehouseProductId;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PRODUCT_ID")
	private Product product;
	
	@Column(name = "AVAILABLE_AMOUNT")
	private Long availableAmount;
	
	@Column(name = "TARGET_AMOUNT")
	private Long targetAmount;

	public Long getStorehouseProductId() {
		return storehouseProductId;
	}

	public void setStorehouseProductId(Long storehouseProductId) {
		this.storehouseProductId = storehouseProductId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Long getAvailableAmount() {
		return availableAmount;
	}

	public void setAvailableAmount(Long availableAmount) {
		this.availableAmount = availableAmount;
	}

	public Long getTargetAmount() {
		return targetAmount;
	}

	public void setTargetAmount(Long targetAmount) {
		this.targetAmount = targetAmount;
	}
}

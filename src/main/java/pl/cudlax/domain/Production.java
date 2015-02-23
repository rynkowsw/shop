package pl.cudlax.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCTIONS")
public class Production {
	@Id
	@GeneratedValue
	@Column(name = "PRODUCTION_ID")
	private Long productionId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PRODUCT_ID")
	private Product product;

	@Column(name = "ISSUE_VALUE")
	private Integer issueValue;

	@Column(name = "DONE")
	private Boolean done;

	public Long getProductionId() {
		return productionId;
	}

	public void setProductionId(Long productionId) {
		this.productionId = productionId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getIssueValue() {
		return issueValue;
	}

	public void setIssueValue(Integer issueValue) {
		this.issueValue = issueValue;
	}

	public Boolean getDone() {
		return done;
	}

	public void setDone(Boolean done) {
		this.done = done;
	}
}

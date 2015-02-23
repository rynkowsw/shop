package pl.cudlax.domain;
/**
 * Tablica asocjacyjna - grupuje produkty w kategorie
 */
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CATEGORIES")
public class Category {

	@Id
	@GeneratedValue
	@Column(name = "CATEGORY_ID")
	private Long categoryId;

	@Column(name = "NAME", unique = true)
	private String name;

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

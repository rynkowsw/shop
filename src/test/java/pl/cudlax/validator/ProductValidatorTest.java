/**
 * 
 */
package pl.cudlax.validator;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

import pl.cudlax.domain.Product;
import pl.cudlax.service.ProductService;

/**
 * @author Zari
 *
 */
public class ProductValidatorTest {
	
	@Mock
	private ProductService service;
	
	@InjectMocks
	private ProductValidator testedClass;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		Mockito.when(service.isProductExists("exists")).thenReturn(true);
		Mockito.when(service.isProductExists("notexists")).thenReturn(false);
		Mockito.when(service.isProductExists(" ")).thenReturn(false);
		Mockito.when(service.isProductExists("")).thenReturn(false);
	}

	@Test
	public void testSupportsTrue() {
		Assert.assertEquals("Not supports but should", true, testedClass.supports(Product.class)); 
	}
	
	@Test
	public void testSupportsFalse() {
		Assert.assertEquals("Supports but should not", false, testedClass.supports(Object.class)); 
	}


	@Test
	public void testValidate() {
		Product product = new Product();
		product.setName("notexists");
		product.setDescription("opis");
		product.setAmount(1.0);
		Errors errors = new BeanPropertyBindingResult(product, "product");
		testedClass.validate(product, errors);
		Assert.assertEquals("Found error", 0, errors.getAllErrors().size()); 
	}
	
	@Test
	public void testValidateNotUniqueName() {
		Product product = new Product();
		product.setName("exists");
		product.setDescription("opis");
		product.setAmount(1.0);
		Errors errors = new BeanPropertyBindingResult(product, "product");
		testedClass.validate(product, errors);
		Assert.assertEquals("Not found errors", 1, errors.getAllErrors().size());
		Assert.assertEquals("Wrong field", "name", errors.getFieldErrors().get(0).getField());
		Assert.assertEquals("Wrong code", "unique", errors.getFieldErrors().get(0).getCode());
	}
	
	@Test
	public void testValidateWhitespaceName() {
		Product product = new Product();
		product.setName(" ");
		product.setDescription("opis");
		product.setAmount(1.0);
		Errors errors = new BeanPropertyBindingResult(product, "product");
		testedClass.validate(product, errors);
		Assert.assertEquals("Not found errors", 1, errors.getAllErrors().size());
		Assert.assertEquals("Wrong field", "name", errors.getFieldErrors().get(0).getField());
		Assert.assertEquals("Wrong code", "notnull", errors.getFieldErrors().get(0).getCode());
	}
	
	@Test
	public void testValidateEmptyName() {
		Product product = new Product();
		product.setName("");
		product.setDescription("opis");
		product.setAmount(1.0);
		Errors errors = new BeanPropertyBindingResult(product, "product");
		testedClass.validate(product, errors);
		Assert.assertEquals("Not found errors", 1, errors.getAllErrors().size());
		Assert.assertEquals("Wrong field", "name", errors.getFieldErrors().get(0).getField());
		Assert.assertEquals("Wrong code", "notnull", errors.getFieldErrors().get(0).getCode());
	}
	

	
	@Test
	public void testValidateWhitespaceDescription() {
		Product product = new Product();
		product.setName("notexists");
		product.setDescription(" ");
		product.setAmount(1.0);
		Errors errors = new BeanPropertyBindingResult(product, "product");
		testedClass.validate(product, errors);
		Assert.assertEquals("Not found errors", 1, errors.getAllErrors().size());
		Assert.assertEquals("Wrong field", "description", errors.getFieldErrors().get(0).getField());
		Assert.assertEquals("Wrong code", "notnull", errors.getFieldErrors().get(0).getCode());
	}
	
	@Test
	public void testValidateEmptyDescription() {
		Product product = new Product();
		product.setName("notexists");
		product.setDescription("");
		product.setAmount(1.0);
		Errors errors = new BeanPropertyBindingResult(product, "product");
		testedClass.validate(product, errors);
		Assert.assertEquals("Not found errors", 1, errors.getAllErrors().size());
		Assert.assertEquals("Wrong field", "description", errors.getFieldErrors().get(0).getField());
		Assert.assertEquals("Wrong code", "notnull", errors.getFieldErrors().get(0).getCode());
	}
	
	@Test
	public void testValidateEmptyAmount() {
		Product product = new Product();
		product.setName("notexists");
		product.setDescription("opis");
		product.setAmount(null);
		Errors errors = new BeanPropertyBindingResult(product, "product");
		testedClass.validate(product, errors);
		Assert.assertEquals("Not found errors", 1, errors.getAllErrors().size());
		Assert.assertEquals("Wrong field", "amount", errors.getFieldErrors().get(0).getField());
		Assert.assertEquals("Wrong code", "notnull", errors.getFieldErrors().get(0).getCode());
	}

}

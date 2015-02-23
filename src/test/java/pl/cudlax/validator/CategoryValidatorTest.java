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

import pl.cudlax.domain.Category;
import pl.cudlax.service.CategoryService;

/**
 * @author Zari
 *
 */
public class CategoryValidatorTest {
	
	@Mock
	private CategoryService service;
	
	@InjectMocks
	private CategoryValidator testedClass;

	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		Mockito.when(service.isCategoryExists("exists")).thenReturn(true);
		Mockito.when(service.isCategoryExists("notexists")).thenReturn(false);
		Mockito.when(service.isCategoryExists(" ")).thenReturn(false);
		Mockito.when(service.isCategoryExists("")).thenReturn(false);
	}

	@Test
	public void testSupportsTrue() {
		Assert.assertEquals("Not supports but should", true, testedClass.supports(Category.class)); 
	}
	
	@Test
	public void testSupportsFalse() {
		Assert.assertEquals("Supports but should not", false, testedClass.supports(Object.class)); 
	}

	@Test
	public void testValidateNotUniqueName() {
		Category cat = new Category();
		cat.setName("exists");
		Errors errors = new BeanPropertyBindingResult(cat, "category");
		testedClass.validate(cat, errors);
		Assert.assertEquals("Not found error", 1, errors.getAllErrors().size()); 
		Assert.assertEquals("Wrong field", "name", errors.getFieldErrors().get(0).getField());
		Assert.assertEquals("Wrong code", "unique", errors.getFieldErrors().get(0).getCode());
	}
	
	@Test
	public void testValidate() {
		Category cat = new Category();
		cat.setName("notexists");
		Errors errors = new BeanPropertyBindingResult(cat, "category");
		testedClass.validate(cat, errors);
		Assert.assertEquals("Found error", 0, errors.getAllErrors().size()); 
	}
	
	@Test
	public void testValidateWhitespaceName() {
		Category cat = new Category();
		cat.setName(" ");
		Errors errors = new BeanPropertyBindingResult(cat, "category");
		testedClass.validate(cat, errors);
		Assert.assertEquals("Not found error", 1, errors.getAllErrors().size()); 
		Assert.assertEquals("Wrong field", "name", errors.getFieldErrors().get(0).getField());
		Assert.assertEquals("Wrong code", "notnull", errors.getFieldErrors().get(0).getCode());
	}
	
	@Test
	public void testValidateEmptyName() {
		Category cat = new Category();
		cat.setName("");
		Errors errors = new BeanPropertyBindingResult(cat, "category");
		testedClass.validate(cat, errors);
		Assert.assertEquals("Not found error", 1, errors.getAllErrors().size()); 
		Assert.assertEquals("Wrong field", "name", errors.getFieldErrors().get(0).getField());
		Assert.assertEquals("Wrong code", "notnull", errors.getFieldErrors().get(0).getCode());
	}

}

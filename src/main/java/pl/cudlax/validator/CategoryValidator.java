package pl.cudlax.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import pl.cudlax.domain.Category;
import pl.cudlax.service.CategoryService;

@Component
public class CategoryValidator implements Validator{
	
	@Autowired
	private CategoryService service;

	@Override
	public boolean supports(Class<?> clazz) {
		return Category.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "notnull", "Nazwa nie mo¿e byæ pusta");
		Category category = (Category)target;
		if (service.isCategoryExists(category.getName()))
			errors.rejectValue("name", "unique", "Taki produkt ju¿ istnieje w bazie");
		
	}
	
	
	
}

package pl.cudlax.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import pl.cudlax.domain.Product;
import pl.cudlax.service.ProductService;

@Component
public class ProductValidator implements Validator {
	
	@Autowired
	private ProductService productService;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Product.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "notnull", "Opis nie mo¿e byæ pusty");
		ValidationUtils.rejectIfEmpty(errors, "amount", "notnull", "Kwota nie mo¿e byæ pusta");
		if (productService.isProductExists(((Product)target).getName())) {
			errors.rejectValue("name", "unique", "Taki produkt ju¿ istnieje w bazie");
		}
	}

}

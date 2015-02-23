package pl.cudlax.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.cudlax.domain.Category;
import pl.cudlax.domain.Product;
import pl.cudlax.domain.User;
import pl.cudlax.service.CategoryService;
import pl.cudlax.service.ProductService;
import pl.cudlax.service.UserService;
import pl.cudlax.validator.ProductValidator;

@Controller
public class ProductController {

	@Autowired
	ProductService productService;
	@Autowired
	CategoryService categoryService;
	@Autowired
	UserService userService;
	@Autowired
	@Qualifier("productValidator")
	private ProductValidator validator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}

	@RequestMapping(value = { "/newProduct.html", "newProduct" }, method = RequestMethod.GET)
	public String setForm(Model model, @PathVariable String success) {
		List<Category> list = categoryService.getAllCategories();
		model.addAttribute("categoryList", list != null ? list
				: new ArrayList<Category>());

		if (SecurityContextHolder.getContext().getAuthentication() != null
				&& SecurityContextHolder.getContext().getAuthentication()
						.isAuthenticated()) {
			Object principal = SecurityContextHolder.getContext()
					.getAuthentication().getPrincipal();
			if (principal instanceof UserDetails) {
				model.addAttribute("loginStatus", "logged");
			} else {
				model.addAttribute("loginStatus", "unlogged");
				return "redirect:/login";
			}

		}
		model.addAttribute("categoryListNames",
				getCategoryNames(list != null ? list
						: new ArrayList<Category>()));
		model.addAttribute("newProduct", new Product());
		model.addAttribute("userRole", getUserRole());
		return "newProduct";
	}

	@RequestMapping(value = { "/newProduct.html", "newProduct" }, method = RequestMethod.POST)
	public String createUser(
			@ModelAttribute("newProduct") @Validated Product newProduct,
			BindingResult result, ModelMap model) {

		if (SecurityContextHolder.getContext().getAuthentication() != null
				&& SecurityContextHolder.getContext().getAuthentication()
						.isAuthenticated()) {
			Object principal = SecurityContextHolder.getContext()
					.getAuthentication().getPrincipal();
			if (principal instanceof UserDetails) {
				model.addAttribute("loginStatus", "logged");
			} else {
				model.addAttribute("loginStatus", "unlogged");
				return "redirect:/login";
			}
		}

		model.addAttribute("userRole", getUserRole());

		if (result.hasErrors()) {
			List<Category> list = categoryService.getAllCategories();
			model.addAttribute("categoryList", list != null ? list
					: new ArrayList<Category>());
			model.addAttribute("newProduct", newProduct);
			return "newProduct";
		}
		productService.createProduct(newProduct);
		model.addAttribute("succes", true);
		return "redirect:/newProduct";

		// newProduct.setCategories(categoriesStringToCategory(newProduct.getListCategoriesString()));
		// Product p = castProductModel(newProduct);

	}

	public List<String> getCategoryNames(List<Category> list) {
		List<String> listCategories = new ArrayList<String>();
		for (Category category : list) {
			listCategories.add(category.getName());
		}
		return listCategories;
	}

	//
	// public Product castProductModel (NewProductModel newP)
	// {
	// Product p = new Product();
	// p.setAmount(newP.getAmount());
	// p.setCategories(newP.getCategories());
	// p.setCatalogNum(newP.getCatalogNum());
	// p.setName(newP.getName());
	// p.setDescription(newP.getDescription());
	// return p;
	//
	//
	// }
	public String getUserRole() {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String emailUser = auth.getName(); // get logged in username
		User user = userService.getUserByMail(emailUser);
		String userRole;
		if (user != null)
			userRole = user.getRole();
		else
			userRole = "guest";
		System.out.println(userRole);
		return userRole;

	}

	public List<Category> categoriesStringToCategory(List<String> categoryNames) {
		List<Category> categories = categoryService.getAllCategories();
		String name = "";
		Iterator<Category> it = categories.iterator();
		while (it.hasNext()) {
			Category category = it.next();
			for (String nameCategory : categoryNames) {
				if (category.getName().equals(nameCategory)) {
					name = nameCategory;
					break;
				}
			}

			if (category.getName().equals(name))
				break;
			else
				it.remove();
		}
		return categories;
	}
}

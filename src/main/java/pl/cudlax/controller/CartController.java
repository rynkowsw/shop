package pl.cudlax.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.cudlax.domain.Category;
import pl.cudlax.domain.Product;
import pl.cudlax.domain.User;
import pl.cudlax.service.CategoryService;
import pl.cudlax.service.ProductService;
import pl.cudlax.service.UserService;

@Controller
public class CartController {
	@Autowired
	ProductService productService;
	@Autowired
	CategoryService categoryService;
	@Autowired
	UserService userService;

	@RequestMapping(value = { "cart" }, method = RequestMethod.GET)
	public String getCart(Model model) {
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
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String emailUser = auth.getName(); // get logged in username
		User user = userService.getUserByMail(emailUser);
		Double sum = 0.0;
		for (Product p : user.getCart()) {
			sum += p.getAmount();
		}
		model.addAttribute("cartList", user.getCart());
		model.addAttribute("sum", sum);
		return "cart";
	}

	@RequestMapping(value = { "addtocart/{productId}" }, method = RequestMethod.GET)
	public String addToCart(Model model, @PathVariable Long productId) {
		System.out.println(productId);

		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String emailUser = auth.getName(); // get logged in username
		User user = userService.getUserByMail(emailUser);

		user.getCart().add(productService.getProduct(productId));
		userService.updateUser(user);

		return "redirect:/cart";
	}
}

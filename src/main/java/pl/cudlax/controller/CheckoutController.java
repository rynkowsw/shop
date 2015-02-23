package pl.cudlax.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.cudlax.dao.OrderDAO;
import pl.cudlax.domain.Category;
import pl.cudlax.domain.Order;
import pl.cudlax.domain.Product;
import pl.cudlax.domain.User;
import pl.cudlax.service.CategoryService;
import pl.cudlax.service.ProductService;
import pl.cudlax.service.UserService;

@Controller
public class CheckoutController {
	@Autowired
	ProductService productService;
	@Autowired
	CategoryService categoryService;
	@Autowired
	UserService userService;
	@Autowired
	OrderDAO orderDAO;

	@RequestMapping(value = { "checkout" }, method = RequestMethod.GET)
	public String getCheckout(Model model) {
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
		model.addAttribute("checkout", new Order());
		return "checkout";
	}

	@RequestMapping(value = { "/checkout.html", "checkout" }, method = RequestMethod.POST)
	public String submitCheckout(@ModelAttribute("checkout") Order checkout,
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

		if (result.hasErrors()) {
			List<Category> list = categoryService.getAllCategories();
			model.addAttribute("categoryList", list != null ? list
					: new ArrayList<Category>());
			model.addAttribute("checkout", checkout);
			return "checkout";
		}
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String emailUser = auth.getName(); // get logged in username
		User user = userService.getUserByMail(emailUser);
		checkout.setCart(user.getCart());
		orderDAO.createOrder(checkout);
		user.setCart(new ArrayList<Product>());
		userService.updateUser(user);

		return "redirect:/checkoutSucces";

	}
	
	@RequestMapping(value = { "checkoutSucces" }, method = RequestMethod.GET)
	public String getCheckoutSucces(Model model) {
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
		
		return "checkoutSucces";
	}
}

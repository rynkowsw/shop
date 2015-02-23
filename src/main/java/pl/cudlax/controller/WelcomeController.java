package pl.cudlax.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pl.cudlax.domain.Category;
import pl.cudlax.service.CategoryService;
import pl.cudlax.service.ProductService;

@Controller
public class WelcomeController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired	
	CategoryService categoryService;
	
	@RequestMapping(value = { "/", "/welcome**" }, method = RequestMethod.GET)
	public ModelAndView defaultPage() {
		
		ModelAndView model = new ModelAndView();
		List<Category> list= categoryService.getAllCategories();
		model.addObject("categoryList", list != null ? list : new ArrayList<Category>());
		
		if (SecurityContextHolder.getContext().getAuthentication() != null
				&& SecurityContextHolder.getContext().getAuthentication()
						.isAuthenticated()) {
			Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			if (principal instanceof UserDetails) {
				model.addObject("loginStatus", "logged");
				model.setViewName("redirect:/dashboard");
			} else {
				model.addObject("loginStatus", "unlogged");
				model.setViewName("login");
			}
		}

		return model;

	}
	
	@RequestMapping(value = { "/dashboard", "/index.html"}, method = RequestMethod.GET)
	public String dashboard(Model model) {
			
		if (SecurityContextHolder.getContext().getAuthentication() != null
					&& SecurityContextHolder.getContext().getAuthentication()
							.isAuthenticated()) {
				Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
				if (principal instanceof UserDetails) {
					model.addAttribute("loginStatus", "logged");
				} else {
					model.addAttribute("loginStatus", "unlogged");
					return "redirect:/login";
				}
			}

		model.addAttribute("productList", productService.getProducts());
		List<Category> list= categoryService.getAllCategories();
		model.addAttribute("categoryList", list != null ? list : new ArrayList<Category>());
		
		return "list";

	}
}

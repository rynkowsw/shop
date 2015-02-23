package pl.cudlax.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pl.cudlax.domain.Category;
import pl.cudlax.service.CategoryService;

@Controller
public class LoginController {

	@Autowired
	CategoryService categoryService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(
			@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {

		ModelAndView model = new ModelAndView();
		List<Category> list = categoryService.getAllCategories();
		model.addObject("categoryList", list != null ? list : new ArrayList<Category>());
		
		if (logout != null) {
			model.addObject("msg", "Zosta³eœ poprawnie wylogowany");
		}
		
		if (SecurityContextHolder.getContext().getAuthentication() != null
				&& SecurityContextHolder.getContext().getAuthentication()
						.isAuthenticated()) {
			Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			if (principal instanceof UserDetails) {
				model.addObject("loginStatus", "logged");
				model.setViewName("redirect:/dashboard");
				return model;
			} else {
				model.addObject("loginStatus", "unlogged");
			}
		}

		model.addObject("Title", "Logowanie");
		if (error != null) {
			model.addObject("error", "B³êdny Email lub Has³o");
		}
		model.setViewName("login");

		return model;

	}
}

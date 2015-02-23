package pl.cudlax.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.cudlax.domain.Category;
import pl.cudlax.domain.User;
import pl.cudlax.service.CategoryService;
import pl.cudlax.service.UserService;


@Controller
public class RegisterController {
	
	@Autowired	
	UserService userService;
	
	@Autowired	
	CategoryService categoryService;
	
	@RequestMapping(value={"/register.html", "register"}, method=RequestMethod.GET)
	public String setForm( Model model) {
		List<Category> list= categoryService.getAllCategories();
		model.addAttribute("categoryList", list != null ? list : new ArrayList<Category>());
		if (SecurityContextHolder.getContext().getAuthentication() != null
				&& SecurityContextHolder.getContext().getAuthentication()
						.isAuthenticated()) {
			Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			if (principal instanceof UserDetails) {
				model.addAttribute("loginStatus", "logged");
				return "redirect:/dashboard";
			} else {
				model.addAttribute("loginStatus", "unlogged");
			}
		}
		model.addAttribute("newUser", new User());
		return "register";
	}
	
	@RequestMapping(value={"/register.html", "register"}, method=RequestMethod.POST)
	public String createPlan(@Valid @ModelAttribute("newUser") User newUser,  BindingResult result, ModelMap model) {
		
		List<Category> list= categoryService.getAllCategories();
		model.addAttribute("categoryList", list != null ? list : new ArrayList<Category>());
		if (SecurityContextHolder.getContext().getAuthentication() != null
				&& SecurityContextHolder.getContext().getAuthentication()
						.isAuthenticated()) {
			Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			if (principal instanceof UserDetails) {
				model.addAttribute("loginStatus", "logged");
			} else {
				model.addAttribute("loginStatus", "unlogged");
			}
		}

		if(result.hasErrors()) {
            return "register";
        }
		userService.createUser(newUser);
		model.addObject("msg", "Zosta³eœ zarejestrowany. Mo¿esz siê zalogowaæ");
		
		return "login";
	}

}

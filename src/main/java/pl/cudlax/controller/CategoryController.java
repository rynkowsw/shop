package pl.cudlax.controller;

import java.util.ArrayList;
import java.util.List;

import javassist.expr.NewArray;

import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.cudlax.domain.Category;
import pl.cudlax.domain.User;
import pl.cudlax.service.CategoryService;
import pl.cudlax.service.UserService;
import pl.cudlax.validator.CategoryValidator;

@Controller
public class CategoryController {

	
	@Autowired	
	CategoryService categoryService;
	@Autowired
	UserService userService;
	@Autowired
	@Qualifier("categoryValidator")
	private CategoryValidator validator;
	
	@InitBinder
	private void InitBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}
	
	@RequestMapping(value={"/categoryList.html", "/categoryList"}, method=RequestMethod.GET)
	public String setForm( Model model) {
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
				return "redirect:/login";
			}
		}
	    model.addAttribute("userRole", getUserRole());
		model.addAttribute("newCategory", new Category());
		return "categoryList";
	}
	@RequestMapping(value={"/addCategory.html", "/addCategory" , "/categoryList"}, method=RequestMethod.POST)
	public String createCategory(@Validated @ModelAttribute("newCategory") Category newCategory,  BindingResult result, ModelMap model) {
		if (SecurityContextHolder.getContext().getAuthentication() != null
				&& SecurityContextHolder.getContext().getAuthentication()
						.isAuthenticated()) {
			Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			if (principal instanceof UserDetails) {
				model.addAttribute("loginStatus", "logged");
			} else {
				List<Category> list= categoryService.getAllCategories();
			    model.addAttribute("categoryList", list != null ? list : new ArrayList<Category>());
				model.addAttribute("loginStatus", "unlogged");
				return "redirect:/login";
			}
		}
		
		
		
		List<Category> list= categoryService.getAllCategories();
		model.addAttribute("categoryList", list != null ? list : new ArrayList<Category>());
	    model.addAttribute("userRole", getUserRole());

	    if (result.hasErrors()) {
	    	model.addAttribute("newCategory", newCategory);
		} else 
			categoryService.createCategory(newCategory);
			model.addAttribute("newCategory", new Category());

	    return "/categoryList";
	}
	public String getUserRole()
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String emailUser = auth.getName(); //get logged in username
	    User user =userService.getUserByMail(emailUser);
	    String userRole;
	    if(user!=null)
	    	userRole=user.getRole();
	    else userRole="guest";
	    System.out.println(userRole);
	    return userRole;
		
		
	}
	
}

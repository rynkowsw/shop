package pl.cudlax.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.cudlax.dao.CategoryDAO;
import pl.cudlax.domain.Category;
import pl.cudlax.service.CategoryService;

@Service
public class CategocyServiceImpl implements CategoryService{
	@Autowired
	CategoryDAO dao;

	@Override
	public void createCategory(Category c) {
		dao.createCategory(c);
	}

	@Override
	public void removeCategory(Category c) {
		dao.removeCategory(c);
	}

	@Override
	public List<Category> getAllCategories() {
		return dao.getAllCategories();
	}

	@Override
	public boolean isCategoryExists(String name) {
		return dao.getCategory(name) != null;
	}
}

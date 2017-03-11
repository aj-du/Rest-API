package ajdu_restful_api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ajdu_restful_api.dao.CategoryRepository;
import ajdu_restful_api.model.Category;

@Service
@Transactional
public class CategoryService {

	private final CategoryRepository categoryRepository;
	
	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
	
	public List<Category> findAllCategories(){
		List<Category> categories = new ArrayList<Category>();
		for(Category c : categoryRepository.findAll()) {
			categories.add(c);
		}
		return categories;
	}
	
	public Category findOneCategory(int id) {
		return categoryRepository.findOne(id);
	}
	
	public Category findCategoryByName(String name) {
		return categoryRepository.findCategoryByName(name);
	}
	
	public void saveCategory(Category cat) {
		categoryRepository.save(cat);
	}
	
	public void deleteCategory(int id) {
		categoryRepository.delete(id);
	}	
	
}
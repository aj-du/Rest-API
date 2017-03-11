package ajdu_restful_api.dao;

import org.springframework.data.repository.CrudRepository;

import ajdu_restful_api.model.Category;

public interface CategoryRepository extends CrudRepository<Category, Integer>{
	public Category findCategoryByName(String name);
}

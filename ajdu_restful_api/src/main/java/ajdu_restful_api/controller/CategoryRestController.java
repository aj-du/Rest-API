package ajdu_restful_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ajdu_restful_api.model.Category;
import ajdu_restful_api.service.CategoryService;

@RestController
public class CategoryRestController {

	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/categories")
	public ResponseEntity<List<Category>> allCategories(){
		return new ResponseEntity<List<Category>>(categoryService.findAllCategories(),HttpStatus.OK);
	}
	
	@GetMapping("/category")
	public ResponseEntity<Category> getCategory(@RequestParam int id) {
		return new ResponseEntity<Category>(categoryService.findOneCategory(id),HttpStatus.OK);
	}
	
	@RequestMapping(value="/addcategory", method=RequestMethod.POST)
	public ResponseEntity<Category> addCategory(@RequestBody Category cat) {
		if(categoryService.findCategoryByName(cat.getName()) == null) {
			categoryService.saveCategory(cat);
			return new ResponseEntity<Category>(cat, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<Category>(cat,HttpStatus.CONFLICT);
		}
	}
	
	@GetMapping("/deletecategory")
	public ResponseEntity<Category> deleteCategory(@RequestParam int id) {
		categoryService.deleteCategory(id);
		return new ResponseEntity<Category>(HttpStatus.OK);
	}
	
	
	

}

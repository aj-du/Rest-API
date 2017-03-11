package ajdu_restful_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ajdu_restful_api.model.Category;
import ajdu_restful_api.service.CategoryService;

@RestController
public class CategoryRestController {

	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(value="/categories", method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Category>> allCategories(){
		return new ResponseEntity<List<Category>>(categoryService.findAllCategories(),HttpStatus.OK);
	}
	
	@RequestMapping(value="/categories", method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Category> addCategory(@RequestBody Category cat) {
		if(categoryService.findCategoryByName(cat.getName()) == null) {
			categoryService.saveCategory(cat);
			return new ResponseEntity<Category>(cat, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<Category>(cat,HttpStatus.CONFLICT);
		}
	}
	
	@RequestMapping(value="/categories/{id}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Category> getCategory(@PathVariable int id) {
		if(categoryService.findOneCategory(id) != null)
			return new ResponseEntity<Category>(categoryService.findOneCategory(id),HttpStatus.OK);
		else return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);			
	}
	
	
	@RequestMapping(value="/categories/{id}",method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Category> deleteCategory(@PathVariable int id) {
		Category c = categoryService.findOneCategory(id); 
		if(c != null) {
			categoryService.deleteCategory(id);
			return new ResponseEntity<Category>(HttpStatus.OK);
		}
		return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value="/categories/{id}",method=RequestMethod.PUT,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Category> updateCategory(@PathVariable int id, @RequestBody Category category) {
		Category c = categoryService.findOneCategory(id); 
		if(c != null) {
			c.setName(category.getName());
			return new ResponseEntity<Category>(c,HttpStatus.OK);
		}
		return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
	}
	
}
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

import ajdu_restful_api.model.Blog;
import ajdu_restful_api.model.User;
import ajdu_restful_api.service.BlogService;
import ajdu_restful_api.service.ServiceService;
import ajdu_restful_api.service.UserService;

@RestController
public class BlogRestController {

	@Autowired
	BlogService blogService;
	@Autowired
	UserService userService;
	@Autowired
	ServiceService serviceService;
	
	
	@RequestMapping(value="/blogs",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Blog>> getAllBlogs() {
		return new ResponseEntity<List<Blog>>(blogService.findBlogs(),HttpStatus.OK);
	}
	
	@RequestMapping(value="/blogs",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Blog> createBlog(@RequestBody Blog blog) {
		if(blog.getUser() == null || 
				blog.getUser().getId() == null ||
				blog.getTitle() == null) {
			return new ResponseEntity<Blog>(HttpStatus.BAD_REQUEST);
		}
		else {
			User u = userService.findUser(blog.getUser().getId());
			if(u.getPack() != null)
				return new ResponseEntity<Blog>(HttpStatus.CONFLICT);
			else {			
				blogService.save(blog);
				return new ResponseEntity<Blog>(blog, HttpStatus.CREATED);
			}
		}		
	}
	
	
	@RequestMapping(value="/blogs/{id}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Blog> getBlog(@PathVariable int id) {
		Blog p = blogService.findBlog(id);
		if(p != null)
			return new ResponseEntity<Blog>(p,HttpStatus.OK);
		else return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value="/blogs/{id}",method=RequestMethod.PUT,consumes=MediaType.APPLICATION_JSON_UTF8_VALUE )
	public ResponseEntity<Blog> updateBlog(@PathVariable int id, @RequestBody Blog blog) {
		Blog p = blogService.findBlog(id);
		if(p != null) {
			p.setTitle(blog.getTitle());
			p.setDescription(blog.getDescription());
			p.setMedia(blog.getMedia());
			p.setPosts(blog.getPosts());
			blogService.save(p);
			return new ResponseEntity<Blog>(p, HttpStatus.OK);
		}
		return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
	}
	
	
	@RequestMapping(value="/blogs/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<Blog> deleteBlog(@PathVariable int id) {
		Blog p = blogService.findBlog(id);
		if(p != null) {
			blogService.delete(id);
			return new ResponseEntity<Blog>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
	}
	
	
}

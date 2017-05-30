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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ajdu_restful_api.model.Blog;
import ajdu_restful_api.model.Post;
import ajdu_restful_api.service.BlogService;
import ajdu_restful_api.service.PostService;

@RestController
public class PostRestController {
	
	@Autowired
	PostService postService;
	@Autowired
	BlogService blogService;
		
	@RequestMapping(value="/posts",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Post>> getAllPost() {
			return new ResponseEntity<List<Post>>(postService.findAll(),HttpStatus.OK);
	}
	
	@RequestMapping(value="/posts",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Post> createPost(@RequestBody Post post) {
		if(post.getBlog() != null &&
				post.getBlog().getId() != null &&
				post.getTitle() != null) {
			Blog blog = blogService.findBlog(post.getBlog().getId());
			if(blog != null) {
				blog.getPosts().add(post);
				postService.savePost(post);
				blogService.save(blog);
				return new ResponseEntity<Post>(post, HttpStatus.CREATED);				
			}
			else return new ResponseEntity<Post>(post, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Post>(post, HttpStatus.BAD_REQUEST);
	}
	
	
	@RequestMapping(value="/posts/{id}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Post> getPost(@PathVariable int id) {
		Post post = postService.findPost(id);
		if(post != null)
			return new ResponseEntity<Post>(post,HttpStatus.OK);
		else return new ResponseEntity<Post>(HttpStatus.NOT_FOUND);
	}
	
	
	@RequestMapping(value="/posts/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<Post> deletePost(@PathVariable int id) {
		if(postService.findPost(id) != null) {
			postService.deletePost(id);
			return new ResponseEntity<Post>(HttpStatus.NO_CONTENT);
		}
		else return new ResponseEntity<Post>(HttpStatus.NOT_FOUND);
	}
	
	
	@RequestMapping(value="/posts/{id}",method=RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Post> updatePost(@PathVariable int id, @RequestBody Post post) {
		Post p = postService.findPost(id);
		if(p != null) {
			p.setTitle(post.getTitle());
			p.setContent(post.getContent());
			p.setImage(post.getImage());
			p.setComments(post.getComments());
			postService.savePost(p);
			return new ResponseEntity<Post>(p, HttpStatus.OK);
		}
		else return new ResponseEntity<Post>(HttpStatus.NOT_FOUND);
	}
	
	
	@RequestMapping(value="/posts/by/blog",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Post>> getTaskByUser(@RequestParam int blogid) {
		Blog blog = blogService.findBlog(blogid);
		if(blog != null) 
			return new ResponseEntity<List<Post>>(blog.getPosts(), HttpStatus.OK);
		else
			return new ResponseEntity<List<Post>>(HttpStatus.NOT_FOUND);
	}
	

	
	
}

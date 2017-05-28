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

import ajdu_restful_api.model.Comment;
import ajdu_restful_api.model.Post;
import ajdu_restful_api.service.CommentService;
import ajdu_restful_api.service.PostService;

@RestController
public class CommentController {
	
	@Autowired
	CommentService commentService;
	@Autowired
	PostService postService;
		
	@RequestMapping(value="/comments",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Comment>> getAllComment() {
			return new ResponseEntity<List<Comment>>(commentService.findAll(),HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/comments/{id}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Comment> getComment(@PathVariable int id) {
		if(commentService.findComment(id) != null)
			return new ResponseEntity<Comment>(commentService.findComment(id),HttpStatus.OK);
		else return new ResponseEntity<Comment>(HttpStatus.NOT_FOUND);
	}
	
	
	@RequestMapping(value="/comments/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<Comment> deleteComment(@PathVariable int id) {
		if(commentService.findComment(id) != null) {
			commentService.deleteComment(id);
			return new ResponseEntity<Comment>(HttpStatus.NO_CONTENT);
		}
		else return new ResponseEntity<Comment>(HttpStatus.NOT_FOUND);
	}
	
	
	@RequestMapping(value="/comments/{id}",method=RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Comment> updateComment(@PathVariable int id, @RequestBody Comment comment) {
		Comment c = commentService.findComment(id);
		if(c != null) {
			c.setContent(comment.getContent());
			commentService.saveComment(c);
			return new ResponseEntity<Comment>(c, HttpStatus.OK);
		}
		else return new ResponseEntity<Comment>(HttpStatus.NOT_FOUND);
	}
	
	
	@RequestMapping(value="/comments/by/post",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Comment>> getTaskByUser(@RequestParam int postid) {
		Post post = postService.findPost(postid);
		if(post != null) 
			return new ResponseEntity<List<Comment>>(post.getComments(), HttpStatus.OK);
		else
			return new ResponseEntity<List<Comment>>(HttpStatus.NOT_FOUND);
	}
	

	
	
}

package ajdu_restful_api.controller;

import java.util.ArrayList;
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
import ajdu_restful_api.model.Media;
import ajdu_restful_api.model.Post;
import ajdu_restful_api.model.Service;
import ajdu_restful_api.model.User;
import ajdu_restful_api.service.BlogService;
import ajdu_restful_api.service.MediaService;
import ajdu_restful_api.service.PostService;
import ajdu_restful_api.service.ServiceService;
import ajdu_restful_api.service.UserService;

@RestController
public class MediaRestController {
	
	@Autowired
	MediaService mediaService;
	@Autowired
	ServiceService serviceService;
	@Autowired
	UserService userService;
	@Autowired
	BlogService blogService;
	@Autowired
	PostService postService;
		
	@RequestMapping(value="/media",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Media>> getAllMedia() {
			return new ResponseEntity<List<Media>>(mediaService.findAll(),HttpStatus.OK);
	}
	
	@RequestMapping(value="/media",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Media> createMedia(@RequestBody Media media) {
		if(
				(media.getService() != null && 
				media.getService().getId() != null) ^
				(media.getUser() != null &&
				media.getUser().getId() != null &&
				media.getMediaType() == ajdu_restful_api.model.MediaType.IMAGE) ^
				(media.getBlog() != null && 
				media.getBlog().getId() != null &&
				media.getMediaType() == ajdu_restful_api.model.MediaType.IMAGE) ^
				(media.getPost() != null && 
				media.getPost().getId() != null) &&
				media.getMediaType() == ajdu_restful_api.model.MediaType.IMAGE) {
			
			if(media.getService() != null) {
				Service service = serviceService.findService(media.getService().getId());
				if(service != null) {
					if(service.getMedia() == null)
						service.setMedia(new ArrayList<Media>());
					service.getMedia().add(media);
					mediaService.saveMedia(media);
					serviceService.saveService(service);
					return new ResponseEntity<Media>(media, HttpStatus.CREATED);					
				} else return new ResponseEntity<Media>(media, HttpStatus.NOT_FOUND);	
			}
			else if(media.getUser() != null) {
				User user = userService.findUser(media.getUser().getId());
				if(user != null) {
					if(user.getProfileImage() == null) {
						user.setProfileImage(media);
						mediaService.saveMedia(media);
						userService.save(user);
						return new ResponseEntity<Media>(media, HttpStatus.CREATED);
					} else return new ResponseEntity<Media>(media, HttpStatus.CONFLICT);
				} else return new ResponseEntity<Media>(media, HttpStatus.NOT_FOUND);	
			}
			else if(media.getBlog() != null) {
				Blog blog = blogService.findBlog(media.getBlog().getId());
				if(blog != null) {
					if(blog.getMedia() == null) {
						blog.setMedia(media);
						mediaService.saveMedia(media);
						blogService.save(blog);
						return new ResponseEntity<Media>(media, HttpStatus.CREATED);
					} else return new ResponseEntity<Media>(media, HttpStatus.CONFLICT);
				} else return new ResponseEntity<Media>(media, HttpStatus.NOT_FOUND);
			}
			else if(media.getBlog() != null) {
				Post post = postService.findPost(media.getPost().getId());
				if(post != null) {
					if(post.getMedia() == null) {
						post.setMedia(media);
						mediaService.saveMedia(media);
						postService.savePost(post);
						return new ResponseEntity<Media>(media, HttpStatus.CREATED);
					} else return new ResponseEntity<Media>(media, HttpStatus.CONFLICT);
				} else return new ResponseEntity<Media>(media, HttpStatus.NOT_FOUND);
			}
		}
		return new ResponseEntity<Media>(media, HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(value="/media/{id}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Media> getMedia(@PathVariable int id) {
		if(mediaService.findMedia(id) != null)
			return new ResponseEntity<Media>(mediaService.findMedia(id),HttpStatus.OK);
		else return new ResponseEntity<Media>(HttpStatus.NOT_FOUND);
	}
	
	
	@RequestMapping(value="/media/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<Media> deleteMedia(@PathVariable int id) {
		if(mediaService.findMedia(id) != null) {
			mediaService.deleteMedia(id);
			return new ResponseEntity<Media>(HttpStatus.NO_CONTENT);
		}
		else return new ResponseEntity<Media>(HttpStatus.NOT_FOUND);
	}
	
	
	@RequestMapping(value="/media/{id}",method=RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Media> updateMedia(@PathVariable int id, @RequestBody Media media) {
		Media m = mediaService.findMedia(id);
		if(m != null) {
			if(m.getMediaType() == media.getMediaType()) {
				m.setTitle(media.getTitle());
				m.setFileURL(media.getFileURL());
				mediaService.saveMedia(m);
				return new ResponseEntity<Media>(m, HttpStatus.OK);
			} else return new ResponseEntity<Media>(HttpStatus.BAD_REQUEST);
		}
		else return new ResponseEntity<Media>(HttpStatus.NOT_FOUND);
	}
	
}

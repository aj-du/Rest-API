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

import ajdu_restful_api.model.Opinion;
import ajdu_restful_api.model.Service;
import ajdu_restful_api.model.User;
import ajdu_restful_api.service.OpinionService;
import ajdu_restful_api.service.ServiceService;
import ajdu_restful_api.service.UserService;

@RestController
public class OpinionRestController {
	
	@Autowired
	OpinionService opinionService;
	@Autowired
	ServiceService serviceService;
	@Autowired
	UserService userService;
		
	@RequestMapping(value="/opinions",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Opinion>> getAllOpinion() {
			return new ResponseEntity<List<Opinion>>(opinionService.findAll(),HttpStatus.OK);
	}
	
	@RequestMapping(value="/opinions",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Opinion> createOpinion(@RequestBody Opinion opinion) {
		if(opinion.getService() != null && 
				opinion.getService().getId() != null &&
				opinion.getUser() != null &&
				opinion.getUser().getId() != null) {
			
			Service service = serviceService.findService(opinion.getService().getId());
			User user = userService.findUser(opinion.getUser().getId());
			
			if(user != null && service != null) {
				user.getOpinions().add(opinion);
				service.getOpinions().add(opinion);
				opinionService.saveOpinion(opinion);
				serviceService.saveService(service);
				userService.save(user);
				return new ResponseEntity<Opinion>(opinion, HttpStatus.CREATED);
			} 
			else
				return new ResponseEntity<Opinion>(opinion, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Opinion>(opinion, HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(value="/opinions/{id}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Opinion> getOpinion(@PathVariable int id) {
		if(opinionService.findOpinion(id) != null)
			return new ResponseEntity<Opinion>(opinionService.findOpinion(id),HttpStatus.OK);
		else return new ResponseEntity<Opinion>(HttpStatus.NOT_FOUND);
	}
	
	
	@RequestMapping(value="/opinions/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<Opinion> deleteOpinion(@PathVariable int id) {
		if(opinionService.findOpinion(id) != null) {
			opinionService.deleteOpinion(id);
			return new ResponseEntity<Opinion>(HttpStatus.NO_CONTENT);
		}
		else return new ResponseEntity<Opinion>(HttpStatus.NOT_FOUND);
	}
	
	
	@RequestMapping(value="/opinions/{id}",method=RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Opinion> updateOpinion(@PathVariable int id, @RequestBody Opinion opinion) {
		Opinion o = opinionService.findOpinion(id);
		if(o != null) {
			o.setRate(opinion.getRate());
			o.setContent(opinion.getContent());
			opinionService.saveOpinion(o);
			return new ResponseEntity<Opinion>(o, HttpStatus.OK);
		}
		else return new ResponseEntity<Opinion>(HttpStatus.NOT_FOUND);
	}
	
	
	@RequestMapping(value="/opinions/by/service",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Opinion>> getOpinionByService(@RequestParam int serviceid) {
		Service service = serviceService.findService(serviceid);
		if(service != null) 
			return new ResponseEntity<List<Opinion>>(service.getOpinions(), HttpStatus.OK);
		else
			return new ResponseEntity<List<Opinion>>(HttpStatus.NOT_FOUND);
	}
	

	
	
}

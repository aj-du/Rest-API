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

import ajdu_restful_api.model.Service;
import ajdu_restful_api.service.ServiceService;

@RestController
public class ServiceRestController {
	
	@Autowired
	ServiceService serviceService;
	
		
	@RequestMapping(value="/services",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Service>> getAllServices() {
			return new ResponseEntity<List<Service>>(serviceService.findAll(),HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/services",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Service> addService(@RequestBody Service service) {
			if(service.getName() == null) {
				return new ResponseEntity<Service>(HttpStatus.BAD_REQUEST);
			}
			else if(service.getName() != null) {
				return new ResponseEntity<Service>(HttpStatus.CONFLICT);
			}
			else {
				serviceService.saveService(service);
				return new ResponseEntity<Service>(service,HttpStatus.CREATED);
			}
	}
	
	
	@RequestMapping(value="/services/{id}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Service> getService(@PathVariable int id) {
		if(serviceService.findService(id) != null)
			return new ResponseEntity<Service>(serviceService.findService(id),HttpStatus.OK);
		else return new ResponseEntity<Service>(HttpStatus.NOT_FOUND);
	}
	
	
	@RequestMapping(value="/services/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<Service> deleteService(@PathVariable int id) {
		if(serviceService.findService(id) != null) {
			serviceService.deleteService(id);
			return new ResponseEntity<Service>(HttpStatus.OK);
		}
		else return new ResponseEntity<Service>(HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping(value="/services/{id}",method=RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Service> updateService(@PathVariable int id, @RequestBody Service service) {
		Service s = serviceService.findService(id);
		if(s != null) {
			s.setName(service.getName());
			s.setDescription(service.getDescription());
			s.setCategory(service.getCategory());
			s.setCost(service.getCost());
			s.setDistinct(service.isDistinct());
			s.setOpinions(service.getOpinions());
			serviceService.saveService(s);
			return new ResponseEntity<Service>(s, HttpStatus.OK);
		}
		else return new ResponseEntity<Service>(HttpStatus.NOT_FOUND);
	}
	
}

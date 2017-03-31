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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ajdu_restful_api.model.Category;
import ajdu_restful_api.model.Organization;
import ajdu_restful_api.model.Service;
import ajdu_restful_api.service.CategoryService;
import ajdu_restful_api.service.OrganizationService;
import ajdu_restful_api.service.ServiceService;

@RestController
public class ServiceRestController {
	
	@Autowired
	ServiceService serviceService;
	@Autowired
	OrganizationService orgService;
	@Autowired
	CategoryService categoryService;
	
		
	@RequestMapping(value="/services",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Service>> getAllServices() {
			return new ResponseEntity<List<Service>>(serviceService.findAll(),HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/services",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Service> addService(@RequestBody Service service) {
		
		// checking if request is valid
			if(service.getName() == null || 
					service.getOrganization() == null || 
					service.getOrganization().getId() == null) 
				return new ResponseEntity<Service>(HttpStatus.BAD_REQUEST);
		
		// checking if organization exists
			else if(orgService.findOneOrg(service.getOrganization().getId()) == null)
				return new ResponseEntity<Service>(HttpStatus.NOT_FOUND);
			else {
				Organization org = orgService.findOneOrg(service.getOrganization().getId());
				
			// checking if there is a service already existing for this organization with given name
				List<Service> servicesOfOrg = org.getServices();
				for(Service s: servicesOfOrg) {
					if(service.getName().equals(s.getName()))
						return new ResponseEntity<Service>(HttpStatus.CONFLICT);
				}
			
			// aligning organization object with the categories from service
				List<Integer> categoriesOfOrg = new ArrayList<Integer>();
				for(Category orgCat : org.getCategories())
					categoriesOfOrg.add(orgCat.getId());
				
				for(Category cat : service.getCategories()) {
					if(!categoriesOfOrg.contains(cat.getId()))
							org.getCategories().add(categoryService.findOneCategory(cat.getId()));
				}
				
			// saving state after changes
				orgService.saveOrg(org);
				serviceService.saveService(service);
				return new ResponseEntity<Service>(service,HttpStatus.CREATED);
			}
	}
	
	@RequestMapping(value="/services/by/categories", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Service>> getServicesByCategories(@RequestParam List<Integer> catIds) {
		return new ResponseEntity<List<Service>>(serviceService.findByCategoryId(catIds), HttpStatus.OK);
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
			return new ResponseEntity<Service>(HttpStatus.NO_CONTENT);
		}
		else return new ResponseEntity<Service>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value="/services/{id}",method=RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Service> updateService(@PathVariable int id, @RequestBody Service service) {
		Service s = serviceService.findService(id);
		if(s != null) {
			s.setName(service.getName());
			s.setDescription(service.getDescription());
			s.setCategories(service.getCategories());
			s.setCost(service.getCost());
			s.setDistinct(service.isDistinct());
			s.setOpinions(service.getOpinions());
			serviceService.saveService(s);
			return new ResponseEntity<Service>(s, HttpStatus.OK);
		}
		else return new ResponseEntity<Service>(HttpStatus.NOT_FOUND);
	}
	
}

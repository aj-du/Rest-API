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

import ajdu_restful_api.model.Package;
import ajdu_restful_api.model.Service;
import ajdu_restful_api.model.User;
import ajdu_restful_api.service.PackageService;
import ajdu_restful_api.service.ServiceService;
import ajdu_restful_api.service.UserService;

@RestController
public class PackageRestController {

	@Autowired
	PackageService packService;
	@Autowired
	UserService userService;
	@Autowired
	ServiceService serviceService;
	
	
	@RequestMapping(value="/packages",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Package>> getAllPackages() {
		return new ResponseEntity<List<Package>>(packService.findPackages(),HttpStatus.OK);
	}
	
	@RequestMapping(value="/packages",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Package> createPackage(@RequestBody Package pack) {
		if(pack.getUser() == null || pack.getUser().getId() == null) {
			return new ResponseEntity<Package>(HttpStatus.BAD_REQUEST);
		}
		else {
			User u = userService.findUser(pack.getUser().getId());
			if(u.getPack() != null)
				return new ResponseEntity<Package>(HttpStatus.CONFLICT);
			else {			
				packService.save(pack);
				return new ResponseEntity<Package>(pack, HttpStatus.CREATED);
			}
		}		
	}
	
	
	@RequestMapping(value="/packages/{id}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Package> getPackage(@PathVariable int id) {
		Package p = packService.findPackage(id);
		if(p != null)
			return new ResponseEntity<Package>(p,HttpStatus.OK);
		else return new ResponseEntity<Package>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value="/packages/{id}",method=RequestMethod.PUT,consumes=MediaType.APPLICATION_JSON_UTF8_VALUE )
	public ResponseEntity<Package> updatePackage(@PathVariable int id, @RequestBody Package pack) {
		Package p = packService.findPackage(id);
		if(p != null) {
			p.setName(pack.getName());
			p.setServices(pack.getServices());
			p.setTotalCost(pack.getTotalCost());
			packService.save(p);
			return new ResponseEntity<Package>(p, HttpStatus.OK);
		}
		return new ResponseEntity<Package>(HttpStatus.NOT_FOUND);
	}
	
	
	@RequestMapping(value="/packages/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<Package> deletePackage(@PathVariable int id) {
		Package p = packService.findPackage(id);
		if(p != null) {
			packService.delete(id);
			return new ResponseEntity<Package>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Package>(HttpStatus.NOT_FOUND);
	}
	
	
	@RequestMapping(value="/packages/{id}/services",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Service>> findAllServicesByPackage(@PathVariable int id){
		if(packService.findPackage(id) != null) 
			return new ResponseEntity<List<Service>>(serviceService.findAllServicesByPackage(id), HttpStatus.OK);
		else 
			return new ResponseEntity<List<Service>>(HttpStatus.NOT_FOUND);
	}
	
	
	@RequestMapping(value="/packages/{id}/services", method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Service>> addServiceToPackage(@RequestBody Service service, @PathVariable int id) {
		Package p = packService.findPackage(id);
		if(p != null && service.getId() != null) {
			Service s = serviceService.findService(service.getId());
			if(s != null) {
				p.getServices().add(s);
				packService.save(p);
			}
			return new ResponseEntity<List<Service>>(p.getServices(), HttpStatus.CREATED);
		}
		else return new ResponseEntity<List<Service>>(HttpStatus.NOT_FOUND);
	}
	
	
}

package ajdu_restful_api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
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
public class PackageRestController extends AuthenticatedRestController {

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
	public ResponseEntity<Package> createPackage(@RequestBody Package pack, Authentication auth) {
		if(pack.getUser() == null || pack.getUser().getId() == null)
			return new ResponseEntity<Package>(HttpStatus.BAD_REQUEST);		
		
		User u = userService.findUser(pack.getUser().getId());
		
		if(!hasPermission(auth, u.getLogin()))
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		
		if(u.getPack() != null)
			return new ResponseEntity<Package>(HttpStatus.CONFLICT);
		else {			
			packService.save(pack);
			return new ResponseEntity<Package>(pack, HttpStatus.CREATED);
		}
			
	}
	
	
	@RequestMapping(value="/packages/{id}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Package> getPackage(@PathVariable int id, Authentication auth) {
		Package p = packService.findPackage(id);
		if(p != null){
			User u = userService.findUser(p.getUser().getId());
			if(!hasPermission(auth, u.getLogin()))
				return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
			else return new ResponseEntity<Package>(p,HttpStatus.OK); 
		}
		else return new ResponseEntity<Package>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value="/packages/{id}",method=RequestMethod.PUT,consumes=MediaType.APPLICATION_JSON_UTF8_VALUE )
	public ResponseEntity<Package> updatePackage(@PathVariable int id, @RequestBody Package pack, Authentication auth) {
		
		Package p = packService.findPackage(id);		
		
		if(p != null) {
			User u = userService.findUser(p.getUser().getId());
			if(!hasPermission(auth, u.getLogin()))
				return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
			
			List<Service> services = new ArrayList<Service>();
			if(pack.getServices() != null) {
				for(Service serv: pack.getServices()) {
					if(serv.getId() != null && serviceService.findService(serv.getId()) != null)
						services.add(serviceService.findService(serv.getId()));
					else return new ResponseEntity<Package>(HttpStatus.BAD_REQUEST);
				}
				p.setServices(services);
				packService.save(p);
				return new ResponseEntity<Package>(p, HttpStatus.OK);
			}
			else return new ResponseEntity<Package>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Package>(HttpStatus.NOT_FOUND);
	}
	
	
	@RequestMapping(value="/packages/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<Package> deletePackage(@PathVariable int id, Authentication auth) {
		Package p = packService.findPackage(id);
		if(p != null) {
			User u = userService.findUser(p.getUser().getId());
			if(!hasPermission(auth, u.getLogin()))
				return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
			
			packService.delete(id);
			return new ResponseEntity<Package>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Package>(HttpStatus.NOT_FOUND);
	}
	
	
	@RequestMapping(value="/packages/{id}/services",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Service>> findAllServicesByPackage(@PathVariable int id, Authentication auth){
		Package p = packService.findPackage(id);
		if(p != null) {
			User u = userService.findUser(p.getUser().getId());
			if(!hasPermission(auth, u.getLogin()))
				return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
			else return new ResponseEntity<List<Service>>(serviceService.findAllServicesByPackage(id), HttpStatus.OK);
		}
		else 
			return new ResponseEntity<List<Service>>(HttpStatus.NOT_FOUND);
	}
	
	
	@RequestMapping(value="/packages/{id}/services", method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Service>> addServiceToPackage(@RequestBody Service service, @PathVariable int id, Authentication auth) {
		Package p = packService.findPackage(id);
		if(p==null)
			return new ResponseEntity<List<Service>>(HttpStatus.NOT_FOUND);
		else if(service.getId() == null)
			return new ResponseEntity<List<Service>>(HttpStatus.BAD_REQUEST);
		else {
			User u = userService.findUser(p.getUser().getId());
			if(!hasPermission(auth, u.getLogin()))
				return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
			
			Service s = serviceService.findService(service.getId());
			if(s == null)
				return new ResponseEntity<List<Service>>(HttpStatus.NOT_FOUND);
			else if(p.getServices().contains(s)){
				return new ResponseEntity<List<Service>>(HttpStatus.CONFLICT);
			}
			else {
				p.getServices().add(s);
				packService.save(p);
				return new ResponseEntity<List<Service>>(p.getServices(), HttpStatus.CREATED);
			}
		}		
	}
	
	
	@RequestMapping(value="/packages/{packageId}/services/{serviceId}",
			method=RequestMethod.DELETE,consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Service> deleteServiceFromPackage(@PathVariable int packageId, @PathVariable int serviceId, Authentication auth) {
		Package p = packService.findPackage(packageId);
		Service s = serviceService.findService(serviceId);
		if(p==null || s==null || !p.getServices().contains(s))
			return new ResponseEntity<Service>(HttpStatus.NOT_FOUND);
		else {
			User u = userService.findUser(p.getUser().getId());
			if(!hasPermission(auth, u.getLogin()))
				return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
			
			p.getServices().remove(s);
			packService.save(p);
			return new ResponseEntity<Service>(HttpStatus.OK);
		}
	}
	
	
}

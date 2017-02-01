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
import ajdu_restful_api.service.PackageService;

@RestController
public class PackageRestController {

	@Autowired
	PackageService packService;
	
	
	@RequestMapping(value="/packages",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Package>> getAllPackages() {
		return new ResponseEntity<List<Package>>(packService.findPackages(),HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/packages/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<Package> deletePackage(@PathVariable int id) {
		Package p = packService.findPackage(id);
		if(p != null) {
			packService.delete(id);
			return new ResponseEntity<Package>(HttpStatus.OK);
		}
		return new ResponseEntity<Package>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value="/packages/{id}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Package> getPackage(@PathVariable int id) {
		Package p = packService.findPackage(id);
		if(p != null)
			return new ResponseEntity<Package>(p,HttpStatus.OK);
		else return new ResponseEntity<Package>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value="/package/{id}",method=RequestMethod.PUT,consumes=MediaType.APPLICATION_JSON_UTF8_VALUE )
	public ResponseEntity<Package> updatePackage(@PathVariable int id, @RequestBody Package pack) {
		Package p = packService.findPackage(id);
		if(p != null) {
			p.setName(pack.getName());
			p.setServices(pack.getServices());
			p.setTotalCost(pack.getTotalCost());
			p.setUser(pack.getUser());
			return new ResponseEntity<Package>(p, HttpStatus.OK);
		}
		return new ResponseEntity<Package>(HttpStatus.NOT_FOUND);
	}
	
	
}

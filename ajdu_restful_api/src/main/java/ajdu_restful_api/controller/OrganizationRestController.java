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

import ajdu_restful_api.model.Organization;
import ajdu_restful_api.model.Service;
import ajdu_restful_api.service.AddressService;
import ajdu_restful_api.service.OrganizationService;

@RestController
public class OrganizationRestController {

	@Autowired
	private OrganizationService organizationService;
	@Autowired
	private AddressService addressService;
	
	@RequestMapping(value="/orgs",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Organization>> getAllOrgs() {
		return new ResponseEntity<List<Organization>>(organizationService.findAllOrgs(),HttpStatus.OK);
	}
	
	@RequestMapping(value="/orgs",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Organization> saveOrg(@RequestBody Organization org) {
		
		if(organizationService.findOrgByLogin(org.getLogin()) == null) {			
			addressService.saveAddress(org.getAddress());
			organizationService.saveOrg(org);
			return new ResponseEntity<Organization>(org,HttpStatus.CREATED);
		}
		return new ResponseEntity<Organization>(HttpStatus.CONFLICT);
	}
	
	@RequestMapping(value="/orgs/by/categories", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Organization>> getOrgsByCategories(@RequestParam List<Integer> catIds) {
		return new ResponseEntity<List<Organization>>(organizationService.findByCategoryId(catIds), HttpStatus.OK);
	}
	
	@RequestMapping(value="/orgs/{id}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Organization> getOrg(@PathVariable int id) {
		Organization org = organizationService.findOneOrg(id);
		if(org != null)
			return new ResponseEntity<Organization>(org,HttpStatus.OK);
		else 
			return new ResponseEntity<Organization>(HttpStatus.NOT_FOUND);
	}	
	
	
	@RequestMapping(value="/orgs/{id}/services",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Service>> getOrgsServices(@PathVariable int id) {
		Organization org = organizationService.findOneOrg(id);
		if(org != null)
			return new ResponseEntity<List<Service>>(org.getServices(),HttpStatus.OK);
		else 
			return new ResponseEntity<List<Service>>(HttpStatus.NOT_FOUND);
	}	
	
	
	@RequestMapping(value="/orgs/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<Organization> deleteOrg(@PathVariable int id) {
		Organization org = organizationService.findOneOrg(id);
		if(org != null) {
			organizationService.deleteOrg(id);
			return new ResponseEntity<Organization>(HttpStatus.NO_CONTENT);
		}
		else 
			return new ResponseEntity<Organization>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value="/orgs/{id}",method=RequestMethod.PUT, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Organization> updateOrg(@PathVariable int id, @RequestBody Organization org) {
		Organization o = organizationService.findOneOrg(id);
		if(o != null) {
			o.setName(org.getName());
			o.setActive(org.isActive());
			o.setAddress(org.getAddress());
			o.setEmail(org.getEmail());
			o.setLogin(org.getLogin());
			o.setPassword(org.getPassword());
			o.setPhoneNumber(org.getPhoneNumber());
			addressService.saveAddress(o.getAddress());
			organizationService.saveOrg(o);
			return new ResponseEntity<Organization>(o, HttpStatus.OK);
		}
		else 
			return new ResponseEntity<Organization>(HttpStatus.NOT_FOUND);
	}
	
}

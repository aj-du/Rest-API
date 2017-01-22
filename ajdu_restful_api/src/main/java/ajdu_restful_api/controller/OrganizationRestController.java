package ajdu_restful_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ajdu_restful_api.model.Organization;
import ajdu_restful_api.service.AddressService;
import ajdu_restful_api.service.CategoryService;
import ajdu_restful_api.service.OrganizationService;

@RestController
public class OrganizationRestController {

	@Autowired
	private OrganizationService organizationService;
	@Autowired
	private AddressService addressService;
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/allorgs")
	public ResponseEntity<List<Organization>> getAllOrgs() {
		return new ResponseEntity<List<Organization>>(organizationService.findAllOrgs(),HttpStatus.OK);
	}
	
	@GetMapping("/org")
	public ResponseEntity<Organization> getOrg(@RequestParam int id) {
		return new ResponseEntity<Organization>(organizationService.findOneOrg(id),HttpStatus.OK);
	}
	
	@RequestMapping(value="/addorg",method=RequestMethod.POST)
	public ResponseEntity<Organization> saveOrg(@RequestBody Organization org) {
		
		if(organizationService.findOrgByLogin(org.getLogin()) == null) {			
			addressService.saveAddress(org.getAddress());
			organizationService.saveOrg(org);
			return new ResponseEntity<Organization>(org,HttpStatus.CREATED);
		}
		return new ResponseEntity<Organization>(HttpStatus.CONFLICT);
	}
	
	@GetMapping("/deleteorg")
	public ResponseEntity<Organization> deleteOrg(@RequestParam int id) {
		organizationService.deleteOrg(id);
		return new ResponseEntity<Organization>(HttpStatus.OK);
	}
	
}

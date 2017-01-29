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

import ajdu_restful_api.model.Role;
import ajdu_restful_api.service.RoleService;

@RestController
public class RoleRestController {

	@Autowired
	private RoleService roleService;
	
	
	@RequestMapping(value="/roles",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Role>> allRoles(){
		return new ResponseEntity<List<Role>> (roleService.findAllRoles(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/roles",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Role> addRole(@RequestBody Role role) {
		for(Role r : roleService.findAllRoles()) {
			if(r.getRoleName().equals(role.getRoleName()))
				return new ResponseEntity<Role>(HttpStatus.CONFLICT);
		}
		roleService.addRole(role);
		return new ResponseEntity<Role>(role,HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/roles/{id}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Role> getRole(@PathVariable int id) {
		Role r = roleService.findRole(id);
		if(r != null) 
			return new ResponseEntity<Role>(r,HttpStatus.OK);
		else 
			return new ResponseEntity<Role>(HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping(value="/roles/{id}",method=RequestMethod.PUT,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Role> updateRole(@PathVariable int id, @RequestBody Role role) {
		Role r = roleService.findRole(id);
		if(r != null) {
			r.setRoleName(role.getRoleName());
			return new ResponseEntity<Role>(r,HttpStatus.OK);
		}
		return new ResponseEntity<Role>(HttpStatus.NOT_FOUND);		
	}
	
	
	

}

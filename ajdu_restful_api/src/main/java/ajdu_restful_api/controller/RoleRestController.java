package ajdu_restful_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ajdu_restful_api.model.Role;
import ajdu_restful_api.service.RoleService;

@RestController
public class RoleRestController {

	@Autowired
	private RoleService roleService;
	
	
	
	@GetMapping("/allroles")
	public List<Role> allUsers(){
		return roleService.findAllRoles();
	}
	
	

}

package ajdu_restful_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ajdu_restful_api.service.UserService;

@RestController
public class SampleRestController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/hello")
	public String hello(){
		return "Hello World!";
	}
	
	@GetMapping("/allusers")
	public String allUsers(){
		return userService.findAll().toString();
	}

}

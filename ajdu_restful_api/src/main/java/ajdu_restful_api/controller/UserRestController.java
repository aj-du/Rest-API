package ajdu_restful_api.controller;

import java.util.Date;
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

import ajdu_restful_api.model.User;
import ajdu_restful_api.service.UserService;

@RestController
public class UserRestController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/hello")
	public String hello(){
		return "Hello World!";
	}
	
	@GetMapping("/allusers")
	public List<User> allUsers(){
		return userService.findAll();
	}
	
	@GetMapping("/user")
	public User findOneUser(@RequestParam int id){
		return userService.findUser(id);
	}
	
	@GetMapping("/saveuser")
	public String saveUser(
			@RequestParam String firstName, 
			@RequestParam String lastName, 
			@RequestParam String login, 
			@RequestParam String password, 
			@RequestParam String email){
		User user = new User(firstName, lastName, login, password, email, new Date());
		userService.save(user);
		return "User saved!";
	}
	
	@RequestMapping(value="/adduser", method=RequestMethod.POST)
	public ResponseEntity<User> addUser(@RequestBody User user) {
		userService.save(user);
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}
	
	@GetMapping("/deleteuser")
	public String deleteUser(@RequestParam int id) {
		userService.delete(id);
		return "User deleted!";
	}
	

}

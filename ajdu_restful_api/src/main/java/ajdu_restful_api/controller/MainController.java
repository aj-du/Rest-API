package ajdu_restful_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import ajdu_restful_api.service.UserService;

@Controller
public class MainController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/home")
	public String home(){
		return "index";
	}

}

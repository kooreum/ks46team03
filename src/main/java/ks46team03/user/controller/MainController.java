package ks46team03.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("userMainController")
@RequestMapping("/user")
public class MainController {
	
	@GetMapping("/index")
	public String userMainPage() {
		
		return "user/user_main";
	}

	@GetMapping("/home")
	public String userHomePage() {

		return "user/user_home";
	}
}

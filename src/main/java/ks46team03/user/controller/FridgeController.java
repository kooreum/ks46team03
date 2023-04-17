package ks46team03.user.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class FridgeController {
	
	@GetMapping("/fridge")
	public String userRecipePage() {
		return "user/fridge/user_fridge";
	}
}

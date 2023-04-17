package ks46team03.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("adminMainController")
@RequestMapping("/admin")
public class MainController {

	@GetMapping("/index")
	public String adminMainPage() {
		
		return "admin/admin_main";
	}
}

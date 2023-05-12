package ks46team03.user.controller;

import ks46team03.dto.Recipe;
import ks46team03.user.mapper.UserRecipeMapper;
import ks46team03.user.service.UserRecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller("userMainController")
@RequestMapping("/user")
public class MainController {
	private final UserRecipeService userRecipeService;
	private final UserRecipeMapper userRecipeMapper;
	public MainController(UserRecipeService userRecipeService, UserRecipeMapper userRecipeMapper) {
		this.userRecipeService = userRecipeService;
		this.userRecipeMapper = userRecipeMapper;
	}
	@GetMapping("/index")
	public String userMainPage() {
		
		return "user/user_main";
	}

	@GetMapping("/home")
	public String userHomePage(Model model, Map<String, Object> paramMap) {

		List<Recipe> viewRank = userRecipeService.getViewRank(paramMap);

		model.addAttribute("viewRank", viewRank);

		return "user/user_home";
	}
}

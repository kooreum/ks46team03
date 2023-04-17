package ks46team03.user.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("userRecipeController")
@RequestMapping("/user")
public class RecipeController {
	
	@GetMapping("/recipe")
	public String userRecipePage() {
		return "user/recipe/user_recipe";
	}
}

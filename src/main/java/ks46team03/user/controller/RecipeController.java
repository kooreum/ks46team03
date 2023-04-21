package ks46team03.user.controller;

import ks46team03.dto.Member;
import ks46team03.dto.Recipe;
import ks46team03.user.mapper.UserMemberMapper;
import ks46team03.user.mapper.UserRecipeMapper;
import ks46team03.user.service.UserRecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/user/recipe")
public class RecipeController {
	private final UserRecipeService userRecipeService;
	private final UserRecipeMapper userRecipeMapper;
	private final UserMemberMapper userMemberMapper;

	public  RecipeController(UserRecipeService userRecipeService, UserRecipeMapper userRecipeMapper, UserMemberMapper userMemberMapper) {
		this.userRecipeService = userRecipeService;
		this.userRecipeMapper = userRecipeMapper;
		this.userMemberMapper = userMemberMapper;
	}

	@GetMapping("recipeList")
	public String getRecipeList(Model model
								,@RequestParam(name="searchKey", required = false) String searchKey
								,@RequestParam(name="searchValue", required = false) String searchValue) {

		List<Recipe> recipeList = userRecipeService.getRecipeList(searchKey, searchValue);

		model.addAttribute("title", "레시피조회");
		model.addAttribute("recipeList", recipeList);

		return "user/recipe/user_recipeList";
	}
}
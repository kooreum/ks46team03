package ks46team03.user.controller;


import ks46team03.dto.Message;
import ks46team03.dto.Recipe;
import ks46team03.user.mapper.UserMemberMapper;
import ks46team03.user.mapper.UserRecipeMapper;
import ks46team03.user.service.UserRecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/user")
public class RecipeController {
	private final UserRecipeService userRecipeService;
	private final UserRecipeMapper userRecipeMapper;
	private final UserMemberMapper userMemberMapper;


	public  RecipeController(UserRecipeService userRecipeService, UserRecipeMapper userRecipeMapper, UserMemberMapper userMemberMapper) {
		this.userRecipeService = userRecipeService;
		this.userRecipeMapper = userRecipeMapper;
		this.userMemberMapper = userMemberMapper;
	}
	/**
	 * 레시피삭제 리다이렉트
	 * @param recipeCode
	 * @return
	 */
	@PostMapping("/recipe/user_removeRecipe")
	public String removeRecipe(String recipeCode) {

		userRecipeMapper.removeRecipeById(recipeCode);

		return "redirect:/user/recipe/recipeList";
	}


	/**
	 * 레시피삭제화면
	 * @param recipeCode
	 * @param model
	 * @return
	 */
	@GetMapping("/recipe/user_removeRecipe")
	public String removeRecipe(@RequestParam(name = "recipeCode") String recipeCode, Model model){
		model.addAttribute("title", "레시피삭제화면");
		model.addAttribute("recipeCode", recipeCode);

		return "/user/recipe/user_removeRecipe";
	}


	/**
	 * 레시피 수정화면 리다이렉트
	 * @param recipe
	 * @return
	 */
	@PostMapping("/recipe/user_modifyRecipe")
	public String UserModifyRecipe(Recipe recipe) {

		userRecipeMapper.modifyRecipe(recipe);

		return "redirect:/user/recipe/recipeList";
	}

	/**
	 * 레시피수정화면
	 * @param recipeCode
	 * @param model
	 * @return
	 */
	@GetMapping("/recipe/user_modifyRecipe")
	public String UserModifyRecipe(
			@RequestParam(name="recipeCode") String recipeCode ,Model model
			,@RequestParam(name="searchKey", required = false) String searchKey
			,@RequestParam(name="searchValue", required = false) String searchValue)
		      {
		Recipe recipeInfo = userRecipeService.getRecipeInfoById(recipeCode);
		List<Recipe> recipeList = userRecipeService.getRecipeList(searchKey, searchValue);
		model.addAttribute("title", "레시피수정화면");
		model.addAttribute("recipeList",recipeList);
		model.addAttribute("recipeInfo", recipeInfo);

		return "/user/recipe/user_modifyRecipe";
	}
	@PostMapping("/recipe/user_addRecipe")
	public String addRecipe(Recipe recipe) {
		userRecipeService.addRecipe(recipe);
		return "redirect:/user/recipe/recipeList";
	}

	@GetMapping("/recipe/user_addRecipe")
	public String addRecipe(Model model,String searchKey,String searchValue) {

		List<Recipe> RecipeList = userRecipeService.getRecipeList(searchKey,searchValue);

		model.addAttribute("title", "레시피등록화면");
		model.addAttribute("RecipeList", RecipeList);

		return "/user/recipe/user_addRecipe";
	}


	@GetMapping("/recipe/recipeList")
	public String getRecipeList(Model model
								,@RequestParam(name="searchKey", required = false) String searchKey
								,@RequestParam(name="searchValue", required = false) String searchValue) {

		List<Recipe> recipeList = userRecipeService.getRecipeList(searchKey, searchValue);

		model.addAttribute("title", "레시피조회");
		model.addAttribute("recipeList", recipeList);

		return "user/recipe/user_recipeList";
	}
}
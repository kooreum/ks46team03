package ks46team03.user.controller;


import jakarta.servlet.http.HttpSession;
import ks46team03.admin.mapper.IngredientMapper;
import ks46team03.admin.service.IngredientService;
import ks46team03.common.mapper.FileMapper;
import ks46team03.dto.*;
import ks46team03.user.mapper.UserMemberMapper;
import ks46team03.user.mapper.UserRecipeIngredientMapper;
import ks46team03.user.mapper.UserRecipeMapper;
import ks46team03.user.service.UserRecipeCategoryService;
import ks46team03.user.service.UserRecipeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user/recipe")
public class RecipeController {
	private final UserRecipeService userRecipeService;
	private final UserRecipeMapper userRecipeMapper;
	private final UserMemberMapper userMemberMapper;
	private  final UserRecipeIngredientMapper userRecipeIngredientMapper;
	private final UserRecipeCategoryService userRecipeCategoryService;

	private final IngredientService ingredientService;
	private final IngredientMapper ingredientMapper;

	private final FileMapper fileMapper;

	private static final Logger log = LoggerFactory.getLogger(RecipeController.class);

	public RecipeController(IngredientService ingredientService,
							IngredientMapper ingredientMapper,
							UserRecipeCategoryService userRecipeCategoryService,
							UserRecipeService userRecipeService,
							UserRecipeMapper userRecipeMapper,
							UserMemberMapper userMemberMapper,
							UserRecipeIngredientMapper userRecipeIngredientMapper,
							FileMapper fileMapper) {
		this.userRecipeService = userRecipeService;
		this.userRecipeMapper = userRecipeMapper;
		this.userMemberMapper = userMemberMapper;
		this.userRecipeIngredientMapper = userRecipeIngredientMapper;
		this.userRecipeCategoryService = userRecipeCategoryService;
		this.ingredientService = ingredientService;
		this.ingredientMapper = ingredientMapper;
		this.fileMapper = fileMapper;
	}

	/**
	 * 레시피삭제 리다이렉트
	 *
	 * @param recipeCode
	 * @return
	 */
	@PostMapping("/removeRecipe")
	public String removeRecipe(@RequestParam(name = "recipeCode") String recipeCode
			, @RequestParam(name = "memberId") String memberId
			, @RequestParam(name = "memberPw") String memberPw
			, HttpSession session
			, RedirectAttributes reAttr) {
		String memberLevel = (String) session.getAttribute("SLEVEL");
		boolean isDelete = true;
		String msg = "";
		if (memberLevel != null && "2".equals(memberLevel)) {
			isDelete = userRecipeMapper.isPosterByRecipeCode(memberId, recipeCode);
		}

		Member member = userMemberMapper.getMemberInfoById(memberId);
		if (member != null) {
			String checkPw = member.getMemberPw();
			if (!checkPw.equals(memberPw)) isDelete = false;
		}
		if (isDelete) {
			userRecipeService.removeRecipe(recipeCode);
			msg = "레시피코드:" + recipeCode + " 가 삭제되었습니다.";
		} else {
			msg = "레시피코드:" + recipeCode + " 를 삭제할 수 없습니다.";
		}
		reAttr.addAttribute("msg", msg);

		return "redirect:/user/recipe/recipeList";
	}


	/**
	 * 레시피삭제화면
	 *
	 * @param recipeCode
	 * @param model
	 * @return
	 */
	@GetMapping("/removeRecipe")
	public String removeRecipe(@RequestParam(name = "recipeCode") String recipeCode, Model model) {
		userRecipeService.removeRecipe(recipeCode);
		model.addAttribute("title", "레시피삭제화면");
		model.addAttribute("recipeCode", recipeCode);

		return "user/recipe/user_removeRecipe";
	}


	/**
	 * 레시피 수정화면 리다이렉트
	 *
	 * @param recipe
	 * @return
	 */
	@PostMapping("/modifyRecipe")
	public String UserModifyRecipe(Recipe recipe) {

		userRecipeMapper.modifyRecipe(recipe);

		return "redirect:/user/recipe/recipeList";
	}

	/**
	 * 레시피수정화면
	 *
	 * @param recipeCode
	 * @param model
	 * @return
	 */
	@GetMapping("/modifyRecipe")
	public String UserModifyRecipe(
			@RequestParam(name = "recipeCode") String recipeCode, Model model, Map<String, Object> paramMap
			, @RequestParam(name = "searchKey", required = false) String searchKey
			, @RequestParam(name = "searchValue", required = false) String searchValue) {
		Recipe recipeInfo = userRecipeService.getRecipeInfoByCode(recipeCode);
		List<Recipe> recipeList = userRecipeService.getRecipeList(paramMap, searchKey, searchValue);
		String fileIdx = recipeInfo.getFileIdx();
		if(fileIdx != null){
			FileDto fileDto = fileMapper.getFileInfoByIdx(fileIdx);
			model.addAttribute("fileDetail", fileDto);
		}
		model.addAttribute("title", "레시피수정화면");
		model.addAttribute("recipeList", recipeList);
		model.addAttribute("recipeInfo", recipeInfo);

		return "user/recipe/user_modifyRecipe";
	}

	@PostMapping("/addRecipe")
	public String addRecipe( Recipe recipe,@RequestParam(name="imageUri") MultipartFile[] uploadfile) {

		userRecipeService.addRecipe(recipe, uploadfile);

		return "redirect:/user/recipe/recipeList";
	}

	@GetMapping("/addRecipe")
	public String addRecipe(Map<String, Object> paramMap, Model model, String searchKey, String searchValue) {

		List<Recipe> RecipeList = userRecipeService.getRecipeList(paramMap, searchKey, searchValue);
		List<RecipeCategory> recipeCategories = userRecipeCategoryService.getRecipeCategoryList();
		List<Ingredient> ingredients = ingredientService.getIngredientList(searchKey, searchValue);
		model.addAttribute("title", "레시피등록화면");
		model.addAttribute("RecipeList", RecipeList);
		model.addAttribute("recipeCategories",recipeCategories);
		model.addAttribute("ingredients", ingredients);

		return "/user/recipe/user_addRecipe";
	}

	@GetMapping("/list/recipeCate")
	@ResponseBody
	public List<RecipeCategory> getRecipCateList(){
		List<RecipeCategory> recipeCategories = userRecipeCategoryService.getRecipeCategoryList();
		return recipeCategories;
	}

	/**
	 * 레시피목록 조회
	 */
	@GetMapping("/recipeList")
	public String getRecipeList(Model model
			, @RequestParam(name = "searchKey", required = false) String searchKey
			, @RequestParam(name = "searchValue", required = false) String searchValue
			, HttpSession session
			, @RequestParam(name = "msg", required = false) String msg) {
		String memberLevel = (String) session.getAttribute("SLEVEL");
		Map<String, Object> paramMap = null;
		if (memberLevel != null && "2".equals(memberLevel)) {
			String sellerId = (String) session.getAttribute("SID");
			paramMap = new HashMap<String, Object>();
			paramMap.put("searchKey", "g_seller_id");
			paramMap.put("searchValue", sellerId);
		}
		log.info("msg={}", msg);
		List<Recipe> recipeList = userRecipeService.getRecipeList(paramMap, searchKey, searchValue);
		model.addAttribute("title", "레시피조회");
		model.addAttribute("recipeList", recipeList);
		if (msg != null) model.addAttribute("msg", msg);
		return "user/recipe/user_recipeList";
	}

	@GetMapping("/recipeDetail")
	public String getRecipeInfoByCode(Model model, String recipeCode) {
		List<Map<String, Object>> ingredientDetailList  = userRecipeService.getIngredientInfoByCode(recipeCode);
		Recipe recipeDetail = userRecipeService.getRecipeInfoByCode(recipeCode);
		String fileIdx = recipeDetail.getFileIdx();
		if(fileIdx != null){
			FileDto fileDto = fileMapper.getFileInfoByIdx(fileIdx);
			model.addAttribute("fileDetail", fileDto);
		}
		model.addAttribute("ingredientDetailList", ingredientDetailList);
		model.addAttribute("recipeDetail", recipeDetail);

		return "user/recipe/user_recipe";
	}



}
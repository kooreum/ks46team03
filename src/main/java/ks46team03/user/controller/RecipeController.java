package ks46team03.user.controller;

import jakarta.servlet.http.HttpSession;
import ks46team03.admin.mapper.IngredientMapper;
import ks46team03.admin.service.IngredientService;
import ks46team03.common.mapper.FileMapper;
import ks46team03.dto.Bookmark;
import ks46team03.dto.Member;
import ks46team03.dto.Recipe;
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
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class RecipeController {
	private final UserRecipeService userRecipeService;
	private final UserRecipeMapper userRecipeMapper;
	private final UserMemberMapper userMemberMapper;
	private final UserRecipeIngredientMapper userRecipeIngredientMapper;
	private final UserRecipeCategoryService userRecipeCategoryService;
	private final IngredientService ingredientService;
	private final IngredientMapper ingredientMapper;
	private final FileMapper fileMapper;

	private static final Logger log = LoggerFactory.getLogger(InquiryController.class);
	public  RecipeController(UserRecipeService userRecipeService,
							 UserRecipeMapper userRecipeMapper,
							 UserMemberMapper userMemberMapper,
							 IngredientService ingredientService,
							 IngredientMapper ingredientMapper,
							 UserRecipeCategoryService userRecipeCategoryService,
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
	 * @param recipeCode
	 * @return
	 */
	@PostMapping("/recipe/removeRecipe")
	public String removeRecipe(@RequestParam(name = "recipeCode") String recipeCode
			, @RequestParam(name = "memberId") String memberId
			, @RequestParam(name = "memberPw") String memberPw
			, HttpSession session
			, RedirectAttributes reAttr) {
		String memberLevel = (String) session.getAttribute("SLEVEL");
		boolean isDelete = true;
		String msg = "";

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
	 * @param recipeCode
	 * @param model
	 * @return
	 */
	@GetMapping("/recipe/removeRecipe")
	public String removeRecipe(@RequestParam(name = "recipeCode") String recipeCode, Model model) {
		userRecipeService.removeRecipe(recipeCode);
		model.addAttribute("title", "레시피삭제화면");
		model.addAttribute("recipeCode", recipeCode);

		return "user/recipe/user_removeRecipe";
	}

	/**
	 * 레시피 수정화면 리다이렉트
	 * @param recipe
	 * @return
	 */
	@PostMapping("/recipe/modifyRecipe")
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
	@GetMapping("/recipe/modifyRecipe")
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
	@PostMapping("/recipe/addRecipe")
	public String addRecipe( Recipe recipe,@RequestParam(name="imageUri") MultipartFile[] uploadfile) {

		userRecipeService.addRecipe(recipe, uploadfile);

		return "redirect:/user/recipe/recipeList";
	}

	@GetMapping("/recipe/addRecipe")
	public String addRecipe(Map<String, Object> paramMap, Model model, String searchKey, String searchValue) {

		List<Recipe> RecipeList = userRecipeService.getRecipeList(paramMap, searchKey, searchValue);
		List<RecipeCategory> recipeCategories = userRecipeCategoryService.getRecipeCategoryList();
		List<Ingredient> ingredients = ingredientService.getIngredientList(searchKey, searchValue);
		model.addAttribute("title", "레시피등록화면");
		model.addAttribute("RecipeList", RecipeList);
		model.addAttribute("recipeCategories",recipeCategories);
		model.addAttribute("ingredients", ingredients);

		return "user/recipe/user_addRecipe";
	}

	@GetMapping("/recipe/list/recipeCate")
	@ResponseBody
	public List<RecipeCategory> getRecipCateList(){
		List<RecipeCategory> recipeCategories = userRecipeCategoryService.getRecipeCategoryList();
		return recipeCategories;
	}

	@GetMapping("/recipe/recipeList")
	public String getRecipeList(Model model
								, @RequestParam(name="searchKey", required = false) String searchKey
								, @RequestParam(name="searchValue", required = false) String searchValue
								, HttpSession session, Map<String,Object> paramMap) {
		List<Recipe> recipeList = userRecipeService.getRecipeList(paramMap, searchKey, searchValue);
		model.addAttribute("title", "레시피조회");
		model.addAttribute("recipeList", recipeList);
		return "user/recipe/user_recipeList";
	}

	@GetMapping("/recipe/bookmarkList")
	public String getBookmarkList(Model model
								, HttpSession session) {
		String SID = (String)session.getAttribute("SID");
		List<Bookmark> bookmarkList = userRecipeService.getBookmarkList(SID);
		model.addAttribute("bookmarkList", bookmarkList);

		return "user/recipe/user_bookmarkList";
	}

	@PostMapping("/removeBookmark")
	public String removeBookmark(@RequestParam(name = "recipeBookmarksCode") String recipeBookmarksCode) {

		userRecipeService.removeBookmark(recipeBookmarksCode);
		return "redirect:/user/recipe/bookmarkList";
	}

	@PostMapping("/addBookmark")
	@ResponseBody
	public String addBookmark(@RequestParam(name = "recipeCode", required = false) String recipeCode
								, HttpSession session) {
		String SID = (String)session.getAttribute("SID");
		userRecipeService.addBookmark(recipeCode, SID);
		return "redirect:/user/recipe/recipeDetail";
	}

	@GetMapping("/recipe/recipeDetail")
	public String getRecipeInfoByCode(Model model, String recipeCode) {
		Recipe recipeDetail = userRecipeService.getRecipeInfoByCode(recipeCode);
		List<Map<String, Object>> ingredientDetailList  = userRecipeService.getIngredientInfoByCode(recipeCode);
		int viewCount = userRecipeService.getViewCount(recipeCode);
		String fileIdx = recipeDetail.getFileIdx();
		if(fileIdx != null){
			FileDto fileDto = fileMapper.getFileInfoByIdx(fileIdx);
			model.addAttribute("fileDetail", fileDto);
		}
		model.addAttribute("ingredientDetailList", ingredientDetailList);
		model.addAttribute("recipeDetail", recipeDetail);
		model.addAttribute("viewCount", viewCount);
		return "user/recipe/user_recipe";
	}

}
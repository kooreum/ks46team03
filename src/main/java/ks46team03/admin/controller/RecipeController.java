package ks46team03.admin.controller;


import ks46team03.admin.mapper.RecipeMapper;
import ks46team03.admin.service.RecipeService;
import ks46team03.dto.Recipe;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller("adminRecipeController")
@RequestMapping("/admin")
public class RecipeController {

    private final RecipeService recipeService;
    private final RecipeMapper recipeMapper;

    public RecipeController(RecipeService recipeService, RecipeMapper recipeMapper) {
        this.recipeService = recipeService;
        this.recipeMapper = recipeMapper;
    }

    /**
     * 레시피삭제 리다이렉트
     * @param recipeCode
     * @return
     */
    @PostMapping("/recipe/removeRecipe")
    public String removeRecipe(String recipeCode) {

        recipeMapper.removeRecipeById(recipeCode);

        return "redirect:/admin/recipe/admin_recipeList";
    }


    /**
     * 레시피삭제화면
     * @param recipeCode
     * @param model
     * @return
     */
    @GetMapping("/recipe/removeRecipe")
    public String removeRecipe(@RequestParam(name = "recipeCode") String recipeCode, Model model){
        model.addAttribute("title", "레시피삭제화면");
        model.addAttribute("recipeCode", recipeCode);

        return "/admin/recipe/admin_removeRecipe";
    }


    /**
     * 레시피 수정화면 리다이렉트
     * @param recipe
     * @return
     */
    @PostMapping("/recipe/modifyRecipe")
    public String modifyRecipe(Recipe recipe) {

        recipeMapper.modifyRecipe(recipe);

        return "redirect:/admin/recipe/admin_recipeList";
    }

    /**
     * 레시피수정화면
     * @param recipeCode
     * @param model
     * @return
     */
    @GetMapping("/recipe/modifyRecipe")
    public String modifyRecipe(
            @RequestParam(name="recipeCode") String recipeCode
            ,Model model) {
        Recipe recipeInfo = recipeService.getRecipeInfoById(recipeCode);
        List<Recipe> recipeList = recipeService.getRecipeList();
        model.addAttribute("title", "레시피수정화면");
        model.addAttribute("recipeList", recipeList);
        model.addAttribute("recipeInfo", recipeInfo);

        return "/admin/recipe/admin_modifyRecipe";
    }


    /**
     * 레시피 등록 리다이렉트
     * @param recipe
     * @return
     */
    @PostMapping("/recipe/admin_addRecipe")
    public String addRecipe(Recipe recipe) {
        recipeService.addRecipe(recipe);
        return "redirect:/admin/recipe/admin_recipeList";
    }


    /**
     * 레시피등록화면
     * @param model
     * @return
     */
    @GetMapping("/recipe/admin_addRecipe")
    public String addRecipe(Model model) {

        List<Recipe> RecipeList = recipeService.getRecipeList();

        model.addAttribute("title", "레시피등록화면");
        model.addAttribute("RecipeList", RecipeList);

        return "/admin/recipe/admin_addRecipe";
    }



    @GetMapping("/admin/admin_recipe")

    public String adminRecipe(){

        return "admin_addRecipe";
    }

    /**
     * 레시피 리스트
     * @param model
     * @return
     */
    @GetMapping("/recipe/admin_recipeList")
    public String getRecipeList(Model model) {
        List<Recipe> recipeList = recipeService.getRecipeList();
        model.addAttribute("title", "레시피목록조회");
        model.addAttribute("recipeList", recipeList);

        return "/admin/recipe/admin_recipeList";
    }

}

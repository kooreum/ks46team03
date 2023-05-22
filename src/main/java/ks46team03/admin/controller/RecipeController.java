package ks46team03.admin.controller;


import jakarta.servlet.http.HttpSession;
import ks46team03.admin.mapper.MemberMapper;
import ks46team03.admin.mapper.RecipeMapper;
import ks46team03.admin.service.RecipeService;
import ks46team03.dto.Recipe;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller("adminRecipeController")
@RequestMapping("/admin/recipe")
public class RecipeController {

    private final RecipeService recipeService;
    private final RecipeMapper recipeMapper;

    private final MemberMapper memberMapper;

    public RecipeController(RecipeService recipeService, RecipeMapper recipeMapper, MemberMapper memberMapper) {
        this.recipeService = recipeService;
        this.recipeMapper = recipeMapper;
        this.memberMapper = memberMapper;
    }

    /**
     * 레시피삭제 리다이렉트
     * @param recipeCode
     * @return
     */
    @PostMapping("/removeRecipe")
    public String removeRecipe(String recipeCode) {

        recipeMapper.removeRecipeById(recipeCode);

        return "redirect:/admin/recipe/recipeList";
    }


    /**
     * 레시피삭제화면
     * @param recipeCode
     * @param model
     * @return
     */
    @GetMapping("/removeRecipe")
    public String removeRecipe(@RequestParam(name = "recipeCode") String recipeCode, Model model){
        model.addAttribute("title", "레시피삭제화면");
        model.addAttribute("recipeCode", recipeCode);

        return "admin/recipe/admin_removeRecipe";
    }


    /**
     * 레시피 수정화면 리다이렉트
     * @param recipe
     * @return
     */
    @PostMapping("/modifyRecipe")
    public String modifyRecipe(Recipe recipe) {

        recipeMapper.modifyRecipe(recipe);

        return "redirect:/admin/recipe/recipeList";
    }

    /**
     * 레시피수정화면
     * @param recipeCode
     * @param model
     * @return
     */
    @GetMapping("/modifyRecipe")
    public String modifyRecipe(
            @RequestParam(name="recipeCode") String recipeCode, Map<String,Object> paramMap
            ,@RequestParam(name="searchKey", required = false) String searchKey
            ,@RequestParam(name="searchValue", required = false) String searchValue
            ,Model model) {
        Recipe recipeInfo = recipeService.getRecipeInfoById(recipeCode);
        List<Recipe> recipeList = recipeService.getRecipeList(paramMap,searchKey, searchValue);
        model.addAttribute("title", "레시피수정화면");
        model.addAttribute("recipeList", recipeList);
        model.addAttribute("recipeInfo", recipeInfo);

        return "admin/recipe/admin_modifyRecipe";
    }





    /**
     * 레시피 등록 리다이렉트
     * @param recipe
     * @return
     */
    @PostMapping("/addRecipe")
    public String addRecipe(Recipe recipe) {
        recipeService.addRecipe(recipe);
        return "redirect:/admin/recipe/recipeList";
    }


    /**
     * 레시피등록화면
     * @param model
     * @return
     */
    @GetMapping("/addRecipe")
    public String addRecipe(Map<String,Object> paramMap, Model model,String searchKey,String searchValue) {

        List<Recipe> RecipeList = recipeService.getRecipeList(paramMap,searchKey,searchValue);

        model.addAttribute("title", "레시피등록화면");
        model.addAttribute("RecipeList", RecipeList);

        return "admin/recipe/admin_addRecipe";
    }




    /**
     * 레시피 리스트
     * @param model
     * @return
     */
    @GetMapping("/recipeList")
    public String getRecipeList(Model model
            , @RequestParam(name = "searchKey", required = false) String searchKey
            , @RequestParam(name = "searchValue", required = false) String searchValue
            , HttpSession session
            , @RequestParam(name = "msg", required = false) String msg)  {
        String memberLevel = (String)session.getAttribute("SLEVLE");
        Map<String, Object> paramMap = null;
        if(memberLevel != null && "2".equals(memberLevel)){
            String sellerId = (String) session.getAttribute("SID");
            paramMap = new HashMap<String, Object>();
            paramMap.put("searchkey", "g_seller_id");
            paramMap.put("searchValue", sellerId);
        }
        List<Recipe> recipeList = recipeService.getRecipeList(paramMap,searchKey,searchValue);
        model.addAttribute("title", "레시피목록조회");
        model.addAttribute("recipeList", recipeList);
        if(msg != null) model.addAttribute("msg",msg);
        return "admin/recipe/admin_recipeList";
    }

}

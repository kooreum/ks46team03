package ks46team03.admin.controller;

import ks46team03.dto.Ingredient;
import ks46team03.admin.mapper.IngredientMapper;
import ks46team03.admin.service.IngredientService;
import ks46team03.dto.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class IngredientController {


    private final IngredientService ingredientService;
    private final IngredientMapper ingredientMapper;

    public IngredientController(IngredientService ingredientService, IngredientMapper ingredientMapper) {
        this.ingredientService = ingredientService;
        this.ingredientMapper = ingredientMapper;
    }


    /**
     * 재료삭제 리다이렉트
     * @param ingredientCode
     * @return
     */
    @PostMapping("/ingredient/removeIngredient")
    public String removeIngredient(String ingredientCode) {

        ingredientMapper.removeIngredientById(ingredientCode);

        return "redirect:/admin/ingredient/admin_ingredientList";
    }


    /**
     * 재료삭제화면
     * @param ingredientCode
     * @param model
     * @return
     */
    @GetMapping("/ingredient/removeIngredient")
    public String removeIngredient(@RequestParam(name = "ingredientCode") String ingredientCode, Model model){
        model.addAttribute("title", "재료삭제화면");
        model.addAttribute("ingredientCode", ingredientCode);

        return "admin/ingredient/admin_removeIngredient";
    }


    /**
     * 재료수정 리다이렉트
     * @param ingredient
     * @return
     */
    @PostMapping("/ingredient/modifyIngredient")
    public String modifyIngredient(Ingredient ingredient) {

        ingredientMapper.modifyIngredient(ingredient);

        return "redirect:/admin/ingredient/admin_ingredientList";
    }

    /**
     * 재료수정화면
     * @param ingredientCode
     * @param model
     * @return
     */
    @GetMapping("/ingredient/modifyIngredient")
    public String modifyIngredient(
            @RequestParam(name="ingredientCode") String ingredientCode,
            @RequestParam(name="searchKey", required = false) String searchKey
            ,@RequestParam(name="searchValue", required = false) String searchValue
            ,Model model) {
        Ingredient ingredientInfo = ingredientService.getIngredientInfoById(ingredientCode);
        List<Ingredient> ingredientList = ingredientService.getIngredientList(searchKey, searchValue);
        model.addAttribute("title", "재료수정화면");
        model.addAttribute("ingredientList", ingredientList);
        model.addAttribute("ingredientInfo", ingredientInfo);

        return "admin/ingredient/admin_modifyIngredient";
    }


    /**
     * 재료등록 리다이렉트
     * @param ingredient
     * @return
     */
    @PostMapping("/ingredient/admin_addIngredient")
    public String addIngredient(Ingredient ingredient) {
        ingredientService.addIngredient(ingredient);
        return "redirect:/admin/ingredient/admin_ingredientList";
    }

    /**
     *재료등록
     * @param model
     * @return
     */
    @GetMapping("/ingredient/admin_addIngredient")
    public String addIngredient(Model model,String searchKey,String searchValue) {

        List<Ingredient> IngredientList = ingredientService.getIngredientList(searchKey,searchValue);

        model.addAttribute("title", "재료등록화면");
        model.addAttribute("IngredientList", IngredientList);

        return "admin/ingredient/admin_addIngredient";
    }


    /**
     * 재료리스트
     * @param model
     * @return
     */
    @GetMapping("/ingredient/admin_ingredientList")

    public String getIngredientList(Model model,String searchKey,String searchValue) {

        List<Ingredient> ingredientList = ingredientService.getIngredientList(searchKey,searchValue);
        model.addAttribute("title", "재료목록화면");
        model.addAttribute("ingredientList", ingredientList);

        return "admin/ingredient/admin_ingredientList";


    }
}

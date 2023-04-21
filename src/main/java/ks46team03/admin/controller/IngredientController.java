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


    @PostMapping("/ingredient/removeIngredient")
    public String removeIngredient(String ingredientCode) {

        ingredientMapper.removeIngredientById(ingredientCode);

        return "redirect:/admin/ingredient/admin_ingredientList";
    }




    @GetMapping("/ingredient/removeIngredient")
    public String removeIngredient(@RequestParam(name = "ingredientCode") String ingredientCode, Model model){
        model.addAttribute("title", "회원탈퇴");
        model.addAttribute("ingredientCode", ingredientCode);

        return "/admin/ingredient/admin_removeIngredient";
    }



    @PostMapping("/ingredient/modifyIngredient")
    public String modifyIngredient(Ingredient ingredient) {

        ingredientMapper.modifyIngredient(ingredient);

        return "redirect:/admin/ingredient/admin_ingredientList";
    }

    @GetMapping("/ingredient/modifyIngredient")
    public String modifyIngredient(
            @RequestParam(name="ingredientCode") String ingredientCode
            ,Model model) {
        Ingredient ingredientInfo = ingredientService.getIngredientInfoById(ingredientCode);
        List<Ingredient> ingredientList = ingredientService.getIngredientList();
        model.addAttribute("title", "재료수정");
        model.addAttribute("ingredientList", ingredientList);
        model.addAttribute("ingredientInfo", ingredientInfo);

        return "/admin/ingredient/admin_modifyIngredient";
    }



    @PostMapping("/ingredient/admin_addIngredient")
    public String addIngredient(Ingredient ingredient) {
        ingredientService.addIngredient(ingredient);
        return "redirect:/admin/ingredient/admin_ingredientList";
    }


    @GetMapping("/ingredient/admin_addIngredient")
    public String addIngredient(Model model) {

        List<Ingredient> IngredientList = ingredientService.getIngredientList();

        model.addAttribute("title", "재료등록");
        model.addAttribute("IngredientList", IngredientList);

        return "/admin/ingredient/admin_addIngredient";
    }



    @GetMapping("/ingredient/admin_ingredientList")

    public String getIngredientList(Model model) {
        List<Ingredient> ingredientList = ingredientService.getIngredientList();
        model.addAttribute("title", "재료목록");
        model.addAttribute("ingredientList", ingredientList);

        return "/admin/ingredient/admin_ingredientList";


    }
}

package ks46team03.admin.service;

import ks46team03.admin.mapper.MemberMapper;
import ks46team03.admin.mapper.RecipeMapper;
import ks46team03.dto.Ingredient;
import ks46team03.dto.Recipe;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RecipeService {
    private final RecipeMapper recipeMapper;

    public RecipeService(RecipeMapper recipeMapper) {
        this.recipeMapper = recipeMapper;
    }

    public void removeRecipe(String recipeCode) {
        Recipe recipeInfo = recipeMapper.getRecipeInfoById(recipeCode);

        if(recipeInfo != null) {
            String infoRecipeCode = recipeInfo.getRecipeCode();


            recipeMapper.removeRecipeListById(recipeCode);
            //회원탈퇴
            recipeMapper.removeRecipeById(recipeCode);
        }

    }

    public void modifyRecipe(Recipe recipe) {
        recipeMapper.modifyRecipe(recipe);
    }


    public Recipe getRecipeInfoById(String recipeCode) {
        Recipe recipeInfo = recipeMapper.getRecipeInfoById(recipeCode);
        return recipeInfo;
    }


    public int addRecipe(Recipe recipe) {
        int result =
                recipeMapper.addRecipe(recipe);

        return result;
    }

    public List<Recipe> getRecipeList() {
        List <Recipe> recipeList = recipeMapper.getRecipeList();

        return recipeList;


    }
}

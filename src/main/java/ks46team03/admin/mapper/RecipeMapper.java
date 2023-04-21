package ks46team03.admin.mapper;

import ks46team03.dto.Ingredient;
import ks46team03.dto.Recipe;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;

@Mapper
public interface RecipeMapper {


    public int removeRecipeListById(String recipeCode);
    //레시피삭제
    public int removeRecipeById(String recipeCode);
    // 레시피수정
    public int modifyRecipe(Recipe recipe);
    // 레시피재료조회
    public Recipe getRecipeInfoById(String recipeCode);
    public int addRecipe(Recipe recipe);
    public List<Recipe> getRecipeList();
}

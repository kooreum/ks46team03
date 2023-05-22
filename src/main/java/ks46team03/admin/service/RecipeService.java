package ks46team03.admin.service;

import ks46team03.admin.mapper.MemberMapper;
import ks46team03.admin.mapper.RecipeMapper;
import ks46team03.dto.Ingredient;
import ks46team03.dto.Recipe;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class RecipeService {
    private final RecipeMapper recipeMapper;


    public RecipeService(RecipeMapper recipeMapper) {
        this.recipeMapper = recipeMapper;
    }

    /**
     * 레시피 삭제
     */
    public void removeRecipe(String recipeCode) {
        Recipe recipeInfo = recipeMapper.getRecipeInfoById(recipeCode);

        if (recipeInfo != null) {
            String infoRecipeCode = recipeInfo.getRecipeCode();

            //레시피이력삭제
            recipeMapper.removeRecipeListById(recipeCode);
            //레시피삭제
            recipeMapper.removeRecipeById(recipeCode);
        }

    }

    /**
     * 레시피 수정
     *
     * @param recipe
     */
    public void modifyRecipe(Recipe recipe) {

        recipeMapper.modifyRecipe(recipe);
    }

    /**
     * 특정레시피 조회
     *
     * @param recipeCode
     * @return
     */
    public Recipe getRecipeInfoById(String recipeCode) {
        Recipe recipeInfo = recipeMapper.getRecipeInfoById(recipeCode);
        return recipeInfo;
    }


    /**
     * 레시피 등록
     *
     * @param recipe
     * @return
     */
    public int addRecipe(Recipe recipe) {
        int result =
                recipeMapper.addRecipe(recipe);

        return result;
    }

    /**
     * 레시피 목록 조회
     *
     * @return
     */
    public List<Recipe> getRecipeList(Map<String,Object> paramMap, String searchKey, String searchValue) {
        if (searchKey != null) {
            switch (searchKey) {
                case "memberId":
                    searchKey = "r.member_id";
                    break;
                case "recipeCode":
                    searchKey = "r.recipe_code";
                    break;
                case "recipeName":
                    searchKey = "r.recipe_name";
                    break;
                default:
                    searchKey = "r.recipe_category_code";
                    break;
            }
        }
            List<Recipe> recipeList = recipeMapper.getRecipeList(paramMap, searchKey, searchValue);

        return recipeList;
    }
}

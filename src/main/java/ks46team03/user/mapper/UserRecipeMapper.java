package ks46team03.user.mapper;

import ks46team03.dto.Recipe;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserRecipeMapper {

    //레시피 이력 삭제
    public int removeRecipeListById(String recipeCode);
    //레시피삭제
    public int removeRecipeById(String recipeCode);
    // 레시피수정
    public int modifyRecipe(Recipe recipe);
    // 특정레시피조회
    public Recipe getRecipeInfoById(String recipeCode);
    //레시피 등록
    public int addRecipe(Recipe recipe);
    // 레시피 목록조회
    public List<Recipe> getRecipeList(String searchKey, String searchValue);


}

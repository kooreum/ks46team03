package ks46team03.user.mapper;

import ks46team03.dto.Bookmark;
import ks46team03.dto.Recipe;
import ks46team03.dto.RecipeIngredient;
import org.apache.ibatis.annotations.Mapper;

import javax.swing.text.View;
import java.util.List;
import java.util.Map;

@Mapper
public interface UserRecipeMapper {

    public boolean isPosterByRecipeCode(String memberId, String recipeCode);
    //레시피 이력 삭제
    public int removeRecipeListById(String recipeCode);
    //레시피삭제
    public int removeRecipeById(String recipeCode);
    // 레시피수정
    public int modifyRecipe(Recipe recipe);
    // 특정레시피조회
    public Recipe getRecipeInfoById(String recipeCode);
    public Recipe getRecipeInfoByCode(String recipeCode);
    //레시피 등록
    public int addRecipe(Recipe recipe);
    // 레시피 목록조회
    public List<Recipe> getRecipeList(Map<String,Object> paramMap, String searchKey, String searchValue);
    //레시피 재료 등록
    public  int addRecipeIngredient(List<RecipeIngredient> recipeIngredientList);

    public List<Bookmark> getBookmarkList(String SID);

    public int removeBookmark(String recipeBookmarksCode);

    public int addBookmark(String recipeCode, String SID);

    public int getViewCount(String recipeCode);

    public List<Recipe> getViewRank(Map<String, Object> paramMap);
}

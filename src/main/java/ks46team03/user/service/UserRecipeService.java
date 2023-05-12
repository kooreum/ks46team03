package ks46team03.user.service;

import ks46team03.dto.Bookmark;
import ks46team03.user.mapper.UserMemberMapper;
import ks46team03.dto.Recipe;
import ks46team03.user.mapper.UserRecipeMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.View;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class UserRecipeService {
    private final UserRecipeMapper userRecipeMapper;
    private final UserMemberMapper userMemberMapper;

    public UserRecipeService(UserRecipeMapper userRecipeMapper, UserMemberMapper userMemberMapper) {
        this.userRecipeMapper = userRecipeMapper;
        this.userMemberMapper = userMemberMapper;
    }

    public void removeRecipe(String recipeCode) {
        Recipe recipeInfo = userRecipeMapper.getRecipeInfoById(recipeCode);

        if(recipeInfo != null) {
            String infoRecipeCode = recipeInfo.getRecipeCode();

            //레시피이력삭제
            userRecipeMapper.removeRecipeListById(recipeCode);
            //레시피삭제
            userRecipeMapper.removeRecipeById(recipeCode);
        }

    }




    //레시피 수정
    public void modifyRecipe(Recipe recipe) {
        userRecipeMapper.modifyRecipe(recipe);
    }


    //특정레시피 조회
    public Recipe getRecipeInfoById(String recipeCode) {
        Recipe recipeInfo = userRecipeMapper.getRecipeInfoById(recipeCode);
        return recipeInfo;
    }


    public int addRecipe(Recipe recipe) {
        int result =
                userRecipeMapper.addRecipe(recipe);

        return result;
    }

    public List<Recipe> getRecipeList(Map<String,Object> paramMap,String searchKey, String searchValue) {
        if (searchKey != null) {
            switch (searchKey) {
                case "memberId":
                    searchKey = "r.member_id";
                    break;
                case "recipeCategoryCode":
                    searchKey = "r.recipe_category_code";
                    break;
                case "ingredientCategoryCode":
                    searchKey = "ir.ingredient_category_code";
                    break;
                default:
                    searchKey = "r.recipe_name";
                    break;
            }
        }
        List<Recipe> recipeList = userRecipeMapper.getRecipeList(paramMap,searchKey, searchValue);

        return recipeList;
    }

    public List<Bookmark> getBookmarkList(String searchKey, String searchValue, String SID) {
        if (searchKey != null) {
            switch (searchKey) {
                case "memberId":
                    searchKey = "r.member_id";
                    break;
                default:
                    searchKey = "r.recipe_name";
                    break;
            }
        }
        List<Bookmark> bookmarkList = userRecipeMapper.getBookmarkList(searchKey, searchValue, SID);

        return bookmarkList;
    }

    public int removeBookmark(String recipeBookmarksCode) {
        int result = userRecipeMapper.removeBookmark(recipeBookmarksCode);
        return result;
    }

    public Recipe getRecipeInfoByCode(String recipeCode) {

        Recipe recipeDetail = userRecipeMapper.getRecipeInfoByCode(recipeCode);

        return recipeDetail;
    }
    public int getViewCount(String recipeCode) {
        int viewCount = userRecipeMapper.getViewCount(recipeCode);

        return viewCount;
    }

    public List<Recipe> getViewRank(Map<String, Object> paramMap) {
        List<Recipe> viewRank = userRecipeMapper.getViewRank(paramMap);

        return viewRank;
    }



}

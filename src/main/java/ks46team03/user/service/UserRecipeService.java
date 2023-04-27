package ks46team03.user.service;

import ks46team03.user.mapper.UserMemberMapper;
import ks46team03.dto.Recipe;
import ks46team03.user.mapper.UserRecipeMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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



    /**
     * 레시피 수정
     * @param recipe
     */
    public void modifyRecipe(Recipe recipe) {
        userRecipeMapper.modifyRecipe(recipe);
    }

    /**
     * 특정레시피 조회
     * @param recipeCode
     * @return
     */
    public Recipe getRecipeInfoById(String recipeCode) {
        Recipe recipeInfo = userRecipeMapper.getRecipeInfoById(recipeCode);
        return recipeInfo;
    }


    public int addRecipe(Recipe recipe) {
        int result =
                userRecipeMapper.addRecipe(recipe);

        return result;
    }

    /**
     * 회원목록 조회
     *
     * @return List<Member>
     */
    public List<Recipe> getRecipeList(Map<String,Object> paramMap, String searchKey, String searchValue) {
        if (searchKey != null) {
            switch (searchKey) {
                case "memberId":
                    searchKey = "r.member_id";
                    break;
                case "recipeName":
                    searchKey = "r.recipe_name";
                    break;
                default:
                    searchKey = "r.recipe_category_code";
                    break;
            }
        }
        List<Recipe> recipeList = userRecipeMapper.getRecipeList(paramMap,searchKey, searchValue);

        return recipeList;
    }

}

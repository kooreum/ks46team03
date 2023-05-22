package ks46team03.user.service;

import ks46team03.common.mapper.FileMapper;
import ks46team03.common.util.FileUtil;
import ks46team03.dto.FileDto;
import ks46team03.dto.Ingredient;
import ks46team03.dto.RecipeIngredient;
import ks46team03.user.mapper.UserMemberMapper;
import ks46team03.dto.Recipe;
import ks46team03.user.mapper.UserRecipeIngredientMapper;
import ks46team03.user.mapper.UserRecipeMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class UserRecipeService {

    @Value("${files.path}")
    private String filePath;

    private final UserRecipeMapper userRecipeMapper;
    private final UserMemberMapper userMemberMapper;
    private final UserRecipeIngredientMapper userRecipeIngredientMapper;

    private final FileMapper fileMapper;

    private final FileUtil fileUtil;

    public UserRecipeService(UserRecipeMapper userRecipeMapper,
                             UserMemberMapper userMemberMapper,
                             UserRecipeIngredientMapper userRecipeIngredientMapper,
                             FileUtil fileUtil,
                             FileMapper fileMapper) {
        this.userRecipeMapper = userRecipeMapper;
        this.userMemberMapper = userMemberMapper;
        this.userRecipeIngredientMapper = userRecipeIngredientMapper;
        this.fileUtil = fileUtil;
        this.fileMapper = fileMapper;
    }

    public void removeRecipe(String recipeCode) {
        Recipe recipeInfo = (Recipe) userRecipeMapper.getRecipeInfoByCode(recipeCode);

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
    public Recipe getRecipeInfoByCode(String recipeCode) {

        Recipe recipeDetail = userRecipeMapper.getRecipeInfoByCode(recipeCode);

        return recipeDetail;
    }
    public  List<Map<String, Object>> getIngredientInfoByCode(String recipeCode) {
        List<Map<String, Object>> ingredientDetailList = userRecipeIngredientMapper.getIngredientInfoByCode(recipeCode);

        return ingredientDetailList;
    }


    public int addRecipe(Recipe recipe, MultipartFile[] uploadfile) {

        List<FileDto> fileList = fileUtil.parseFileInfo(uploadfile,filePath);

        fileMapper.addFile(fileList);
        String fileIdx = fileList.get(0).getFileIdx();
        recipe.setFileIdx(fileIdx);

        int result =
                userRecipeMapper.addRecipe(recipe);
        if(result > 0) {
            List<RecipeIngredient> recipeIngredientList = recipe.getRecipeIngredients();
            recipeIngredientList.forEach(recipeIngredient -> {
                recipeIngredient.setRecipeCode(recipe.getRecipeCode());
                recipeIngredient.setMemberId(recipe.getMemberId());
            });
            userRecipeMapper.addRecipeIngredient(recipeIngredientList);
            /*
            String recipeCode = recipe.getRecipeCode();
            recipeIngredient.setRecipeCode(recipe.getRecipeCode());
            recipeIngredient.setMemberId(recipe.getMemberId());
            recipeIngredient.setIngredientCode(recipeIngredient.getIngredientCode());
            recipeIngredient.setQuantity(recipeIngredient.getQuantity());
            recipeIngredient.setGram(recipeIngredient.getGram());


            userRecipeMapper.addRecipeIngredient(recipeIngredient);

             */
        }

        return result;
    }

    /**
     * 회원목록 조회
     *
     * @return List<Member>
     */
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

}

package ks46team03.user.service;

import ks46team03.user.mapper.UserMemberMapper;
import ks46team03.dto.Recipe;
import ks46team03.dto.Member;
import ks46team03.user.mapper.UserRecipeMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserRecipeService {
    private final UserRecipeMapper userRecipeMapper;
    private final UserMemberMapper userMemberMapper;

    public UserRecipeService(UserRecipeMapper userRecipeMapper, UserMemberMapper userMemberMapper) {
        this.userRecipeMapper = userRecipeMapper;
        this.userMemberMapper = userMemberMapper;
    }

    /**
     * 회원목록 조회
     *
     * @return List<Member>
     */
    public List<Recipe> getRecipeList(String searchKey, String searchValue) {
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
        List<Recipe> recipeList = userRecipeMapper.getRecipeList(searchKey, searchValue);

        return recipeList;
    }

}

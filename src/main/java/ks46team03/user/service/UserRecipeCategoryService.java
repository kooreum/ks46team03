package ks46team03.user.service;

import ks46team03.dto.RecipeCategory;
import ks46team03.user.mapper.UserRecipeCategoryMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class UserRecipeCategoryService {

    private final UserRecipeCategoryMapper userRecipeCategoryMapper;

    public UserRecipeCategoryService(UserRecipeCategoryMapper userRecipeCategoryMapper){
        this.userRecipeCategoryMapper =userRecipeCategoryMapper;
    }

    public List<RecipeCategory> getRecipeCategoryList(){
        List<RecipeCategory> recipeCategoryList = userRecipeCategoryMapper.getRecipeCategoryList();
        return recipeCategoryList;
    }
}

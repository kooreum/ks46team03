package ks46team03.user.mapper;

import ks46team03.dto.RecipeCategory;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserRecipeCategoryMapper {
    public List<RecipeCategory> getRecipeCategoryList();
}

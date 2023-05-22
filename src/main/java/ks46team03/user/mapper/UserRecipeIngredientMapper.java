package ks46team03.user.mapper;

import ks46team03.dto.RecipeIngredient;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserRecipeIngredientMapper {

    public List<Map<String, Object>> getIngredientInfoByCode(String recipeCode);
}

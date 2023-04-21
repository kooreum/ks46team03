package ks46team03.admin.mapper;

import ks46team03.dto.Ingredient;
import ks46team03.dto.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IngredientMapper {

    public int removeIngredientListById(String ingredientCode);
    //재료삭제
    public int removeIngredientById(String ingredientCode);
    // 재료수정
    public int modifyIngredient(Ingredient ingredient);
    // 특정재료조회
    public Ingredient getIngredientInfoById(String ingredientCode);

    public List<Ingredient> getIngredientList();

    public int addIngredient(Ingredient ingredient);


}

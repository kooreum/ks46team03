package ks46team03.admin.mapper;

import ks46team03.dto.Ingredient;
import ks46team03.dto.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IngredientMapper {

    //재료이력삭제
    public int removeIngredientListById(String ingredientCode);
    //재료삭제
    public int removeIngredientById(String ingredientCode);
    // 재료수정
    public int modifyIngredient(Ingredient ingredient);
    // 특정재료조회
    public Ingredient getIngredientInfoById(String ingredientCode);
    //재료 목록 조회
    public List<Ingredient> getIngredientList();
    //재료등록
    public int addIngredient(Ingredient ingredient);


}

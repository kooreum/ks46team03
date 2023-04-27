package ks46team03.user.mapper;

import ks46team03.dto.Fridge;
import ks46team03.dto.Ingredient;
import ks46team03.dto.Location;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserFridgeMapper {

    public int removeIngredientListById(String ingredientCode);
    //재료삭제
    public int removeIngredientById(String ingredientCode);
    // 재료수정
    public int modifyIngredient(Ingredient ingredient);
    // 특정재료조회
    public Ingredient getIngredientInfoById(String ingredientCode);

    public List<Fridge> getFridgeList(Map<String,Object> paramMap);

    public List<Location> getLocationList();

    public List<Ingredient> getIngredientList();

    public int addFridge(Fridge fridge);


}

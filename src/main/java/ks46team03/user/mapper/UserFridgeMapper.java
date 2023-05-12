package ks46team03.user.mapper;

import ks46team03.dto.Fridge;
import ks46team03.dto.Ingredient;
import ks46team03.dto.Location;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserFridgeMapper {

    // 냉장고재료조회
    public List<Location> getFridgeList(Map<String,Object> paramMap);
    // 냉장고세부위치조회
    public List<Location> getLocationList();
    // 재료조회
    public List<Ingredient> getIngredientList();
    // 냉장고재료등록
    public int addFridge(Fridge fridge);
    //재료삭제
    public int removeIngredient(String myIngredientCode);

}

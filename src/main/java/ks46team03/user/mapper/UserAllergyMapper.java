package ks46team03.user.mapper;

import ks46team03.dto.Allergy;
import ks46team03.dto.Fridge;
import ks46team03.dto.Ingredient;
import ks46team03.dto.Location;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserAllergyMapper {

    // 나의 알러지 재료 조회
    public List<Allergy> getAllergyList(Map<String,Object> paramMap);

    //나의 알러지 재료 등록
    public int addAllergy(Allergy allergy);

    //나의 알러지 재료 삭제
    public void removeAllergyByCode(String allergyCode);
/*
    public int removeIngredientListById(String ingredientCode);

    // 재료수정
    public int modifyIngredient(Ingredient ingredient);
    // 특정재료조회
    public Ingredient getIngredientInfoById(String ingredientCode);



    public List<Location> getLocationList();

    public List<Ingredient> getIngredientList();

    */


}

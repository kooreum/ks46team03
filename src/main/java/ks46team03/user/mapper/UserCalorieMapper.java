package ks46team03.user.mapper;

import ks46team03.dto.Calorie;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserCalorieMapper {

    // 나의 등록된 제한 칼로리 조회
    public List<Calorie> getCalorieList(Map<String,Object> paramMap);
    public void deleteUserCalorie(String oneMealCalCode);

}

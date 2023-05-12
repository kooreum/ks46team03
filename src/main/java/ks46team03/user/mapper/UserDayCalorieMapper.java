package ks46team03.user.mapper;

import ks46team03.dto.Calorie;
import ks46team03.dto.DayCalorie;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserDayCalorieMapper {

    // 나의 등록된 제한 칼로리 조회
    public List<DayCalorie> getCalorieList(Map<String,Object> paramMap);


}

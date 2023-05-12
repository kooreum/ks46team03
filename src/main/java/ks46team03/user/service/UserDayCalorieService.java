package ks46team03.user.service;

import ks46team03.dto.Calorie;
import ks46team03.dto.DayCalorie;
import ks46team03.user.mapper.UserCalorieMapper;
import ks46team03.user.mapper.UserDayCalorieMapper;
import ks46team03.user.mapper.UserMemberMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class UserDayCalorieService {

    private final UserDayCalorieMapper userDayCalorieMapper;
    private final UserMemberMapper userMemberMapper;

    public UserDayCalorieService(UserDayCalorieMapper userDayCalorieMapper, UserMemberMapper userMemberMapper){
        this.userDayCalorieMapper = userDayCalorieMapper;
        this.userMemberMapper = userMemberMapper;
    }

    public List<DayCalorie> getCaloriList(Map<String,Object> paramMap){
        List<DayCalorie> dayCalorieList = userDayCalorieMapper.getCalorieList(paramMap);
        return dayCalorieList;
    }

}



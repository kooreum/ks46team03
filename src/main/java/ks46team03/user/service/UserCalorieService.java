package ks46team03.user.service;

import ks46team03.dto.Allergy;
import ks46team03.dto.Calorie;
import ks46team03.user.mapper.UserAllergyMapper;
import ks46team03.user.mapper.UserCalorieMapper;
import ks46team03.user.mapper.UserMemberMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class UserCalorieService {
    private final UserCalorieMapper userCalorieMapper;
    private final UserMemberMapper userMemberMapper;

    public UserCalorieService(UserCalorieMapper userCalorieMapper, UserMemberMapper userMemberMapper){
        this.userCalorieMapper = userCalorieMapper;
        this.userMemberMapper = userMemberMapper;
    }

    public List<Calorie> getCalorieList(Map<String,Object> paramMap){
        List<Calorie> calorieList = userCalorieMapper.getCalorieList(paramMap);
        return calorieList;
    }


    public void deleteUserCalorie(String oneMealCalCode) {
        userCalorieMapper.deleteUserCalorie(oneMealCalCode);
    }


}



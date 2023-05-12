package ks46team03.user.service;

import ks46team03.dto.Allergy;
import ks46team03.user.mapper.UserAllergyMapper;
import ks46team03.user.mapper.UserMemberMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
@Service
@Transactional
public class UserAllergyService{
    private final UserAllergyMapper userAllergyMapper;
    private final UserMemberMapper userMemberMapper;

    public UserAllergyService(UserAllergyMapper userAllergyMapper, UserMemberMapper userMemberMapper){
        this.userAllergyMapper = userAllergyMapper;
        this.userMemberMapper = userMemberMapper;
    }

    public List<Allergy> getAllergyList(Map<String,Object> paramMap){
        List<Allergy> allergyList = userAllergyMapper.getAllergyList(paramMap);
        return allergyList;
    }

    public int addAllergy(Allergy allergy){
        int result = userAllergyMapper.addAllergy(allergy);
        return result;
    }

    public void removeAllergyByCode(String allergyCode){

        userAllergyMapper.removeAllergyByCode(allergyCode);
    }
}



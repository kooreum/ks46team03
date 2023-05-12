package ks46team03.user.service;

import ks46team03.dto.Fridge;
import ks46team03.dto.Location;
import ks46team03.dto.Member;
import ks46team03.user.mapper.UserFridgeMapper;
import ks46team03.user.mapper.UserMemberMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class UserFridgeService {
    private final UserFridgeMapper userFridgeMapper;

    public UserFridgeService(UserFridgeMapper userFridgeMapper) {
        this.userFridgeMapper = userFridgeMapper;
    }

    public List<Location> getFridgeList(Map<String,Object> paramMap){
        List<Location> fridgeList = userFridgeMapper.getFridgeList(paramMap);
        return fridgeList;
    }

    public int addFridge(Fridge fridge) {
        int result = userFridgeMapper.addFridge(fridge);
        return result;
    }

    public int removeIngredient(String myIngredientCode) {
       int result = userFridgeMapper.removeIngredient(myIngredientCode);
       return result;
        }

}

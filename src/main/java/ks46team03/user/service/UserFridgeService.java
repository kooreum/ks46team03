package ks46team03.user.service;


import ks46team03.dto.Fridge;
import ks46team03.user.mapper.UserFridgeMapper;
import ks46team03.user.mapper.UserMemberMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class UserFridgeService {
    private final UserFridgeMapper userFridgeMapper;
    private final UserMemberMapper userMemberMapper;

    public UserFridgeService(UserFridgeMapper userFridgeMapper, UserMemberMapper userMemberMapper) {
        this.userFridgeMapper = userFridgeMapper;
        this.userMemberMapper = userMemberMapper;
    }

    public List<Fridge> getFridgeList(Map<String,Object> paramMap){
        List<Fridge> fridgeList = userFridgeMapper.getFridgeList(paramMap);
        return fridgeList;
    }

    public int addFridge(Fridge fridge) {
        int result = userFridgeMapper.addFridge(fridge);
        return result;
    }

}

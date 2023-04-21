package ks46team03.user.service;

import ks46team03.dto.Board;
import ks46team03.user.mapper.UserBoardMapper;
import ks46team03.user.mapper.UserMemberMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class UserBoardService {
    private final UserBoardMapper userBoardMapper;
    private final UserMemberMapper userMemberMapper;

    public UserBoardService(UserBoardMapper userBoardMapper, UserMemberMapper userMemberMapper) {
        this.userBoardMapper = userBoardMapper;
        this.userMemberMapper = userMemberMapper;
    }

    public List<Board> getBoardList(Map<String,Object> paramMap){
        List<Board> boardList = userBoardMapper.getBoardList(paramMap);
        return boardList;
    }

    public int addNotice(Board board) {
        int result = userBoardMapper.addNotice(board);
        return result;
    }

}

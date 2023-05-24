package ks46team03.admin.mapper;


import ks46team03.dto.Message;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MessageMapper {
    //메세지 이력삭제
    public int removeMessageListById(String messageCode);
    // 메세지삭제
    public int removeMessageById(String messageCode);
    //메세지 수정
    public int modifyMessage(Message message);
    //특정메세지 조회
    public Message getMessageInfoById(String messageCode);
    //메세지 등록
    public int addMessage(Message message);
    //메세지 목록조회
    public List<Message> getMessageList();
}

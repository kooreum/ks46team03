package ks46team03.admin.service;

import ks46team03.admin.mapper.MessageMapper;
import ks46team03.dto.Member;
import ks46team03.dto.Message;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MessageService {
    private final MessageMapper messageMapper;
    public MessageService(MessageMapper messageMapper){
        this.messageMapper = messageMapper;
    }

    /**
     * 메세지 삭제
     * @param messageCode
     */
    public void removeMessage(String messageCode) {
        Message messageInfo = messageMapper.getMessageInfoById(messageCode);

        if(messageInfo != null) {
            String infoMessageCode = messageInfo.getMessageCode();
            //메세지 이력 삭제
            messageMapper.removeMessageListById(messageCode);
            //메세지삭제
            messageMapper.removeMessageById(messageCode);
        }

    }


    /**
     * 메세지정보 수정
     * @param message
     */
    public void modifyMessage(Message message) {

        messageMapper.modifyMessage(message);
    }


    /**
     * 특정 메세지조회
     * @param messageCode
     * @return
     */
    public Message getMessageInfoById(String messageCode) {
        Message messageInfo = messageMapper.getMessageInfoById(messageCode);
        return messageInfo;
    }

    /**
     * 메시지 등록
     * @param message
     * @return
     */
    public int addMessage(Message message) {
        int result = messageMapper.addMessage(message);
        return result;
    }

    /**
     * 메세지 목록조회
     * @return
     */
    public List<Message> getMessageList() {
        List<Message> messageList = messageMapper.getMessageList();

        return messageList;
    }

}

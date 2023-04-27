package ks46team03.admin.service;

import ks46team03.admin.mapper.MessageManagementMapper;
import ks46team03.dto.Message;
import ks46team03.dto.MessageManagement;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MessageManagementService {


    /**
     * 메세지 상세삭제
     * @param messageManagementCode
     */
    public void removeMessageManagement(String messageManagementCode) {
        MessageManagement messageManagementInfo = messageManagementMapper.getMessageManagementInfoById(messageManagementCode);

        if(messageManagementInfo != null) {
            String infoMessageManagementCode = messageManagementInfo.getMessageManagementCode();
            //상세메세지 이력 삭제
            messageManagementMapper.removeMessageManagementListById(messageManagementCode);
            //메세지삭제
            messageManagementMapper.removeMessageManagementById(messageManagementCode);
        }

    }


    public MessageManagement getMessageManagementInfoById(String messageManagementCode) {
        MessageManagement messageManagementInfo = messageManagementMapper.getMessageManagementInfoById(messageManagementCode);
        return messageManagementInfo;
    }

    private final MessageManagementMapper messageManagementMapper;
    public MessageManagementService(MessageManagementMapper messageManagementMapper){
        this.messageManagementMapper = messageManagementMapper;
    }
    /**
     * 메세지 상세목록조회
     * @return
     */
    public List<MessageManagement> getMessageManagementList(String searchKey, String searchValue) {
        if (searchKey != null){
            switch (searchKey){
                case "memberId2":
                    searchKey = "me.member_id2";
                    break;
                default:
                    searchKey = "me.message_code";
                    break;

            }
        }


        List<MessageManagement> messageManagementList = messageManagementMapper.getMessageManagementList(searchKey,searchValue);

        return messageManagementList;

    }

}

package ks46team03.admin.mapper;

import ks46team03.dto.Member;
import ks46team03.dto.MessageManagement;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MessageManagementMapper {
    // 로그인 이력 삭제
    public int removeMessageManagementListById(String massageManagementCode);
    // 회원탈퇴
    public int removeMessageManagementById(String massageManagementCode);
    public MessageManagement getMessageManagementInfoById(String massageManagementCode);
    public List<MessageManagement> getMessageManagementList(String searchKey, String searchValue);
}

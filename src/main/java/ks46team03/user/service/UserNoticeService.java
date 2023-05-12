package ks46team03.user.service;

import ks46team03.dto.Notice;
import ks46team03.dto.Report;
import ks46team03.user.mapper.UserNoticeMapper;
import ks46team03.user.mapper.UserMemberMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class UserNoticeService {
    private final UserNoticeMapper userNoticeMapper;
    private final UserMemberMapper userMemberMapper;

    public UserNoticeService(UserNoticeMapper userNoticeMapper, UserMemberMapper userMemberMapper) {
        this.userNoticeMapper = userNoticeMapper;
        this.userMemberMapper = userMemberMapper;
    }

    public List<Notice> getNoticeList(Map<String,Object> paramMap, String searchKey, String searchValue){

        if (searchKey != null) {
            switch (searchKey) {
                case "memberId":
                    searchKey = "n.member_id";
                    break;
                case "noticeBoardCode":
                    searchKey = "n.notice_board_code";
                    break;
                default:
                    searchKey = "n.notice_board_title";
                    break;
            }
        }
        List<Notice> noticeList = userNoticeMapper.getNoticeList(paramMap, searchKey, searchValue);
        return noticeList;
    }

    public int addNotice(Notice notice){
        int result = userNoticeMapper.addNotice(notice);
        return result;
    }
    public void removeNotice(String noticeBoardCode){
        userNoticeMapper.removeNoticeByNoticeCode(noticeBoardCode);
    }
    public void modifyNotice(Notice notice){
        userNoticeMapper.modifyNotice(notice);
    }
    public Notice getNoticeInfoByCode(String noticeBoardCode){
        Notice noticeInfo = userNoticeMapper.getNoticeInfoByCode(noticeBoardCode);
        return noticeInfo;
    }

    public void removeCheckedNotice(List<String> valueArr){
        for(int i = 0; i < valueArr.size(); i++){
            userNoticeMapper.removeNoticeByNoticeCode(valueArr.get(i));
        }
    }
}

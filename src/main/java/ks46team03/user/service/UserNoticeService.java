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

    public List<Notice> getNoticeList(Map<String,Object> paramMap){
        List<Notice> noticeList = userNoticeMapper.getNoticeList((paramMap));
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
}

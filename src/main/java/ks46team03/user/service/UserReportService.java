package ks46team03.user.service;


import ks46team03.dto.Report;
import ks46team03.user.mapper.UserMemberMapper;
import ks46team03.user.mapper.UserReportMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class UserReportService {
    private final UserReportMapper userReportMapper;
    private final UserMemberMapper userMemberMapper;

    public UserReportService(UserReportMapper userReportMapper, UserMemberMapper userMemberMapper) {
        this.userReportMapper = userReportMapper;
        this.userMemberMapper = userMemberMapper;
    }

    public List<Report> getReportList(Map<String,Object> paramMap){
        List<Report> reportList = userReportMapper.getReportList(paramMap);
        return reportList;
    }

    public int addReport(Report report) {
        int result = userReportMapper.addReport(report);
        return result;
    }

    public void removeReport(String reportBoardCode){
        userReportMapper.removeReportByReportCode(reportBoardCode);
    }

    public void modifyReport(Report report){
        userReportMapper.modifyReport(report);
    }
    public Report getReportInfoByCode(String reportBoardCode){
        Report reportInfo = userReportMapper.getReportInfoByCode(reportBoardCode);
        return reportInfo;
    }

}


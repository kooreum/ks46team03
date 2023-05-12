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

    public List<Report> getReportList(Map<String,Object> paramMap, String searchKey, String searchValue){

        if (searchKey != null) {
            switch (searchKey) {
                case "memberId":
                    searchKey = "r.member_id";
                    break;
                case "reportTypeCode":
                    searchKey = "r.report_type_code";
                    break;
                default:
                    searchKey = "r.report_board_code";
                    break;
            }
        }
        List<Report> reportList = userReportMapper.getReportList(paramMap, searchKey, searchValue);
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

    public void updateReportState(String reportBoardCode, String reportStateCode) {
        userReportMapper.updateReportState(reportBoardCode, reportStateCode);
    }

}


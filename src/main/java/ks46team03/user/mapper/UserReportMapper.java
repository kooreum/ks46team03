package ks46team03.user.mapper;

import ks46team03.dto.Inquiry;
import ks46team03.dto.Report;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserReportMapper {

 /*

    // 주문상품삭제
    public int removeOrderByGoodsCode(String goodsCode); */

    // 신고글 수정
    public int modifyReport(Report report);

    // 특정 신고글 조회
    public Report getReportInfoByCode(String reportBoardCode);

    // 특정 신고글 게시자 여부 조회
    public boolean isPosterByReportBoardCode(String memberId, String reportBoardCode);

    // 신고삭제
    public int removeReportByReportCode(String reportBoardCode);

    // 신고목록조회
    public List<Report> getReportList(Map<String,Object> paramMap);

    // 신고등록
    public int addReport(Report report);
}

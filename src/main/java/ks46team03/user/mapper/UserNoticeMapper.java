package ks46team03.user.mapper;

import ks46team03.dto.Notice;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserNoticeMapper {

 /*

    // 주문상품삭제
    public int removeOrderByGoodsCode(String goodsCode); */

    // 공지글 수정
    public int modifyNotice(Notice notice);

    // 특정 공지글 조회
    public Notice getNoticeInfoByCode(String noticeBoardCode);

    // 특정 공지 게시자 여부 조회
     public boolean isPosterByNoticeCode(String memberId, String noticeBoardCode);

     // 공지삭제
     public int removeNoticeByNoticeCode(String noticeBoardCode);

    // 공지목록조회
    public List<Notice> getNoticeList(Map<String,Object> paramMap);

    // 공지등록
    public int addNotice(Notice notice);
}

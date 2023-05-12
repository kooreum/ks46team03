package ks46team03.user.mapper;

import ks46team03.dto.Inquiry;
import ks46team03.dto.Report;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserInquiryMapper {

 /*

    // 주문상품삭제
    public int removeOrderByGoodsCode(String goodsCode); */

    // 특정 문의 조회
    public Inquiry getInquiryInfoByCode(String inquiryBoardCode);

    // 문의 유형 조회
    public List<Map<String, String>> getInquiryTypeList();

    // 특정상품 판매자 여부 조회
    public boolean isPosterByInquiryBoardCode(String memberId, String inquiryBoardCode);

    // 문의삭제
    public int removeInquiryByInquiryCode(String inquiryCode);

    // 문의수정
    public int modifyInquiry(Inquiry inquiry);

    // 문의사항목록조회
    public List<Inquiry> getInquiryList(Map<String,Object> paramMap, String searchKey, String searchValue);

    // 문의사항등록
    public int addInquiry(Inquiry inquiry);
}

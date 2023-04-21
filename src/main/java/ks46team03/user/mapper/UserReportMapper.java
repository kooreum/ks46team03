package ks46team03.user.mapper;

import ks46team03.dto.Inquiry;
import ks46team03.dto.Report;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserReportMapper {

 /*   // 상품삭제
    public int removeGoodsByGoodsCode(String goodsCode);

    // 주문상품삭제
    public int removeOrderByGoodsCode(String goodsCode);

    // 상품수정
    public int modifyGoods(Goods goods);

    // 특정상품 판매자 여부 조회
    public boolean isSellerByGoodsCode(String memberId, String goodsCode);

    // 특정 상품조회
    public Goods getGoodsInfoByCode(String goodsCode);*/

    // 공지목록조회
    public List<Report> getReportList(Map<String,Object> paramMap);

    // 문의등록
    public int addInquiry(Inquiry inquiry);
}

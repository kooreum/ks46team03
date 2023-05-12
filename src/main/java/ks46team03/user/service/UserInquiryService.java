package ks46team03.user.service;


import ks46team03.dto.Inquiry;
import ks46team03.user.mapper.UserInquiryMapper;
import ks46team03.user.mapper.UserMemberMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class UserInquiryService {
    private final UserInquiryMapper userInquiryMapper;
    private final UserMemberMapper userMemberMapper;

    public UserInquiryService(UserInquiryMapper userInquiryMapper, UserMemberMapper userMemberMapper) {
        this.userInquiryMapper = userInquiryMapper;
        this.userMemberMapper = userMemberMapper;
    }

    public List<Inquiry> getInquiryList(Map<String,Object> paramMap, String searchKey, String searchValue){

        if (searchKey != null) {
            switch (searchKey) {
                case "memberId":
                    searchKey = "i.member_id";
                    break;
                case "inquiryBoardCode":
                    searchKey = "i.inquiry_board_code";
                    break;
                case "inquiryTypeCode":
                    searchKey = "i.inquiry_type_code";
                    break;
                default:
                    searchKey = "i.inquiry_board_title";
                    break;
            }
        }

        List<Inquiry> inquiryList = userInquiryMapper.getInquiryList(paramMap, searchKey, searchValue);
        return inquiryList;
    }

    public int addInquiry(Inquiry inquiry) {
        int result = userInquiryMapper.addInquiry(inquiry);
        return result;
    }

    public void removeInquiry(String inquiryBoardCode){
        userInquiryMapper.removeInquiryByInquiryCode(inquiryBoardCode);
    }
    public void modifyInquiry(Inquiry inquiry){
        userInquiryMapper.modifyInquiry(inquiry);
    }

    public Inquiry getInquiryInfoByCode(String inquiryBoardCode){
        Inquiry inquiryInfo = userInquiryMapper.getInquiryInfoByCode(inquiryBoardCode);
        return inquiryInfo;
    }

    /**
     * 상품 삭제
     * @param
     */
    public void removeCheckedInquiry(List<String> valueArr) {
        for (int i = 0; i < valueArr.size(); i++) {
            userInquiryMapper.removeInquiryByInquiryCode(valueArr.get(i));
        }
    }

}

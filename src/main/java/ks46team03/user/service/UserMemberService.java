package ks46team03.user.service;

import ks46team03.dto.Member;
import ks46team03.dto.MemberLevel;
import ks46team03.user.mapper.UserMemberMapper;
import org.apache.logging.log4j.Logger;
import org.slf4j.ILoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// @Transactional 클래스 가지고 있는 메소드 전체에 트랜잭션 처리
@Service
@Transactional
public class UserMemberService {
    // DI 생성자 메소드 주입방식
    private final UserMemberMapper userMemberMapper;

    public UserMemberService(UserMemberMapper userMemberMapper) {
        this.userMemberMapper = userMemberMapper;
    }


    /**
     * 회원정보 확인(로그인)
     */
    public Map<String, Object> loginCheck(String memberId, String memberPw) {
        Map<String, Object> loginResultMap = new HashMap<String, Object>();
        Member member = userMemberMapper.getMemberInfoById(memberId);
        boolean loginCheck = false;
        if (member != null) {
            String checkPw = member.getMemberPw();
            if (memberPw.equals(checkPw)) {
                loginCheck = true;
                loginResultMap.put("memberInfo", member);
            }
        }
        loginResultMap.put("loginCheck", loginCheck);
        return loginResultMap;
    }

    /**
     * 회원정보수정
     * @param member
     */
    public void modifyMember(Member member) {
        userMemberMapper.modifyMember(member);
    }

    /**
     * 특정회원조회
     * @param memberId
     * @return
     */
    public Member getMemberInfoById(String memberId) {
        Member memberInfo = userMemberMapper.getMemberInfoById(memberId);
        return memberInfo;
    }

    /**
     *  회원가입
     * @param member
     * @return
     */
    public int addMember(Member member) {
        int result = userMemberMapper.addMember(member);
        return result;
    }

    public List<MemberLevel> getMemberLevelList() {
        List<MemberLevel> memberLevelList =
                userMemberMapper.getMemberLevelList();
        return memberLevelList;
    }

    /**
     *  회원목록 조회
     * @return List<Member>
     */
    public List<Member> getMemberList(String searchKey, String searchValue) {
        List<Member> memberList = userMemberMapper.getMemberList(searchKey, searchValue);


        if (searchKey != null) {
            switch (searchKey) {
                case "memberId":
                    searchKey = "m.member_id";
                    break;
                case "memberName":
                    searchKey = "m.member_name";
                    break;
                case "memberEmail":
                    searchKey = "m.member_email";
                    break;
                default:
                    searchKey = "l.level_num";
                    break;
            }
        }
        return memberList;
    }

    /**
     * 회원탈퇴
     */
    public void removeMember(String memberId) {
        Member memberInfo = userMemberMapper.getMemberInfoById(memberId);
        if (memberInfo != null) {
            String memberLevel = memberInfo.getLevelNum();
//            switch (memberLevel) {
//                case "2":
//                    //판매자가 등록한 상품 주문 이력 삭제
//                    memberMapper.removeOrderBySellerId(memberId);
//                    //판매자가 등록한 상품 삭제
//                    memberMapper.removeGoodsBySellerId(memberId);
//                    break;
//                case "3":
//                    //구매자가 주문한 이력 삭제
//                    memberMapper.removeOrderById(memberId);
//                    break;
//            }
            //로그인 이력 삭제
            userMemberMapper.removeLoginById(memberId);
            //회원탈퇴
            userMemberMapper.removeMemberById(memberId);
        }
    }
}

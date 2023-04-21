package ks46team03.admin.service;

import ks46team03.admin.dto.Member;
import ks46team03.admin.dto.MemberLevel;
import ks46team03.admin.mapper.MemberMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

// @Transactional 클래스 가지고 있는 메소드 전체에 트랜잭션 처리
@Service
@Transactional
public class MemberService {
    // DI 생성자 메소드 주입방식
    private final MemberMapper memberMapper;

    public MemberService(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    /**
     * 회원탈퇴
     */
    public void removeMember(String memberId) {
        Member memberInfo = memberMapper.getMemberInfoById(memberId);

        if(memberInfo != null) {
            String memberLevel = memberInfo.getLevelNum();
            /*
            switch (memberLevel) {
                case"2" :
                    //판매자가 등록한 상품 주문 이력 삭제
                    memberMapper.removeOrderBySellerId(memberId);
                    //판매자가 등록한 상품 삭제
                    memberMapper.removeGoodsBySellerId(memberId);
                    break;
                case "3" :
                    //구매자가 주문한 이력 삭제
                    memberMapper.removeOrderById(memberId);
                    break;
            }
            */
            //로그인 이력 삭제
            memberMapper.removeLoginById(memberId);
            //회원탈퇴
            memberMapper.removeMemberById(memberId);
        }

    }

    /**
     * 회원정보수정
     * @param member
     */
    public void modifyMember(Member member) {
        memberMapper.modifyMember(member);
    }

    /**
     * 특정회원조회
     * @param memberId
     * @return
     */
    public Member getMemberInfoById(String memberId) {
        Member memberInfo = memberMapper.getMemberInfoById(memberId);
        return memberInfo;
    }

    /**
     *  회원가입
     * @param member
     * @return
     */
    public int addMember(Member member) {
        int result = memberMapper.addMember(member);
        return result;
    }

    public List<MemberLevel> getMemberLevelList() {
        List<MemberLevel> memberLevelList =
                memberMapper.getMemberLevelList();
        return memberLevelList;
    }

    /**
     *  회원목록 조회
     * @return List<Member>
     */
    public List<Member> getMemberList() {
        List<Member> memberList = memberMapper.getMemberList();

        if(memberList != null) {
            memberList.forEach(member -> {
                String levelNum = member.getLevelNum();
                switch (levelNum) {
                    case "member_code_1":
                        member.setLevelNum("관리자");
                        break;
                    case "member_code_2":
                        member.setLevelNum("일반회원");
                        break;
                    default:
                        member.setLevelNum("비회원");
                        break;
                }
            });
        }

        return memberList;
    }
}

package ks46team03.admin.mapper;

import ks46team03.dto.Member;
import ks46team03.dto.MemberLevel;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;


@Mapper
public interface MemberMapper {
    // 로그인 이력 삭제
    public int removeLoginById(String memberId);
    // 회원탈퇴
    public int removeMemberById(String memberId);
    // 회원수정
    public int modifyMember(Member member);
    // 특정회원조회
    public Member getMemberInfoById(String memberId);
    // 회원가입
    public int addMember(Member member);
    // 회원아이디 중복체크
    public boolean idCheck(String memberId);
    // 회원의 목록 조회
    public List<Member> getMemberList();
    // 회원등급 조회
    public List<MemberLevel> getMemberLevelList();
}

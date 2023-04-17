package ks46team03.dto;

public class Member {
    private String memberId;
    private String levelNum;
    private String memberPw;
    private String memberName;
    private String memberGender;
    private String memberBirth;
    private String memberDiet;
    private String memberEmail;
    private String memberPhone;
    private String memberNickname;
    private String memberAllergy;
    private String memberRemove;
    private String joinDate;

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getLevelNum() {
        return levelNum;
    }

    public void setLevelNum(String levelNum) {
        this.levelNum = levelNum;
    }

    public String getMemberPw() {
        return memberPw;
    }

    public void setMemberPw(String memberPw) {
        this.memberPw = memberPw;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberGender() {
        return memberGender;
    }

    public void setMemberGender(String memberGender) {
        this.memberGender = memberGender;
    }

    public String getMemberBirth() {
        return memberBirth;
    }

    public void setMemberBirth(String memberBirth) {
        this.memberBirth = memberBirth;
    }

    public String getMemberDiet() {
        return memberDiet;
    }

    public void setMemberDiet(String memberDiet) {
        this.memberDiet = memberDiet;
    }

    public String getMemberEmail() {
        return memberEmail;
    }

    public void setMemberEmail(String memberEmail) {
        this.memberEmail = memberEmail;
    }

    public String getMemberPhone() {
        return memberPhone;
    }

    public void setMemberPhone(String memberPhone) {
        this.memberPhone = memberPhone;
    }

    public String getMemberNickname() {
        return memberNickname;
    }

    public void setMemberNickname(String memberNickname) {
        this.memberNickname = memberNickname;
    }

    public String getMemberAllergy() {
        return memberAllergy;
    }

    public void setMemberAllergy(String memberAllergy) {
        this.memberAllergy = memberAllergy;
    }

    public String getMemberRemove() {
        return memberRemove;
    }

    public void setMemberRemove(String memberRemove) {
        this.memberRemove = memberRemove;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberId='" + memberId + '\'' +
                ", levelNum='" + levelNum + '\'' +
                ", memberPw='" + memberPw + '\'' +
                ", memberName='" + memberName + '\'' +
                ", memberGender='" + memberGender + '\'' +
                ", memberBirth='" + memberBirth + '\'' +
                ", memberDiet='" + memberDiet + '\'' +
                ", memberEmail='" + memberEmail + '\'' +
                ", memberPhone='" + memberPhone + '\'' +
                ", memberNickname='" + memberNickname + '\'' +
                ", memberAllergy='" + memberAllergy + '\'' +
                ", memberRemove='" + memberRemove + '\'' +
                ", joinDate='" + joinDate + '\'' +
                '}';
    }
}
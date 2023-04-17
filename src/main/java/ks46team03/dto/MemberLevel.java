package ks46team03.dto;

public class MemberLevel {
    private String levelNum;
    private String memberLevel;
    private String lastDate;

    public String getLevelNum() {
        return levelNum;
    }

    public void setLevelNum(String levelNum) {
        this.levelNum = levelNum;
    }

    public String getMemberLevel() {
        return memberLevel;
    }

    public void setMemberLevel(String memberLevel) {
        this.memberLevel = memberLevel;
    }

    public String getLastDate() {
        return lastDate;
    }

    public void setLastDate(String lastDate) {
        this.lastDate = lastDate;
    }

    @Override
    public String toString() {
        return "MemberLevel{" +
                "levelNum=" + levelNum +
                ", memberLevel='" + memberLevel + '\'' +
                ", lastDate='" + lastDate + '\'' +
                '}';
    }
}

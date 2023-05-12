package ks46team03.dto;

public class BannedWords {
    private String bannedWordsCode;

    private String bannedWordsList;

    private String bannedWordsRegTime;

    private String memberId;

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getBannedWordsCode() {
        return bannedWordsCode;
    }

    public void setBannedWordsCode(String bannedWordsCode) {
        this.bannedWordsCode = bannedWordsCode;
    }

    public String getBannedWordsList() {
        return bannedWordsList;
    }

    public void setBannedWordsList(String bannedWordsList) {
        this.bannedWordsList = bannedWordsList;
    }

    public String getBannedWordsRegTime() {
        return bannedWordsRegTime;
    }

    public void setBannedWordsRegTime(String bannedWordsRegTime) {
        this.bannedWordsRegTime = bannedWordsRegTime;
    }

    @Override
    public String toString() {
        return "BannedWords{" +
                "bannedWordsCode='" + bannedWordsCode + '\'' +
                ", bannedWordsList='" + bannedWordsList + '\'' +
                ", bannedWordsRegTime='" + bannedWordsRegTime + '\'' +
                ", memberId='" + memberId + '\'' +
                '}';
    }
}

package ks46team03.dto;

public class BannedWords {
    private String bannedWordsCode;

    private String bannedWordList;

    public String getBannedWordsCode() {
        return bannedWordsCode;
    }

    public void setBannedWordsCode(String bannedWordsCode) {
        this.bannedWordsCode = bannedWordsCode;
    }

    public String getBannedWordList() {
        return bannedWordList;
    }

    public void setBannedWordList(String bannedWordList) {
        this.bannedWordList = bannedWordList;
    }

    @Override
    public String toString() {
        return "BannedWords{" +
                "bannedWordsCode='" + bannedWordsCode + '\'' +
                ", bannedWordList='" + bannedWordList + '\'' +
                '}';
    }
}

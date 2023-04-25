package ks46team03.dto;

public class Notice {
    private String noticeBoardCode;
    private String memberId;
    private String noticeBoardTitle;
    private String noticeBoardContent;
    private String noticeBoardRegTime;

    public String getNoticeBoardCode() {
        return noticeBoardCode;
    }

    public void setNoticeBoardCode(String noticeBoardCode) {
        this.noticeBoardCode = noticeBoardCode;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getNoticeBoardTitle() {
        return noticeBoardTitle;
    }

    public void setNoticeBoardTitle(String noticeBoardTitle) {
        this.noticeBoardTitle = noticeBoardTitle;
    }

    public String getNoticeBoardContent() {
        return noticeBoardContent;
    }

    public void setNoticeBoardContent(String noticeBoardContent) {
        this.noticeBoardContent = noticeBoardContent;
    }

    public String getNoticeBoardRegTime() {
        return noticeBoardRegTime;
    }

    public void setNoticeBoardRegTime(String noticeBoardRegTime) {
        this.noticeBoardRegTime = noticeBoardRegTime;
    }

    @Override
    public String toString() {
        return "Notice{" +
                "noticeBoardCode='" + noticeBoardCode + '\'' +
                ", memberId='" + memberId + '\'' +
                ", noticeBoardTitle='" + noticeBoardTitle + '\'' +
                ", noticeBoardContent='" + noticeBoardContent + '\'' +
                ", noticeBoardRegTime='" + noticeBoardRegTime + '\'' +
                '}';
    }
}

package ks46team03.dto;

public class Board {
    private String noticeBoardCode;
    private String memberId;
    private String noticeBoardTitle;
    private String noticeBoardContent;
    private String noticeBoardRegTime;
    private String reportBoardCode;
    private String reportTypeCode;
    private String recipeCode;
    private String reportStateCode;
    private String reportInfoBoardContent;
    private String reportDatetime;

    @Override
    public String toString() {
        return "Board{" +
                "noticeBoardCode='" + noticeBoardCode + '\'' +
                ", memberId='" + memberId + '\'' +
                ", noticeBoardTitle='" + noticeBoardTitle + '\'' +
                ", noticeBoardContent='" + noticeBoardContent + '\'' +
                ", noticeBoardRegTime='" + noticeBoardRegTime + '\'' +
                ", reportBoardCode='" + reportBoardCode + '\'' +
                ", reportTypeCode='" + reportTypeCode + '\'' +
                ", recipeCode='" + recipeCode + '\'' +
                ", reportStateCode='" + reportStateCode + '\'' +
                ", reportInfoBoardContent='" + reportInfoBoardContent + '\'' +
                ", reportDatetime='" + reportDatetime + '\'' +
                '}';
    }

    public String getReportBoardCode() {
        return reportBoardCode;
    }

    public void setReportBoardCode(String reportBoardCode) {
        this.reportBoardCode = reportBoardCode;
    }

    public String getReportTypeCode() {
        return reportTypeCode;
    }

    public void setReportTypeCode(String reportTypeCode) {
        this.reportTypeCode = reportTypeCode;
    }

    public String getRecipeCode() {
        return recipeCode;
    }

    public void setRecipeCode(String recipeCode) {
        this.recipeCode = recipeCode;
    }

    public String getReportStateCode() {
        return reportStateCode;
    }

    public void setReportStateCode(String reportStateCode) {
        this.reportStateCode = reportStateCode;
    }

    public String getReportInfoBoardContent() {
        return reportInfoBoardContent;
    }

    public void setReportInfoBoardContent(String reportInfoBoardContent) {
        this.reportInfoBoardContent = reportInfoBoardContent;
    }

    public String getReportDatetime() {
        return reportDatetime;
    }

    public void setReportDatetime(String reportDatetime) {
        this.reportDatetime = reportDatetime;
    }

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

}

package ks46team03.dto;

public class Report {

    private String reportBoardCode;
    private String memberId;
    private String reportBoardTitle;
    private String reportTypeCode;
    private String recipeCode;
    private String reportStateCode;
    private String reportInfoBoardContent;
    private String reportDatetime;

    public String getReportBoardCode() {
        return reportBoardCode;
    }

    public void setReportBoardCode(String reportBoardCode) {
        this.reportBoardCode = reportBoardCode;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getReportBoardTitle() {
        return reportBoardTitle;
    }

    public void setReportBoardTitle(String reportBoardTitle) {
        this.reportBoardTitle = reportBoardTitle;
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

    @Override
    public String toString() {
        return "Report{" +
                "reportBoardCode='" + reportBoardCode + '\'' +
                ", memberId='" + memberId + '\'' +
                ", reportBoardTitle='" + reportBoardTitle + '\'' +
                ", reportTypeCode='" + reportTypeCode + '\'' +
                ", recipeCode='" + recipeCode + '\'' +
                ", reportStateCode='" + reportStateCode + '\'' +
                ", reportInfoBoardContent='" + reportInfoBoardContent + '\'' +
                ", reportDatetime='" + reportDatetime + '\'' +
                '}';
    }
}
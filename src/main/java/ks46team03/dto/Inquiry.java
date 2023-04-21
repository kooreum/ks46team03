package ks46team03.dto;

public class Inquiry {

    private String inquiryBoardCode;
    private String memberId;
    private String inquiryTypeCode;
    private String inquiryBoardTitle;
    private String inquiryBoardContent;
    private String inquiryBoardRegTime;

    public String getInquiryBoardCode() {
        return inquiryBoardCode;
    }

    public void setInquiryBoardCode(String inquiryBoardCode) {
        this.inquiryBoardCode = inquiryBoardCode;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getInquiryTypeCode() {
        return inquiryTypeCode;
    }

    public void setInquiryTypeCode(String inquiryTypeCode) {
        this.inquiryTypeCode = inquiryTypeCode;
    }

    public String getInquiryBoardTitle() {
        return inquiryBoardTitle;
    }

    public void setInquiryBoardTitle(String inquiryBoardTitle) {
        this.inquiryBoardTitle = inquiryBoardTitle;
    }

    public String getInquiryBoardContent() {
        return inquiryBoardContent;
    }

    public void setInquiryBoardContent(String inquiryBoardContent) {
        this.inquiryBoardContent = inquiryBoardContent;
    }

    public String getInquiryBoardRegTime() {
        return inquiryBoardRegTime;
    }

    public void setInquiryBoardRegTime(String inquiryBoardRegTime) {
        this.inquiryBoardRegTime = inquiryBoardRegTime;
    }

    @Override
    public String toString() {
        return "Inquiry{" +
                "inquiryBoardCode='" + inquiryBoardCode + '\'' +
                ", memberId='" + memberId + '\'' +
                ", inquiryTypeCode='" + inquiryTypeCode + '\'' +
                ", inquiryBoardTitle='" + inquiryBoardTitle + '\'' +
                ", inquiryBoardContent='" + inquiryBoardContent + '\'' +
                ", inquiryBoardRegTime='" + inquiryBoardRegTime + '\'' +
                '}';
    }
}
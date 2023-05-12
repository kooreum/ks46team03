package ks46team03.dto;

public class MessageManagement {
    private String messageManagementCode;
    private String messageCode;
    private String memberId;
    private String memberId2;
    private String messageDetails;
    private String messageSendTime;
    private String messageDeleteTime;

    public String getMessageManagementCode() {
        return messageManagementCode;
    }

    public void setMessageManagementCode(String messageManagementCode) {
        this.messageManagementCode = messageManagementCode;
    }

    public String getMessageCode() {
        return messageCode;
    }

    public void setMessageCode(String messageCode) {
        this.messageCode = messageCode;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getMemberId2() {
        return memberId2;
    }

    public void setMemberId2(String memberId2) {
        this.memberId2 = memberId2;
    }

    public String getMessageDetails() {
        return messageDetails;
    }

    public void setMessageDetails(String messageDetails) {
        this.messageDetails = messageDetails;
    }

    public String getMessageSendTime() {
        return messageSendTime;
    }

    public void setMessageSendTime(String messageSendTime) {
        this.messageSendTime = messageSendTime;
    }

    public String getMessageDeleteTime() {
        return messageDeleteTime;
    }

    public void setMessageDeleteTime(String messageDeleteTime) {
        this.messageDeleteTime = messageDeleteTime;
    }


    @Override
    public String toString() {
        return "MessageManagement{" +
                "messageManagementCode='" + messageManagementCode + '\'' +
                ", messageCode='" + messageCode + '\'' +
                ", memberId='" + memberId + '\'' +
                ", memberId2='" + memberId2 + '\'' +
                ", messageDetails='" + messageDetails + '\'' +
                ", messageSendTime='" + messageSendTime + '\'' +
                ", messageDeleteTime='" + messageDeleteTime + '\'' +
                '}';
    }
}

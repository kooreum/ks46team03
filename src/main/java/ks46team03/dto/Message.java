package ks46team03.dto;

public class Message {
    private String messageCode;
    private String messageDetails;

    public String getMessageCode() {
        return messageCode;
    }

    public void setMessageCode(String messageCode) {
        this.messageCode = messageCode;
    }

    public String getMessageDetails() {
        return messageDetails;
    }

    public void setMessageDetails(String messageDetails) {
        this.messageDetails = messageDetails;
    }

    @Override
    public String toString() {
        return "Message{" +
                "messageCode='" + messageCode + '\'' +
                ", messageDetails='" + messageDetails + '\'' +
                '}';
    }
}

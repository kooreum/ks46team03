package ks46team03.dto;

public class DayCalorie {

    private String oneDayCalCode;
    private String memberId;
    private String dayMaxCalorie;
    private String unit;

    public String getOneDayCalCode() {
        return oneDayCalCode;
    }

    public void setOneDayCalCode(String oneDayCalCode) {
        this.oneDayCalCode = oneDayCalCode;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getDayMaxCalorie() {
        return dayMaxCalorie;
    }

    public void setDayMaxCalorie(String dayMaxCalorie) {
        this.dayMaxCalorie = dayMaxCalorie;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "DayCalorie{" +
                "oneDayCalCode='" + oneDayCalCode + '\'' +
                ", memberId='" + memberId + '\'' +
                ", dayMaxCalorie='" + dayMaxCalorie + '\'' +
                ", unit='" + unit + '\'' +
                '}';
    }
}

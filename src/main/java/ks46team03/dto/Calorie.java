package ks46team03.dto;

public class Calorie {

    private String oneMealCalCode;
    private String memberId;
    private String mealMaxCalorie;
    private String unit;

    public String getOneMealCalCode() {
        return oneMealCalCode;
    }

    public void setOneMealCalCode(String oneMealCalCode) {
        this.oneMealCalCode = oneMealCalCode;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getMealMaxCalorie() {
        return mealMaxCalorie;
    }

    public void setMealMaxCalorie(String mealMaxCalorie) {
        this.mealMaxCalorie = mealMaxCalorie;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "Calorie{" +
                "oneMealCalCode='" + oneMealCalCode + '\'' +
                ", memberId='" + memberId + '\'' +
                ", mealMaxCalorie='" + mealMaxCalorie + '\'' +
                ", unit='" + unit + '\'' +
                '}';
    }
}

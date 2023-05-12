package ks46team03.dto;

public class Allergy {
    private String allergyCode;
    private String memberId;
    private String ingredientCode;
    private String ingredientName;

    public String getAllergyCode() {
        return allergyCode;
    }

    public void setAllergyCode(String allergyCode) {
        this.allergyCode = allergyCode;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getIngredientCode() {
        return ingredientCode;
    }

    public void setIngredientCode(String ingredientCode) {
        this.ingredientCode = ingredientCode;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    @Override
    public String toString() {
        return "Allergy{" +
                "allergyCode='" + allergyCode + '\'' +
                ", memberId='" + memberId + '\'' +
                ", ingredientCode='" + ingredientCode + '\'' +
                ", ingredientName='" + ingredientName + '\'' +
                '}';
    }
}

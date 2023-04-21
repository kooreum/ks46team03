package ks46team03.dto;

public class Ingredient {
    private String ingredientCode;
    private String memberId;
    private String ingredientCategoryCode;
    private String ingredientName;
    private String regTime;
    private String updateTime;
    private String deleteTime;

    public String getIngredientCode() {
        return ingredientCode;
    }

    public void setIngredientCode(String ingredientCode) {
        this.ingredientCode = ingredientCode;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getIngredientCategoryCode() {
        return ingredientCategoryCode;
    }

    public void setIngredientCategoryCode(String ingredientCategoryCode) {
        this.ingredientCategoryCode = ingredientCategoryCode;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public String getRegTime() {
        return regTime;
    }

    public void setRegTime(String regTime) {
        this.regTime = regTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(String deleteTime) {
        this.deleteTime = deleteTime;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "ingredientCode='" + ingredientCode + '\'' +
                ", memberId='" + memberId + '\'' +
                ", ingredientCategoryCode='" + ingredientCategoryCode + '\'' +
                ", ingredientName='" + ingredientName + '\'' +
                ", regTime='" + regTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", deleteTime='" + deleteTime + '\'' +
                '}';
    }
}

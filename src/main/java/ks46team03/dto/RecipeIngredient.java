package ks46team03.dto;

import java.util.List;

public class RecipeIngredient {
    private String recipeNumber;
    private String recipeCode;
    private String ingredientCode;
    private String quantity;
    private String gram;
    private String memberId;
    private String regTime;

    public String getRecipeNumber() {
        return recipeNumber;
    }

    public void setRecipeNumber(String recipeNumber) {
        this.recipeNumber = recipeNumber;
    }

    public String getRecipeCode() {
        return recipeCode;
    }

    public void setRecipeCode(String recipeCode) {
        this.recipeCode = recipeCode;
    }

    public String getIngredientCode() {
        return ingredientCode;
    }

    public void setIngredientCode(String ingredientCode) {
        this.ingredientCode = ingredientCode;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getGram() {
        return gram;
    }

    public void setGram(String gram) {
        this.gram = gram;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getRegTime() {
        return regTime;
    }

    public void setRegTime(String regTime) {
        this.regTime = regTime;
    }

    @Override
    public String toString() {
        return "RecipeIngredient{" +
                "recipeNumber='" + recipeNumber + '\'' +
                ", recipeCode='" + recipeCode + '\'' +
                ", ingredientCode='" + ingredientCode + '\'' +
                ", quantity='" + quantity + '\'' +
                ", gram='" + gram + '\'' +
                ", memberId='" + memberId + '\'' +
                ", regTime='" + regTime + '\'' +
                '}';
    }
}

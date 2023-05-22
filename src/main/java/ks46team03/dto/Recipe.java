package ks46team03.dto;

import java.util.List;

public class Recipe {
    private String recipeCode;
    private String recipeName;
    private String recipeCategoryCode;
    private String memberId;
    private String recipeCal;
    private String recipeQuantity;
    private String regDate;
    private String updateAt;
    private String fileIdx;
    private String viewCount;
    private String recommendationCount;
    private String recipeUseNumber;
    private String recipeStep1;
    private String recipeStep2;
    private String recipeStep3;

    private List<Recipe> viewRank;
    private List<String> ingredientCodeList;
    private List<RecipeIngredient> recipeIngredients;

    public List<Recipe> getViewRank() {
        return viewRank;
    }

    public void setViewRank(List<Recipe> viewRank) {
        this.viewRank = viewRank;
    }

    public String getRecipeStep1() {
        return recipeStep1;
    }

    public void setRecipeStep1(String recipeStep1) {
        this.recipeStep1 = recipeStep1;
    }

    public String getRecipeStep2() {
        return recipeStep2;
    }

    public void setRecipeStep2(String recipeStep2) {
        this.recipeStep2 = recipeStep2;
    }

    public String getRecipeStep3() {
        return recipeStep3;
    }

    public void setRecipeStep3(String recipeStep3) {
        this.recipeStep3 = recipeStep3;
    }

    public String getRecipeCode() {
        return recipeCode;
    }

    public void setRecipeCode(String recipeCode) {
        this.recipeCode = recipeCode;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public String getRecipeCategoryCode() {
        return recipeCategoryCode;
    }

    public void setRecipeCategoryCode(String recipeCategoryCode) {
        this.recipeCategoryCode = recipeCategoryCode;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getRecipeCal() {
        return recipeCal;
    }

    public void setRecipeCal(String recipeCal) {
        this.recipeCal = recipeCal;
    }

    public String getRecipeQuantity() {
        return recipeQuantity;
    }

    public void setRecipeQuantity(String recipeQuantity) {
        this.recipeQuantity = recipeQuantity;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public String getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(String updateAt) {
        this.updateAt = updateAt;
    }

    public String getFileIdx() {
        return fileIdx;
    }

    public void setFileIdx(String fileIdx) {
        this.fileIdx = fileIdx;
    }

    public String getViewCount() {
        return viewCount;
    }

    public void setViewCount(String viewCount) {
        this.viewCount = viewCount;
    }

    public String getRecommendationCount() {
        return recommendationCount;
    }

    public void setRecommendationCount(String recommendationCount) {
        this.recommendationCount = recommendationCount;
    }

    public String getRecipeUseNumber() {
        return recipeUseNumber;
    }

    public void setRecipeUseNumber(String recipeUseNumber) {
        this.recipeUseNumber = recipeUseNumber;
    }

    public List<String> getIngredientCodeList() {
        return ingredientCodeList;
    }

    public void setIngredientCodeList(List<String> ingredientCodeList) {
        this.ingredientCodeList = ingredientCodeList;
    }

    public List<RecipeIngredient> getRecipeIngredients() {
        return recipeIngredients;
    }

    public void setRecipeIngredients(List<RecipeIngredient> recipeIngredients) {
        this.recipeIngredients = recipeIngredients;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "recipeCode='" + recipeCode + '\'' +
                ", recipeName='" + recipeName + '\'' +
                ", recipeCategoryCode='" + recipeCategoryCode + '\'' +
                ", memberId='" + memberId + '\'' +
                ", recipeCal='" + recipeCal + '\'' +
                ", recipeQuantity='" + recipeQuantity + '\'' +
                ", regDate='" + regDate + '\'' +
                ", updateAt='" + updateAt + '\'' +
                ", fileIdx='" + fileIdx + '\'' +
                ", viewCount='" + viewCount + '\'' +
                ", recommendationCount='" + recommendationCount + '\'' +
                ", recipeUseNumber='" + recipeUseNumber + '\'' +
                ", recipeStep1='" + recipeStep1 + '\'' +
                ", recipeStep2='" + recipeStep2 + '\'' +
                ", recipeStep3='" + recipeStep3 + '\'' +
                ", viewRank=" + viewRank +
                ", ingredientCodeList=" + ingredientCodeList +
                ", recipeIngredients=" + recipeIngredients +
                '}';
    }
}

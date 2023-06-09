package ks46team03.dto;

public class Bookmark {
    private String recipeCode;
    private String recipeName;
    private String recipeCategoryCode;
    private String memberId;
    private String recipeCal;
    private String recipeQuantity;
    private String recipeBookmarksRegDate;
    private String updateAt;
    private String imageUrl;
    private String viewCount;
    private String recommendationCount;
    private String recipeUseNumber;
    private String recipeBookmarksCode;

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

    public String getRecipeBookmarksRegDate() {
        return recipeBookmarksRegDate;
    }

    public void setRecipeBookmarksRegDate(String recipeBookmarksRegDate) {
        this.recipeBookmarksRegDate = recipeBookmarksRegDate;
    }

    public String getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(String updateAt) {
        this.updateAt = updateAt;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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

    public String getRecipeBookmarksCode() {
        return recipeBookmarksCode;
    }

    public void setRecipeBookmarksCode(String recipeBookmarksCode) {
        this.recipeBookmarksCode = recipeBookmarksCode;
    }

    @Override
    public String toString() {
        return "Bookmark{" +
                "recipeCode='" + recipeCode + '\'' +
                ", recipeName='" + recipeName + '\'' +
                ", recipeCategoryCode='" + recipeCategoryCode + '\'' +
                ", memberId='" + memberId + '\'' +
                ", recipeCal='" + recipeCal + '\'' +
                ", recipeQuantity='" + recipeQuantity + '\'' +
                ", recipeBookmarksRegDate='" + recipeBookmarksRegDate + '\'' +
                ", updateAt='" + updateAt + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", viewCount='" + viewCount + '\'' +
                ", recommendationCount='" + recommendationCount + '\'' +
                ", recipeUseNumber='" + recipeUseNumber + '\'' +
                ", recipeBookmarksCode='" + recipeBookmarksCode + '\'' +
                '}';
    }
}

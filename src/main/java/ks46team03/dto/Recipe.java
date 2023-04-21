package ks46team03.dto;

public class Recipe {
    private String recipeCode;
    private String recipeName;
    private String recipeCategoryCode;
    private String memberId;
    private String recipeCal;
    private String recipeQuantity;
    private String regDate;
    private String updateAt;
    private String imageUrl;
    private String viewCount;
    private String recommendationCount;
    private String recipeUseNumber;

    private Member SellerInfo;

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

    public Member getSellerInfo() {
        return SellerInfo;
    }

    public void setSellerInfo(Member sellerInfo) {
        SellerInfo = sellerInfo;
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
                ", imageUrl='" + imageUrl + '\'' +
                ", viewCount='" + viewCount + '\'' +
                ", recommendationCount='" + recommendationCount + '\'' +
                ", recipeUseNumber='" + recipeUseNumber + '\'' +
                ", SellerInfo=" + SellerInfo +
                '}';
    }
}

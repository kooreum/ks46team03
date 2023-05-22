package ks46team03.dto;

public class RecipeCategory {

    public String recipeCategoryCode;
    public String recipeCategory;

    public String getRecipeCategoryCode() {
        return recipeCategoryCode;
    }

    public void setRecipeCategoryCode(String recipeCategoryCode) {
        this.recipeCategoryCode = recipeCategoryCode;
    }

    public String getRecipeCategory() {
        return recipeCategory;
    }

    public void setRecipeCategory(String recipeCategory) {
        this.recipeCategory = recipeCategory;
    }

    @Override
    public String toString() {
        return "RecipeCategory{" +
                "recipeCategoryCode='" + recipeCategoryCode + '\'' +
                ", recipeCategory='" + recipeCategory + '\'' +
                '}';
    }
}

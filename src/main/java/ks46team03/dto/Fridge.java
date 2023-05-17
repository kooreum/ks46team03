package ks46team03.dto;

public class Fridge {
    private String myIngredientCode;
    private String fridgeCode;
    private String myDetailLocationCode;
    private String ingredientCode;
    private String memberId;
    private String ingredientNote;
    private String ingredientPrice;
    private String ea;
    private String useEa;
    private String remainEa;
    private String useTime;
    private String ingredientStatus;
    private String gram;
    private String regTime;
    private String endTime;
    private String expirationDate;
    private String ingredientName;
    private String myDetailLocationName;

    public String getMyIngredientCode() {
        return myIngredientCode;
    }

    public void setMyIngredientCode(String myIngredientCode) {
        this.myIngredientCode = myIngredientCode;
    }

    public String getFridgeCode() {
        return fridgeCode;
    }

    public void setFridgeCode(String fridgeCode) {
        this.fridgeCode = fridgeCode;
    }

    public String getMyDetailLocationCode() {
        return myDetailLocationCode;
    }

    public void setMyDetailLocationCode(String myDetailLocationCode) {
        this.myDetailLocationCode = myDetailLocationCode;
    }

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

    public String getIngredientNote() {
        return ingredientNote;
    }

    public void setIngredientNote(String ingredientNote) {
        this.ingredientNote = ingredientNote;
    }

    public String getIngredientPrice() {
        return ingredientPrice;
    }

    public void setIngredientPrice(String ingredientPrice) {
        this.ingredientPrice = ingredientPrice;
    }

    public String getEa() {
        return ea;
    }

    public void setEa(String ea) {
        this.ea = ea;
    }

    public String getUseEa() {
        return useEa;
    }

    public void setUseEa(String useEa) {
        this.useEa = useEa;
    }

    public String getRemainEa() {
        return remainEa;
    }

    public void setRemainEa(String remainEa) {
        this.remainEa = remainEa;
    }

    public String getUseTime() {
        return useTime;
    }

    public void setUseTime(String useTime) {
        this.useTime = useTime;
    }

    public String getIngredientStatus() {
        return ingredientStatus;
    }

    public void setIngredientStatus(String ingredientStatus) {
        this.ingredientStatus = ingredientStatus;
    }

    public String getGram() {
        return gram;
    }

    public void setGram(String gram) {
        this.gram = gram;
    }

    public String getRegTime() {
        return regTime;
    }

    public void setRegTime(String regTime) {
        this.regTime = regTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public String getMyDetailLocationName() {
        return myDetailLocationName;
    }

    public void setMyDetailLocationName(String myDetailLocationName) {
        this.myDetailLocationName = myDetailLocationName;
    }

    @Override
    public String toString() {
        return "Fridge{" +
                "myIngredientCode='" + myIngredientCode + '\'' +
                ", fridgeCode='" + fridgeCode + '\'' +
                ", myDetailLocationCode='" + myDetailLocationCode + '\'' +
                ", ingredientCode='" + ingredientCode + '\'' +
                ", memberId='" + memberId + '\'' +
                ", ingredientNote='" + ingredientNote + '\'' +
                ", ingredientPrice='" + ingredientPrice + '\'' +
                ", ea='" + ea + '\'' +
                ", useEa='" + useEa + '\'' +
                ", remainEa='" + remainEa + '\'' +
                ", useTime='" + useTime + '\'' +
                ", ingredientStatus='" + ingredientStatus + '\'' +
                ", gram='" + gram + '\'' +
                ", regTime='" + regTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", expirationDate='" + expirationDate + '\'' +
                ", ingredientName='" + ingredientName + '\'' +
                ", myDetailLocationName='" + myDetailLocationName + '\'' +
                '}';
    }
}

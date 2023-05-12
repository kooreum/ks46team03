package ks46team03.dto;

import java.util.List;

public class Location {
    private String myDetailLocationCode;
    private String fridgeCode;
    private String myDetailLocationName;
    private List<Fridge> fridgeList;



    public List<Fridge> getFridgeList() {
        return fridgeList;
    }

    public void setFridgeList(List<Fridge> fridgeList) {
        this.fridgeList = fridgeList;
    }

    public String getMyDetailLocationCode() {
        return myDetailLocationCode;
    }

    public void setMyDetailLocationCode(String myDetailLocationCode) {
        this.myDetailLocationCode = myDetailLocationCode;
    }

    public String getFridgeCode() {
        return fridgeCode;
    }

    public void setFridgeCode(String fridgeCode) {
        this.fridgeCode = fridgeCode;
    }

    public String getMyDetailLocationName() {
        return myDetailLocationName;
    }

    public void setMyDetailLocationName(String myDetailLocationName) {
        this.myDetailLocationName = myDetailLocationName;
    }

    @Override
    public String toString() {
        return "Location{" +
                "myDetailLocationCode='" + myDetailLocationCode + '\'' +
                ", fridgeCode='" + fridgeCode + '\'' +
                ", myDetailLocationName='" + myDetailLocationName + '\'' +
                ", fridgeList=" + fridgeList +
                '}';
    }
}

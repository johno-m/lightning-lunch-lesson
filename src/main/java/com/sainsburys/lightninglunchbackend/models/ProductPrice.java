package com.sainsburys.lightninglunchbackend.models;

public class ProductPrice {

    private double now;
    private boolean mealDeal;
    private String flashText;

    public double getNow(){
        return now;
    }

    public void setNow(double now){
        this.now = now;
    }

    public boolean getMealDeal(){
        return mealDeal;
    }

    public void setMealDeal(boolean mealDeal){
        this.mealDeal = mealDeal;
    }

    public String getFlashText(){
        return flashText;
    }

    public void setFlashText(String flashText) {
        this.flashText = flashText;
    }
}

package com.meals.model;


public class MealsVO implements java.io.Serializable{
	private Integer mealPicId;
	private byte[] mealPic;
	private String mealPicInfo;
	private Integer mealsId;
	
	public Integer getMealPicId() {
		return mealPicId;
	}
	public void setMealPicId(Integer mealPicId) {
		this.mealPicId = mealPicId;
	}
	
	
	public byte[] getMealPic() {
		return mealPic;
	}
	public void setMealPic(byte[] mealPic) {
		this.mealPic = mealPic;
	}
	
	
	public String getMealPicInfo() {
		return mealPicInfo;
	}
	public void setMealPicInfo(String mealPicInfo) {
		this.mealPicInfo = mealPicInfo;
	}
	
	
	public Integer getMealsId() {
		return mealsId;
	}
	public void setMealsId(Integer mealsId) {
		this.mealsId = mealsId;
	}
}

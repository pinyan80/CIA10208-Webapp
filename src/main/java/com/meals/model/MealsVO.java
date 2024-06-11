package com.meals.model;


public class MealsVO implements java.io.Serializable{
	private Integer mealPicId;
	private Byte mealPic;
	private String mealPicInfo;
	private Integer mealsId;
	
	public Integer getMealPicId() {
		return mealPicId;
	}
	public void setMealPicId(Integer mealPicId) {
		this.mealPicId = mealPicId;
	}
	
	
	public Byte getMealPic() {
		return mealPic;
	}
	public void setMealPic(Byte mealPic) {
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

package com.mealspic.model;

import java.util.List;

public class MealsPicService {

	private MealsPicDAO_interface dao;

	public MealsPicService() {
		dao = new MealsPicJDBCDAO();
	}

	public MealsPicVO addMeals(byte[] mealPic, String mealPicInfo,
		   Integer mealsId) {

		MealsPicVO mealspicVO = new MealsPicVO();


		mealspicVO.setMealPic(mealPic);
		mealspicVO.setMealPicInfo(mealPicInfo);
		mealspicVO.setMealsId(mealsId);
		dao.insert(mealspicVO);

		return mealspicVO;
	}

	public MealsPicVO updateMeals(Integer mealPicId, byte[] mealPic, String mealPicInfo,
			   Integer mealsId) {

		MealsPicVO mealspicVO = new MealsPicVO();
		
		mealspicVO.setMealPicId(mealPicId);
		mealspicVO.setMealPic(mealPic);
		mealspicVO.setMealPicInfo(mealPicInfo);
		mealspicVO.setMealsId(mealsId);
		dao.update(mealspicVO);

		return mealspicVO;
	}

	public void deleteMeals(Integer mealPicId) {
		dao.delete(mealPicId);
	}

	public MealsPicVO getOneMeals(Integer mealPicId) {
		return dao.findByPrimaryKey(mealPicId);
	}

	public List<MealsPicVO> getAll() {
		return dao.getAll();
	}
}

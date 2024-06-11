package com.meals.model;

import java.util.List;

public class MealsService {

	private MealsDAO_interface dao;

	public MealsService() {
		dao = new MealsJDBCDAO();
	}

	public MealsVO addMeals(Integer mealPicId, Byte mealPic, String mealPicInfo,
		   Integer mealsId) {

		MealsVO mealsVO = new MealsVO();

		mealsVO.setMealPicId(mealPicId);
		mealsVO.setMealPic(mealPic);
		mealsVO.setMealPicInfo(mealPicInfo);
		mealsVO.setMealsId(mealsId);
		dao.insert(mealsVO);

		return mealsVO;
	}

	public MealsVO updateMeals(Integer mealPicId, Byte mealPic, String mealPicInfo,
			   Integer mealsId) {

		MealsVO mealsVO = new MealsVO();
		
		mealsVO.setMealPicId(mealPicId);
		mealsVO.setMealPic(mealPic);
		mealsVO.setMealPicInfo(mealPicInfo);
		mealsVO.setMealsId(mealsId);
		dao.update(mealsVO);

		return mealsVO;
	}

	public void deleteMeals(Integer mealPicId) {
		dao.delete(mealPicId);
	}

	public MealsVO getOneMeals(Integer mealPicId) {
		return dao.findByPrimaryKey(mealPicId);
	}

	public List<MealsVO> getAll() {
		return dao.getAll();
	}
}

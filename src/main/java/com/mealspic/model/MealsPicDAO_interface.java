package com.mealspic.model;

import java.util.*;

public interface MealsPicDAO_interface {
    public void insert(MealsPicVO mealspicVO);
    public void update(MealsPicVO mealspicVO);
    public void delete(Integer mealPicId);
    public MealsPicVO findByPrimaryKey(Integer mealPicId);
    public List<MealsPicVO> getAll();
    //萬用複合查詢(傳入參數型態Map)(回傳 List)
//  public List<EmpVO> getAll(Map<String, String[]> map); 
}

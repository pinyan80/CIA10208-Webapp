package com.meals.model;

import java.util.*;

public interface MealsDAO_interface {
    public void insert(MealsVO mealsVO);
    public void update(MealsVO mealsVO);
    public void delete(Integer mealPicId);
    public MealsVO findByPrimaryKey(Integer mealPicId);
    public List<MealsVO> getAll();
    //萬用複合查詢(傳入參數型態Map)(回傳 List)
//  public List<EmpVO> getAll(Map<String, String[]> map); 
}

package com.mealstypes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="meals_types")
public class MealsTypesVO {

	private Integer mealsTypeId;
	private String mealsTypeName;
	
	public MealsTypesVO() {
		
	}

	@Id
	@Column(name="meals_type_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getMealsTypeId() {
		return mealsTypeId;
	}

	public void setMealsTypeId(Integer mealsTypeId) {
		this.mealsTypeId = mealsTypeId;
	}

	@Column(name="meals_type_name")
	@NotEmpty(message="餐點類別名稱不能空白")
	@Pattern(regexp="^[(\u4e00-\u9fa5)(a-zA-Z0-9)]{1,10}$", message="餐點類別名稱:只能是中英文數字，且長度必須小於10")
	public String getMealsTypeName() {
		return mealsTypeName;
	}

	public void setMealsTypeName(String mealsTypeName) {
		this.mealsTypeName = mealsTypeName;
	}
}

package com.meals.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.mealstypes.model.MealsTypesVO;

@Entity
@Table(name = "meals")
public class MealsVO implements java.io.Serializable{
	private static final long serialVersionUID = 1L;

	
	private Integer mealsId;
	private MealsTypesVO mealsTypesId;
	private String mealsName;
	private Integer mealsPrice;
	private String mealsDescription;
	private Integer mealsControl;
	private Integer mealsTotalScore;
	private Integer mealsTotalPeople;
	
	//必需有一個不傳參數建構子
	public MealsVO(){
		
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "meals_id", updatable = false, insertable = false)
	public Integer getMealsId() {
		return mealsId;
	}

	public void setMealsId(Integer mealsId) {
		this.mealsId = mealsId;
	}

	@Column(name = "meals_types_id")
	@ManyToOne
	@JoinColumn(name="meals_types_id")
	
	public MealsTypesVO getMealsTypesVO() {
		return this.mealsTypesVO;
	}

	public void setMealsTypesVO(MealsTypesVO mealsTypesVO) {
		this.mealsTypesVO = mealsTypesVO;
	}

	@Column(name = "meals_name")
	@NotEmpty(message="餐點名稱不能空白")
	@Pattern(regexp="^[(\u4e00-\u9fa5)(a-zA-Z0-9)]{1,20}$", message="餐點名稱:只能是中英文數字，且長度必須小於20")
	public String getMealsName() {
		return mealsName;
	}

	public void setMealsName(String mealsName) {
		this.mealsName = mealsName;
	}

	@Column(name = "meals_price")
	@NotEmpty(message="餐點價格:必須大於0")
	@DecimalMin(value="0", message="餐點價格:不能小於{value}")
	public Integer getMealsPrice() {
		return mealsPrice;
	}

	public void setMealsPrice(Integer mealsPrice) {
		this.mealsPrice = mealsPrice;
	}

	@Column(name = "meals_description")
	@Size(min=1,max=100,message="餐點描述必須在{min}到{max}之間")
	public String getMealsDescription() {
		return mealsDescription;
	}

	public void setMealsDescription(String mealsDescription) {
		this.mealsDescription = mealsDescription;
	}

	@Column(name = "meals_control")
	@Pattern(regexp="^[(0-1)]$",message="0:下架，1:上架")
	public Integer getMealsControl() {
		return mealsControl;
	}

	public void setMealsControl(Integer mealsControl) {
		this.mealsControl = mealsControl;
	}

	@Column(name = "meals_total_score")
	public Integer getMealsTotalScore() {
		return mealsTotalScore;
	}

	public void setMealsTotalScore(Integer mealsTotalScore) {
		this.mealsTotalScore = mealsTotalScore;
	}

	@Column(name = "meals_total_people")
	public Integer getMealsTotalPeople() {
		return mealsTotalPeople;
	}

	public void setMealsTotalPeople(Integer mealsTotalPeople) {
		this.mealsTotalPeople = mealsTotalPeople;
	}

}

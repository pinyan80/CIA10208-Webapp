package com.emp.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meals.model.MealsService;
import com.meals.model.MealsVO;

public class MealsServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		
		
		if ("getOne_For_Display".equals(action)) { //來自select_page.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				String str = req.getParameter("mealPicId");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("請輸入圖片編號");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/meals/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				Integer mealPicId = null;
				try {
					mealPicId = Integer.valueOf(str);
				} catch (Exception e) {
					errorMsgs.add("圖片編號格式不正確");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/meals/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				/***************************2.開始查詢資料*****************************************/
				MealsService mealsSvc = new MealsService();
				MealsVO mealsVO = mealsSvc.getOneMeals(mealPicId);
				if (mealPicId == null) {
					errorMsgs.add("查無資料");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/meals/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("mealsVO", mealsVO); // 資料庫取出的mealsVO物件,存入req
				String url = "/meals/listOneMeals.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
				successView.forward(req, res);
		}
		
		
		if ("getOne_For_Update".equals(action)) { // 來自listAllMeals.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
				/***************************1.接收請求參數****************************************/
				Integer mealPicId = Integer.valueOf(req.getParameter("mealPicId"));
				
				/***************************2.開始查詢資料****************************************/
				MealsService mealsSvc = new MealsService();
				MealsVO mealsVO = mealsSvc.getOneMeals(mealPicId);
								
				/***************************3.查詢完成,準備轉交(Send the Success view)************/
				req.setAttribute("mealsVO", mealsVO);         // 資料庫取出的mealsVO物件,存入req
				String url = "/meals/update_meals_input.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_meals_input.jsp
				successView.forward(req, res);
		}
		
		
		if ("update".equals(action)) { // 來自update_meals_input.jsp的請求
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
		
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
Integer mealPicId = Integer.valueOf(req.getParameter("mealPicId").trim());

Byte mealPic = Byte.valueOf(req.getParameter("mealPic").trim());
				
String mealPicInfo = req.getParameter("mealPicInfo");
				String mealPicInfoReg = "^[(\u4e00-\u9fa5)]$";
				if (mealPicInfo == null || mealPicInfo.trim().length() == 0) {
					errorMsgs.add("圖片名稱: 請勿空白");
				} else if(!mealPicInfo.trim().matches(mealPicInfoReg)) { //以下練習正則(規)表示式(regular-expression)
					errorMsgs.add("圖片名稱: 只能是中文");
	            }
				
Integer mealsId = Integer.valueOf(req.getParameter("mealsId").trim());

				MealsVO mealsVO = new MealsVO();
				mealsVO.setMealPicId(mealPicId);
				mealsVO.setMealPic(mealPic);
				mealsVO.setMealPicInfo(mealPicInfo);
				mealsVO.setMealsId(mealsId);

				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
req.setAttribute("mealsVO", mealsVO); // 含有輸入格式錯誤的mealsVO物件,也存入req
					RequestDispatcher failureView = req
							.getRequestDispatcher("/meals/update_meals_input.jsp");
					failureView.forward(req, res);
					return; //程式中斷
				}
				
				/***************************2.開始修改資料*****************************************/
				MealsService mealsSvc = new MealsService();
				mealsVO = mealsSvc.updateMeals(mealPicId, mealPic, mealPicInfo, mealsId);
				
				/***************************3.修改完成,準備轉交(Send the Success view)*************/
				req.setAttribute("mealsVO", mealsVO); // 資料庫update成功後,正確的的mealsVO物件,存入req
				String url = "/meals/listOneMeals.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneEmp.jsp
				successView.forward(req, res);
		}

        if ("insert".equals(action)) { // 來自addMeals.jsp的請求  
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
Integer mealPicId = Integer.valueOf(req.getParameter("mealPicId").trim());

Byte mealPic = Byte.valueOf(req.getParameter("mealPic").trim());
				
String mealPicInfo = req.getParameter("mealPicInfo");
				String mealPicInfoReg = "^[(\u4e00-\u9fa5)]$";
				if (mealPicInfo == null || mealPicInfo.trim().length() == 0) {
					errorMsgs.add("圖片名稱: 請勿空白");
				} else if(!mealPicInfo.trim().matches(mealPicInfoReg)) { //以下練習正則(規)表示式(regular-expression)
					errorMsgs.add("圖片名稱: 只能是中文");
	            }
				
Integer mealsId = Integer.valueOf(req.getParameter("mealsId").trim());

				MealsVO mealsVO = new MealsVO();
				mealsVO.setMealPicId(mealPicId);
				mealsVO.setMealPic(mealPic);
				mealsVO.setMealPicInfo(mealPicInfo);
				mealsVO.setMealsId(mealsId);				
				
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
req.setAttribute("mealsVO", mealsVO); // 含有輸入格式錯誤的mealsVO物件,也存入req
					RequestDispatcher failureView = req
							.getRequestDispatcher("/meals/addMeals.jsp");
					failureView.forward(req, res);
					return;
				}
				
				/***************************2.開始新增資料***************************************/
				MealsService mealsSvc = new MealsService();
				mealsVO = mealsSvc.addMeals(mealPicId, mealPic, mealPicInfo, mealsId);
				
				/***************************3.新增完成,準備轉交(Send the Success view)***********/
				String url = "/meals/listAllMeals.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllMeals.jsp
				successView.forward(req, res);				
		}
		
		
		if ("delete".equals(action)) { // 來自listAllMeals.jsp

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
	
				/***************************1.接收請求參數***************************************/
				Integer mealPicId = Integer.valueOf(req.getParameter("mealPicId"));
				
				/***************************2.開始刪除資料***************************************/
				MealsService mealsSvc = new MealsService();
				mealsSvc.deleteMeals(mealPicId);
				
				/***************************3.刪除完成,準備轉交(Send the Success view)***********/								
				String url = "/meals/listAllMeals.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
				successView.forward(req, res);
		}
	}
}

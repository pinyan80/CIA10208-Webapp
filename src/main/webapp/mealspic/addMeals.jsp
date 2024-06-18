<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.mealspic.model.*"%>

<% //見com.emp.controller.EmpServlet.java第238行存入req的empVO物件 (此為輸入格式有錯誤時的empVO物件)
   	MealsPicVO mealspicVO = (MealsPicVO) request.getAttribute("mealspicVO");
%>
--<%= mealspicVO==null %>--${mealspicVO.mealsId}-- <!-- line 100 -->
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<title>餐點圖片新增 - addMeals.jsp</title>

<style>
  table#table-1 {
	background-color: #CCCCFF;
    border: 2px solid black;
    text-align: center;
  }
  table#table-1 h4 {
    color: red;
    display: block;
    margin-bottom: 1px;
  }
  h4 {
    color: blue;
    display: inline;
  }
</style>

<style>
  table {
	width: 450px;
	background-color: white;
	margin-top: 1px;
	margin-bottom: 1px;
  }
  table, th, td {
    border: 0px solid #CCCCFF;
  }
  th, td {
    padding: 1px;
  }
</style>

</head>
<body bgcolor='white'>

<table id="table-1">
	<tr><td>
		 <h3>餐點圖片資料新增 - addMeals.jsp</h3></td><td>
		 <h4><a href="select_page.jsp"><img src="images/tomcat.png" width="100" height="100" border="0">回首頁</a></h4>
	</td></tr>
</table>

<h3>資料新增:</h3>

<%-- 錯誤表列 --%>
<c:if test="${not empty errorMsgs}">
	<font style="color:red">請修正以下錯誤:</font>
	<ul>
		<c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>

<FORM METHOD="post" ACTION="mealspic.do" name="form1" enctype="multipart/form-data">
<table>
	<jsp:useBean id="mealspicSvc" scope="page" class="com.mealspic.model.MealsPicService" />
	
	
	
<!--  	<tr>
		<td>餐點圖片編號:</td>
		<td><input type="TEXT" name="mealPicId" value="<%= (mealspicVO==null)? "1" : mealspicVO.getMealPicId()%>" size="45"/></td>
	</tr> -->
	<tr>
		<td>餐點圖片:</td>
		<td>
		  <input type="file" name="mealPic" id="mealPic"/>
		  <div id="imagePreview"></div>
		</td>
	</tr>
	<tr>
		<td>餐點圖片名稱:</td>
		<td><input type="TEXT" name="mealPicInfo" value="<%= (mealspicVO==null)? "巧克力吐司" : mealspicVO.getMealPicInfo()%>" size="45"  ></td>
	</tr>
	<tr>
		<td>餐點編號:</td>
		<td>
		<select size="1" name="mealsId">
         <c:forEach var="mealspicVO" items="${mealspicSvc.all}" > 
          <option value="${mealspicVO.mealPicId}"${(mealspicVO.mealsId==mealsVO.mealsId)? 'selected':'' }>${mealspicVO.mealsId}
         </c:forEach>   
       </select>
		
		</td>
	</tr>
	
</table>
<br>
<input type="hidden" name="action" value="insert">
<input type="submit" value="送出新增"></FORM>


</body>

</html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>IBM Meals: Home</title>

<style>
  table#table-1 {
	width: 450px;
	background-color: #CCCCFF;
	margin-top: 5px;
	margin-bottom: 10px;
    border: 3px ridge Gray;
    height: 80px;
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

</head>
<body bgcolor='white'>

<table id="table-1">
   <tr><td><h3>IBM Meals: Home</h3><h4>( MVC )</h4></td></tr>
</table>

<p>This is the Home page for IBM Meals: Home</p>

<h3>資料查詢:</h3>
	
<%-- 錯誤表列 --%>
<c:if test="${not empty errorMsgs}">
	<font style="color:red">請修正以下錯誤:</font>
	<ul>
	    <c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>

<ul>
  <li><a href='listAllMeals.jsp'>List</a> all Meals.  <br><br></li>
  
  
  <li>
    <FORM METHOD="post" ACTION="mealspic.do" >
        <b>輸入圖片編號 (如1):</b>
        <input type="text" name="mealPicId">
        <input type="hidden" name="action" value="getOne_For_Display">
        <input type="submit" value="送出">
    </FORM>
  </li>

  <jsp:useBean id="mealspicSvc" scope="page" class="com.mealspic.model.MealsPicService" />
   
  <li>
     <FORM METHOD="post" ACTION="mealspic.do" >
       <b>選擇圖片編號:</b>
       <select size="1" name="mealPicId">
         <c:forEach var="mealspicVO" items="${mealspicSvc.all}" > 
          <option value="${mealspicVO.mealPicId}">${mealspicVO.mealPicId}
         </c:forEach>   
       </select>
       <input type="hidden" name="action" value="getOne_For_Display">
       <input type="submit" value="送出">
    </FORM>
  </li>
  
  <li>
     <FORM METHOD="post" ACTION="mealspic.do" >
       <b>選擇圖片名稱:</b>
       <select size="1" name="mealPicId">
         <c:forEach var="mealspicVO" items="${mealspicSvc.all}" > 
          <option value="${mealspicVO.mealPicId}">${mealspicVO.mealPicInfo}
         </c:forEach>   
       </select>
       <input type="hidden" name="action" value="getOne_For_Display">
       <input type="submit" value="送出">
     </FORM>
  </li>
</ul>


<h3>餐點圖片管理</h3>

<ul>
  <li><a href='addMeals.jsp'>Add</a> a new meals.</li>
</ul>

</body>
</html>
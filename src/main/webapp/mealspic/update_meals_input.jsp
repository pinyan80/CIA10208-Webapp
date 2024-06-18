<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.mealspic.model.*"%>

<%
//見com.emp.controller.EmpServlet.java第163行存入req的empVO物件 (此為從資料庫取出的empVO, 也可以是輸入格式有錯誤時的empVO物件)
   MealsPicVO mealspicVO = (MealsPicVO) request.getAttribute("mealspicVO");
%>

<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<title>餐點圖片資料修改 - update_meals_input.jsp</title>

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
		 <h3>圖片資料資料修改 - update_meals_input.jsp</h3>
		 <h4><a href="select_page.jsp"><img src="images/back1.gif" width="100" height="32" border="0">回首頁</a></h4>
	</td></tr>
</table>

<h3>資料修改:</h3>

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
    <tr>
		<td>餐點圖片編號:<font color=red><b>*</b></font></td>
		<td><%=mealspicVO.getMealPicId()%></td>
	</tr>
<!-- 	<tr>
		<td>餐點圖片編號:</td>
		<td><input type="TEXT" name="mealPicId" value="<%= (mealspicVO==null)? "1" : mealspicVO.getMealPicId()%>" size="45"/></td>
	</tr> -->
	<tr>
        <td>餐點圖片:</td>
        <td><input type="file" name="mealPic" size="45"/></td>
    </tr>
	<tr>
		<td>餐點圖片名稱:</td>
		<td><input type="TEXT" name="mealPicInfo" value="<%= (mealspicVO==null)? "巧克力吐司" : mealspicVO.getMealPicInfo()%>" size="45"  ></td>
	</tr>
	<tr>
		<td>餐點編號:</td>
		<td><input type="TEXT" name="mealsId"   value="<%= (mealspicVO==null)? "1" : mealspicVO.getMealsId()%>" size="45"/></td>
	</tr>
	
</table>
<br>
<input type="hidden" name="action" value="update">
<input type="hidden" name="mealPicId" value="<%=mealspicVO.getMealPicId()%>">
<input type="submit" value="送出修改"></FORM>
</body>

</script>
</html>
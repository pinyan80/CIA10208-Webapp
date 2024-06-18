<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.mealspic.model.*"%>
<%-- 此頁練習採用 EL 的寫法取值 --%>

<%
MealsPicService mealspicSvc = new MealsPicService();
    List<MealsPicVO> list = mealspicSvc.getAll();
    pageContext.setAttribute("list",list);
%>


<html>
<head>
<title>所有餐點 - listAllMeals.jsp</title>

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
	width: 800px;
	background-color: white;
	margin-top: 5px;
	margin-bottom: 5px;
  }
  table, th, td {
    border: 1px solid #CCCCFF;
  }
  th, td {
    padding: 5px;
    text-align: center;
  }
</style>

</head>
<body bgcolor='white'>

<h4>此頁練習採用 EL 的寫法取值:</h4>
<table id="table-1">
	<tr><td>
		 <h3>所有員工資料 - listAllMeals.jsp</h3>
		 <h4><a href="select_page.jsp"><img src="images/back1.gif" width="100" height="32" border="0">回首頁</a></h4>
	</td></tr>
</table>

<table>
	<tr>
		<th>餐點圖片編號</th>
		<th>餐點圖片</th>
		<th>餐點圖片名稱</th>
		<th>餐點編號</th>
		
	</tr>
	<%@ include file="page1.file" %> 
	<c:forEach var="mealspicVO" items="${list}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">
		
		<tr>
			<td>${mealspicVO.mealPicId}</td>
			<td><img src="DBGifReader4?id=${mealspicVO.mealPicId}" width="100" height="auto"></td>
			<td>${mealspicVO.mealPicInfo}</td>
			<td>${mealspicVO.mealsId}</td>
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/mealspic/mealspic.do" style="margin-bottom: 0px;">
			     <input type="submit" value="修改">
			     <input type="hidden" name="mealPicId"  value="${mealspicVO.mealPicId}">
			     <input type="hidden" name="action"	value="getOne_For_Update"></FORM>
			</td>
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/mealspic/mealspic.do" style="margin-bottom: 0px;">
			     <input type="submit" value="刪除">
			     <input type="hidden" name="mealPicId"  value="${mealspicVO.mealPicId}">
			     <input type="hidden" name="action" value="delete"></FORM>
			</td>
		</tr>
	</c:forEach>
</table>
<%@ include file="page2.file" %>

</body>
</html>
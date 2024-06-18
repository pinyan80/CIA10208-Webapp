<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.mealspic.model.*"%>

<% //��com.emp.controller.EmpServlet.java��238��s�Jreq��empVO���� (������J�榡�����~�ɪ�empVO����)
   	MealsPicVO mealspicVO = (MealsPicVO) request.getAttribute("mealspicVO");
%>
--<%= mealspicVO==null %>--${mealspicVO.mealsId}-- <!-- line 100 -->
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<title>�\�I�Ϥ��s�W - addMeals.jsp</title>

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
		 <h3>�\�I�Ϥ���Ʒs�W - addMeals.jsp</h3></td><td>
		 <h4><a href="select_page.jsp"><img src="images/tomcat.png" width="100" height="100" border="0">�^����</a></h4>
	</td></tr>
</table>

<h3>��Ʒs�W:</h3>

<%-- ���~��C --%>
<c:if test="${not empty errorMsgs}">
	<font style="color:red">�Эץ��H�U���~:</font>
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
		<td>�\�I�Ϥ��s��:</td>
		<td><input type="TEXT" name="mealPicId" value="<%= (mealspicVO==null)? "1" : mealspicVO.getMealPicId()%>" size="45"/></td>
	</tr> -->
	<tr>
		<td>�\�I�Ϥ�:</td>
		<td>
		  <input type="file" name="mealPic" id="mealPic"/>
		  <div id="imagePreview"></div>
		</td>
	</tr>
	<tr>
		<td>�\�I�Ϥ��W��:</td>
		<td><input type="TEXT" name="mealPicInfo" value="<%= (mealspicVO==null)? "���J�O�R�q" : mealspicVO.getMealPicInfo()%>" size="45"  ></td>
	</tr>
	<tr>
		<td>�\�I�s��:</td>
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
<input type="submit" value="�e�X�s�W"></FORM>


</body>

</html>
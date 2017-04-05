<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:if test="${sessionScope.locale == 'locale_RU' or empty sessionScope.locale}" >
    <fmt:setBundle basename="locale_ru_RU" />
</c:if>
<c:if test="${sessionScope.locale == 'locale_EN'}">
    <fmt:setBundle basename="locale_en_EN" />
</c:if>
<html>
<head>
<title><fmt:message key="addSub.title"/></title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
  <%@include file="/jsp/header.jsp" %>
<div class="wrapper">
		<div id="content">
	<table class="main_table"> 
                    <tbody>
                        <tr>
                            <td class="left_content">
                                <div class="auth_frame">
                                    <%@include file="/jsp/login.jsp" %>
                                </div>
                                <div class="menu_frame">
                                    <%@include file="/jsp/menu.jsp" %>
                                </div><!-- end of menu -->
                            </td>
						<td class="right_content">
							<div class="Index">
                                    <div class="add_mag">
                                    	<h1><fmt:message key="addSub.form"/></h1>
                                        <form action="act" method="post" autocomplete="off">
                                            <input type="hidden" name="command" value="countTotalPrice" />
                                            <input type="hidden" name="mag_id" value="${mag.id}"/>
                                            <input type="hidden" name="user" value="${sessionScope.user}"/>
                                            <b style="color: red; font-size: 11px;"><fmt:message key="reg.warning"/></b><br/>
                                            <table class="Table">
                                                <tr>
                                                    <td><b><fmt:message key="addMag.name"/></b></td>
                                                    <td><input type="text" name="name" value="${mag.name}" readonly="readonly"/></td>
                                                </tr>
                                                <tr>
                                                    <td><b><fmt:message key="addMag.category"/></b></td>
                                                    <td><input type="text" name="category" value="${mag.type}" readonly="readonly"/></td>
                                                </tr>
                                                <tr>
                                                    <td><b><fmt:message key="addMag.price"/></b></td>
                                                    <td><input type="text" name="price" value="${mag.price}" readonly="readonly"/></td>
                                                    
                                                </tr>
                                            	<tr>
                                                    <td><b><fmt:message key="addSub.type"/></b></td>
                                                    <td>
                                                    <select name="type_id">
                                                    <c:forEach var="type" items="${requestScope.list}">
                                                   	<option value="${type.id}">${type.name}</option>
                                                   	  	</c:forEach> 
                                                    </select>
                                                    </td>
                                                </tr>
                                            </table>
                                            <input type="submit" name="submit" value="<fmt:message key="addSub.total"/>" class="Button"/>
                                        </form>
                                    </div>
                                </div>
                            </td>
                        </tr>
                    </tbody>
                </table>
</div>
</div>
</body>
</html>
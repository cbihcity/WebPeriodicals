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
                                    	<h1><fmt:message key="addSub.form"/></h1>
                                        <form action="act" method="post" autocomplete="off">
                                            <input type="hidden" name="command" value="addSub" />
                                            <input type="hidden" name="mag_id" value="${mag.id}"/>
                                            <input type="hidden" name="type_id" value="${type.id}"/>
                                            <input type="hidden" name="user_id" value="${sessionScope.user.id}"/>
                                            <b style="color: red; font-size: 11px;"><fmt:message key="add.notify"/></b><br/>
                                            <table class="Table">
                                                <tr>
                                                    <td><b><fmt:message key="add.name"/></b></td>
                                                    <td><input type="text" name="name" value="${mag.name}" readonly="readonly"/></td>
                                                </tr>
                                                <tr>
                                                    <td><b><fmt:message key="add.category"/></b></td>
                                                    <td><input type="text" name="category" value="${mag.type}" readonly="readonly"/></td>
                                                </tr>
                                                <tr>
                                                    <td><b><fmt:message key="add.pricemag"/></b></td>
                                                    <td><input type="text" name="price" value="${mag.price}" readonly="readonly"/></td>
                                                    
                                                </tr>
                                            	<tr>
                                                    <td><b><fmt:message key="add.typeSub"/></b></td>
                                                    <td><input type="text" name="type" value="${type.name}" readonly="readonly"/></td>
                                                </tr>
                                                <tr>
                                                    <td><b><fmt:message key="add.totalCost"/></b></td>
                                                    <td><input type="text" name="totalprice" value="${total}" readonly="readonly"/></td>
                                                </tr>
                                            </table>
                                            <input type="submit" name="submit" value="<fmt:message key="add.sub"/>" class="Button"/>
                                        </form>
                                    </div>
                            </td>
                        </tr>
                    </tbody>
                </table>
</div>
</div>
</body>
</html>
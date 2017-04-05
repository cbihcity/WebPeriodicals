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
<title><fmt:message key="editSubsciptionType.title"/></title>
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
                        <c:if test="${sessionScope.user.userType == 'ADMIN'}">
						<td class="right_content">
                                    <div class="add_mag">
                                    	<h1><fmt:message key="editSubsciptionType.form"/></h1>
                                        <form action="act" method="post" autocomplete="off">
                                            <input type="hidden" name="command" value="editSubscriptionType" />
                                            <input type="hidden" name="type_id" value="${type.id}" />
                                            <b style="color: red; font-size: 11px;"><fmt:message key="reg.warning"/></b><br/>
                                            <table class="add_mag_table">
                                                <tr>
                                                    <td><fmt:message key="addMag.name"/></td>
                                                    <td><input type="text" name="name" value="${type.name}"/></td>
                                                </tr>
                                                <tr>
                                                    <td><fmt:message key="addSubType.month"/></td>
                                                    <td><input type="text" name="monthValue" value="${type.monthValue}"/></td>
                                                </tr>
                                            </table>
                                            <input type="submit" name="submit" value="<fmt:message key="editMag.button"/>" class="Button"/>
                                        </form>
                                    </div>
                            </td>
                            </c:if>
                        </tr>
                    </tbody>
                </table>
</div>
</div>
</body>
</html>
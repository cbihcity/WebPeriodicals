<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<title><fmt:message key="userUsbsciptions.title"/></title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
  <%@include file="/jsp/header.jsp" %>
	<div class="wrapper">
		<div id="content">
			<table class="main_table" >
				<tbody>
					<tr>
						<td class="left_content">
							<div class="auth_frame">
								<%@include file="/jsp/login.jsp"%>
							</div>
							<div class="menu_frame">
								<%@include file="/jsp/menu.jsp"%>
							</div> <!-- end of menu -->
						</td>
						<td class="right_content">
							<div class="Index">
							<h1><fmt:message key="userUsbsciptions.list"/>:</h1>
									<table class="Table">
										<tr>
											<td><b><fmt:message key="reg.firstName"/></b></td>
											<td><b><fmt:message key="userUsbsciptions.magName"/></b></td>
											<td><b><fmt:message key="addMag.category"/></b></td>
											<td><b><fmt:message key="addSub.type"/></b></td>
											<td><b><fmt:message key="userUsbsciptions.start"/></b></td>
											<td><b><fmt:message key="userUsbsciptions.end"/></b></td>
											<td><b><fmt:message key="addMag.price"/></b></td>
										</tr>
										<c:forEach var="sub" items="${requestScope.list}">
										<tr>
											<td>${sub.user.firstName}</td>
											<td>${sub.magazine.name}</td>
											<td>${sub.magazine.type}</td>
											<td>${sub.type.name}</td>
											<td>${sub.startDate}</td>
											<td>${sub.endDate}</td>
											<td>${sub.price}</td>
											<c:if test="${sessionScope.user.userType == 'ADMIN'}">
												<td>
													<form action="act" method="post">
														<input type="hidden" name="command" value="delSub" /> 
														<input type="hidden" name="sub_id" value="${sub.id}" /> 
														<input type="submit" value="<fmt:message key="userUsbsciptions.delete"/>" class="Button" />
													</form>
												</td>
											</c:if>
										</tr>
									</c:forEach>
								</table>
							</div>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>
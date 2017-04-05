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
<title><fmt:message key="users.title"/></title>
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
								<%@include file="/jsp/login.jsp"%>
							</div>
							<div class="menu_frame">
								<%@include file="/jsp/menu.jsp"%>
							</div> <!-- end of menu -->
						</td>
						<c:if test="${sessionScope.user.userType == 'ADMIN'}">
						<td class="right_content">
							<div class="Index">
							<h1><fmt:message key="users.list"/>:</h1>
									<table class="Table">
										<tr>
											<td><b><fmt:message key="reg.firstName"/></b></td>
											<td><b><fmt:message key="reg.lastName"/></b></td>
											<td><b><fmt:message key="addMag.category"/></b></td>
											<td><b><fmt:message key="reg.Email"/></b></td>
										</tr>
										<c:forEach var="user" items="${requestScope.list}">
											<tr>
												<td>${user.firstName}</td>
												<td>${user.lastName}</td>
												<td>${user.userType}</td>
												<td>${user.email}</td>
												<td>
													<form action="act" method="post">
                                                    <input type="hidden" name="command" value="delUser" />  
                                                    <input type="hidden" name="user_id" value="${user.id}"/>
                                                    <input type="submit" value="<fmt:message key="users.delete"/>" class="Button"/>
                                                	</form> 
												</td>
												<td>
													<form action="act" method="post">
                                                    <input type="hidden" name="command" value="prepareEditUser" />  
                                                    <input type="hidden" name="user_id" value="${user.id}"/>
                                                    <input type="submit" value="<fmt:message key="users.edit"/>" class="Button"/>
                                                	</form> 
												</td>
												<td>
													<form action="act" method="post">
                                                    <input type="hidden" name="command" value="showUserSubscriptions" />  
                                                   	<input type="hidden" name="email" value="${user.email}" /> 
                                                    <input type="submit" value="<fmt:message key="users.sub"/>" class="Button"/>
                                                	</form> 
												</td>
											</tr>
										</c:forEach>
									</table>
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
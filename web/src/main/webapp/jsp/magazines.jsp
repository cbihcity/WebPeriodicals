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
<title><fmt:message key="mag.title"/></title>
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
							<h1><fmt:message key="mag.listTitle"/>:</h1>
									<table class="Table">
										<tr>
											<td><b><fmt:message key="addMag.name"/></b></td>
											<td><b><fmt:message key="addMag.category"/></b></td>
											<td><b><fmt:message key="addMag.price"/></b></td>
										</tr>
										<c:forEach var="mag" items="${requestScope.list}">
											<tr>
												<td>${mag.name}</td>
												<td>${mag.type}</td>
												<td>${mag.price}</td>
												<c:if test="${sessionScope.user.userType == 'ADMIN'}">
												<td>
													<form action="act" method="post">
                                                    <input type="hidden" name="command" value="delMag" />  
                                                    <input type="hidden" name="mag_id" value="${mag.id}"/>
                                                    <input type="submit" value="<fmt:message key="mag.deleteButton"/>" class="Button"/>
                                                	</form> 
												</td>
												<td>
													<form action="editMagazine" method="post">
                                                    <input type="hidden" name="command" value="prepareEditMag" />  
                                                    <input type="hidden" name="mag_id" value="${mag.id}"/>
                                                    <input type="submit" value="<fmt:message key="mag.editButton"/>" class="Button"/>
                                                	</form> 
												</td>
												</c:if>
												<c:if test="${sessionScope.user.userType == 'USER'}">
												<td>
													<form action="act" method="post">
                                                    <input type="hidden" name="command" value="prepareAddSub" />  
                                                    <input type="hidden" name="mag_id" value="${mag.id}"/>
                                                    <input type="hidden" name="user" value="${sessionScope.user}"/>
                                                    <input type="submit" value="<fmt:message key="mag.buyButton"/>" class="Button"/>
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
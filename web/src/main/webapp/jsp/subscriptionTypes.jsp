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
<title><fmt:message key="subsciptionType.title"/></title>
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
						<td class="right_content">
						<c:if test="${sessionScope.user.userType == 'ADMIN'}">
							<div class="Index">
							<h1><fmt:message key="subsciptionType.list"/>:</h1>
									<table class="Table">
										<tr>
											<td><b><fmt:message key="addMag.name"/></b></td>
											<td><b><fmt:message key="addSubType.month"/></b></td>
										</tr>
										<c:forEach var="type" items="${requestScope.list}">
											<tr>
												<td>${type.name}</td>
												<td>${type.monthValue}</td>
												<td>
													<form action="act" method="post">
                                                    <input type="hidden" name="command" value="delSubscriptionTypes" />  
                                                    <input type="hidden" name="type_id" value="${type.id}"/>
                                                    <input type="submit" value="<fmt:message key="subsciptionType.delete"/>" class="Button"/>
                                                	</form> 
												</td>
												<td>
													<form action="editSubscriptionType" method="post">
                                                    <input type="hidden" name="command" value="prepareEditSubscriptionTypes" />  
                                                    <input type="hidden" name="type_id" value="${type.id}"/>
                                                    <input type="submit" value="<fmt:message key="subsciptionType.edit"/>" class="Button"/>
                                                	</form> 
												</td>
											</tr>
										</c:forEach>
									</table>
									<table class="TableButtonLeft">
									<tr>
									<td>
									<form action="act" method="post">
                                                    <input type="hidden" name="command" value="referAddSubscriptionType" />  
                                                    <input type="submit" value="<fmt:message key="subsciptionType.add"/>" class="Button"/>
                                    </form> 
                                    </td>
                                    </tr>
                                    </table>
							</div>
							</c:if>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>
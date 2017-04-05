<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div class="Gadget">
		<table class="menu">
			<c:choose>
				<c:when test="${not empty sessionScope.user}">
					<tr>
						<td>
							<form action="Index" method="post">
								<input type="hidden" name="command" value="index" /> 
								<input type="submit" value="<fmt:message key="button.main"/>" class="Button" />
							</form>
						</td>
					</tr>
					<tr>
						<td>
							<form action="showMagazines" method="post">
								<input type="hidden" name="command" value="magazines" /> 
								<input type="submit" value="<fmt:message key="button.showAllMagazines"/>" class="Button" />
							</form>
						</td>
					</tr>
					<c:if test="${sessionScope.user.userType == 'USER'}">
					<tr>
						<td>
							<form action="act" method="post">
								<input type="hidden" name="command" value="showUserSubscriptions" /> 
								<input type="hidden" name="email" value="${sessionScope.user.email}" /> 
								<input type="submit" value="<fmt:message key="button.mySubsciptions"/>" class="Button" />
							</form>
						</td>
					</tr>
					</c:if>
				</c:when>
			</c:choose>
			<c:if test="${sessionScope.user.userType == 'ADMIN'}">
				<tr>
					<td style="font-size: 10px; text-align: center">-<fmt:message key="text.AdminPanel"/>-
					</td>
				</tr>
				<tr>
					<td>
						<form action="act" method="post">
							<input type="hidden" name="command" value="getListsCategory" />
							<input type="submit" name="submit" value="<fmt:message key="button.AddMagazine"/>" class="Button"/>
						</form>
					</td>
				</tr>
				<tr>
					<td>
						<form action="usersList" method="post">
							<input type="hidden" name="command" value="users" />
							<input type="submit" name="submit" value="<fmt:message key="button.Users"/>" class="Button"/>
						</form>
					</td>
				</tr>
				<tr>
					<td>
						<form action="subscription_types" method="post">
							<input type="hidden" name="command" value="subscriptionTypes" />
							<input type="submit" name="submit" value="<fmt:message key="button.Subscriptiontypes"/>" class="Button"/>
						</form>
					</td>
				</tr>
				<tr>
						<td>
							<form action="act" method="post">
								<input type="hidden" name="command" value="showUserSubscriptions" /> 
								<input type="submit" value="<fmt:message key="button.AllSubscriptions"/>" class="Button" />
							</form>
						</td>
				</tr>
			</c:if>
		</table>
</div>
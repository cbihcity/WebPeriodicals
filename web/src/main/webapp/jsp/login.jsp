<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script type="text/javascript" src="js/validation.js"></script>
<div class="Gadget">
	<div class="GadgetContent">
		<c:choose>
			<c:when test="${empty sessionScope.user}">
				<form action="act" method="POST" autocomplete="off">
					<input type="hidden" name="command" value="login" />
					<div class="Input">
						<input id="loginAuthForm" name="email" type="text" value="Email"
							class="Input2" onfocus="clearField('Email','loginAuthForm')"
							onblur="restoreField('Email','loginAuthForm')" />
					</div>
					<div class="Input">
						<input id="passAuthForm" name="password" type="password"
							value="password" class="Input2"
							onfocus="clearField('password','passAuthForm')"
							onblur="restoreField('password','passAuthForm')" />
					</div>
					<input type="submit" value="<fmt:message key="login.button"/>" class="Button" style="width: 100px"/>
					<a href="register"><fmt:message key="reg.button"/></a>
				</form>
			</c:when>
			<c:otherwise>
				<div class="authorized">
					<b><fmt:message key="auth.Hello"/>, ${sessionScope.user.firstName}!</b> 
					<br/><b><fmt:message key="auth.email"/>  - ${sessionScope.user.email}!</b>
					<br/><a href="act?command=logout"><fmt:message key="auth.out"/></a>
				</div>
			</c:otherwise>
		</c:choose>
	</div>
</div>
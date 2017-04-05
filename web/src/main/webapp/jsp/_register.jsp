<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script type="text/javascript" src="js/validation.js"></script>
<div class="Index">
	<form action="act" method="post" autocomplete="off" onsubmit="return ValidationEvent();">
		<input type="hidden" name="command" value="register" />
		<h1><fmt:message key="reg.title"/></h1>
		<b style="color: gray; font-size: 11px;"><i style="color: red">*</i><fmt:message key="reg.warning"/></b>
		<table class="add_user_table">
                <tr>
                    <td style="vertical-align: top;"><i style="color: red">*<fmt:message key="reg.firstName"/>:</i></td>
                    <td><input type="text" name="first_name" id="first_name" maxlength="15"/>
                        <br/><b id="first_name" style="color: red; font-size: 10px;">
                            <fmt:message key="reg.nameWarning"/>
                        </b>
                    </td>
                </tr>
                <tr>
                    <td style="vertical-align: top;"><i style="color: red">*<fmt:message key="reg.lastName"/>:</i></td>
                    <td><input type="text" name="last_name" id="last_name" />
                        <br/><b id="last_name" style="color: red; font-size: 10px;">
                            <fmt:message key="reg.nameWarning"/>
                        </b>
                    </td>
                </tr>
                <tr>
                    <td style="vertical-align: top;"><i style="color: red">*<fmt:message key="reg.Email"/>:</i></td>
                    <td><input type="text" name="email" id="email" />
                        <br/><b id="email" style="color: red; font-size: 10px;">
                            <fmt:message key="reg.emailWarning"/>
                        </b>
                    </td>
                </tr>
                <tr>
                    <td style="vertical-align: top;"><i style="color: red">*<fmt:message key="reg.password"/>:</i></td>
                    <td><input type="password" name="pass" id="password" />
                        <br/><b id="password" style="color: red; font-size: 10px;">
                              <fmt:message key="reg.passWarning"/>
                             </b>
                    </td>
                </tr>
            </table>
		<input style="margin: 0px  150px" class="Button" type="submit"
			name="submit" value="<fmt:message key="reg.button"/>" />
	</form>
</div>
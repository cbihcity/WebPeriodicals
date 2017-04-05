<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>

<table style="width: 100%">
    <tr>
        <td style="width: 130px;vertical-align: ;">
                <div class="locale_bar">
                    <form action="act" method="post">
                        <input type="hidden" name="command" value="lang"/>
                        <input type="submit" name="lang" value="EN" class="Button" style="width: 30px"/>
                        <input type="submit" name="lang" value="RU" class="Button" style="width: 30px"/>
                    </form>
                </div>
        </td>
    </tr>
</table>
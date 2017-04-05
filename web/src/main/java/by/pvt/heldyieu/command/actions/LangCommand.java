package by.pvt.heldyieu.command.actions;

import by.pvt.heldyieu.command.ServletCommand;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LangCommand implements ServletCommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String lang = request.getParameter(LANG);
        HttpSession session = request.getSession();
        session.setAttribute(LOCALE, BASENAME + lang);
        Cookie c = new Cookie(LOCALE, lang);
        c.setMaxAge(COOKIE);
        response.addCookie(c);
        return null;
    }

}

package by.pvt.heldyieu.command.actions;

import by.pvt.heldyieu.command.ServletCommand;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutCommand implements ServletCommand {

    
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        
        HttpSession session = request.getSession();
        session.removeAttribute(USER);
        Cookie c = new Cookie(ID,"");
        c.setMaxAge(0);
        response.addCookie(c);
        return null;
    }

}

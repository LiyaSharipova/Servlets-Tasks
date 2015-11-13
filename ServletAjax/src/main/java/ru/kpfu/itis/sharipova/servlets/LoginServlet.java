package ru.kpfu.itis.sharipova.servlets;

import ru.kpfu.itis.sharipova.entities.User;
import ru.kpfu.itis.sharipova.exceptions.IdentityException;
import ru.kpfu.itis.sharipova.repositories.UserRepository;
import ru.kpfu.itis.sharipova.utils.SecurityService;
import ru.kpfu.itis.sharipova.utils.ServletCookies;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Baths on 14.10.2015.
 */
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        if (session.getAttribute("user") == null) {
            Cookie cookie= ServletCookies.getCookie(req, "rememberMe");
            if(cookie!=null){
                try {
                    User user=UserRepository.getUserByCookie(cookie);
                    if(user!=null){
                        Cookie cookie1=new Cookie("remember", SecurityService.getRand());
                        cookie.setMaxAge(60*60);
                        UserRepository.updateCookie(user, cookie1);
                        resp.addCookie(cookie1);
                        session.setAttribute("user", user);

                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            req.getServletContext().getRequestDispatcher("/WEB-INF/views/Login.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("/profile");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String rememberMe=req.getParameter("rememberMe");
        if (email != null && password != null) {
            try {
                User user = UserRepository.identifyUser(email, password);
                session.setAttribute("user", user);
                if(rememberMe.equals("on")){

                    Cookie cookie= new Cookie("rememberMe", SecurityService.getRand());
                    UserRepository.updateCookie(user, cookie);
                    cookie.setMaxAge(60*60);
                    resp.addCookie(cookie);
                }
                resp.sendRedirect("/profile");
                return;
            } catch (SQLException | IdentityException e) {
                req.setAttribute("message", e.getMessage());
            }
        }
        else
            req.setAttribute("message", "Please fill all fields");
        req.getServletContext().getRequestDispatcher("/WEB-INF/views/Login.jsp").forward(req, resp);

    }
}

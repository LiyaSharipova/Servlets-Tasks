package ru.kpfu.itis.sharipova.servlets;

import ru.kpfu.itis.sharipova.entities.User;
import ru.kpfu.itis.sharipova.repositories.UserRepository;
import ru.kpfu.itis.sharipova.utils.ServletCookies;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Baths on 08.11.2015.
 */
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
        User user=(User)session.getAttribute("user");
        try {
            UserRepository.deleteCookie(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.getSession().invalidate();
        resp.sendRedirect("/welcome");
    }



}

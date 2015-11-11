package ru.kpfu.itis.sharipova.servlets;

import ru.kpfu.itis.sharipova.entities.User;
import ru.kpfu.itis.sharipova.exceptions.IdentityException;
import ru.kpfu.itis.sharipova.repositories.UserRepository;

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

        if (session.getAttribute("user") == null){
            req.getServletContext().getRequestDispatcher("/WEB-INF/views/Login.jsp").forward(req, resp);
        }else {
            resp.sendRedirect("/profile");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        try {
            User user= UserRepository.identifyUser(email, password);
            session.setAttribute("user",user);
            resp.sendRedirect("/profile");
            return;
        } catch (SQLException | IdentityException e) {
            req.setAttribute("message", e.getMessage());
        }
        req.getServletContext().getRequestDispatcher("/WEB-INF/views/Login.jsp").forward(req,resp);
    }
}

package ru.kpfu.itis.sharipova.servlets;

import ru.kpfu.itis.sharipova.entities.User;
import ru.kpfu.itis.sharipova.exceptions.DatabaseException;
import ru.kpfu.itis.sharipova.exceptions.IdentityException;
import ru.kpfu.itis.sharipova.repositories.DataRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Baths on 14.10.2015.
 */
public class LogInServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        if (session.getAttribute("authen") == null){
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
            User user = DataRepository.logInCheck(email, password);
            session.setAttribute("authen",user);
            resp.sendRedirect("/profile");
            return;
        } catch (DatabaseException | IdentityException e) {
            req.setAttribute("message", e.getMessage());
        }
        req.getServletContext().getRequestDispatcher("/WEB-INF/views/authentication.jsp").forward(req,resp);
    }
}

package ru.kpfu.itis.sharipova.servlets;

import ru.kpfu.itis.sharipova.exceptions.DatabaseException;
import ru.kpfu.itis.sharipova.repositories.DataRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Baths on 15.10.2015.
 */
public class UsersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setAttribute("users", DataRepository.getData());
        } catch (DatabaseException e) {
            e.printStackTrace();
        }
        req.getServletContext().getRequestDispatcher("/WEB-INF/views/AllUsers.jsp").forward(req, resp);
    }
}

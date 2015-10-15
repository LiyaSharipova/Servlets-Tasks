package ru.kpfu.itis.sharipova.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Baths on 14.10.2015.
 */
public class ProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
        if ((session.getAttribute("authen") == null)){
            resp.sendRedirect("/LogInServlet");
        }else {
            req.setAttribute("user",  session.getAttribute("authen"));
            req.getServletContext().getRequestDispatcher("/WEB-INF/views/profile.jsp").forward(req, resp);
        }

    }

}

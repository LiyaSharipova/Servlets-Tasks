package ru.kpfu.itis.sharipova.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Baths on 05.11.2015.
 */
public class AjaxTestServletWithXml extends HttpServlet {
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/xml");
        response.getWriter().println("<root><date>" + 42 + "</date></root>");
//        request.getServletContext().getRequestDispatcher("/WEB-INF/views/useAjax.jsp").forward(request,response);
    }
}
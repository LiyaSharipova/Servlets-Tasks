package ru.kpfu.itis.sharipova.servlets;

import ru.kpfu.itis.sharipova.exceptions.LongPasswordException;
import ru.kpfu.itis.sharipova.exceptions.NotValidEmailException;
import ru.kpfu.itis.sharipova.exceptions.ShortPasswordException;
import ru.kpfu.itis.sharipova.repositories.DataRepository;
import ru.kpfu.itis.sharipova.entities.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MainServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        if(req.getParameter("status") != null){
            if(req.getParameter("status").equals("1")){
                req.setAttribute("message", "User has been created.");
            }
        }

        getServletContext().getRequestDispatcher("/WEB-INF/views/Form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        String email = req.getParameter("email");
        String pass = req.getParameter("password");
        String gender = req.getParameter("gender");
        String subscribe = req.getParameter("subscribe");
        DataRepository dataRepository= new DataRepository();
            if (email != null && pass != null && gender != null) {
                try {
                    dataRepository.addUser(new User(email, pass, gender, subscribe));
                    resp.sendRedirect(req.getRequestURI()+"?status=1");
                    return;
                }
               catch (NotValidEmailException e){
                   req.setAttribute("message",e.getMessage());

               } catch (ShortPasswordException e){
                   req.setAttribute("message",e.getMessage());

               }
                catch (LongPasswordException e){
                    req.setAttribute("message",e.getMessage());
                }
            } else
                req.setAttribute("message", "Please fill all fields");

        getServletContext().getRequestDispatcher("/WEB-INF/views/Form.jsp").forward(req, resp);
    }

}

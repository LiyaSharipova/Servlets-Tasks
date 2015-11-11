package ru.kpfu.itis.sharipova.servlets;

import ru.kpfu.itis.sharipova.exceptions.*;
import ru.kpfu.itis.sharipova.repositories.UserRepository;
import ru.kpfu.itis.sharipova.entities.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class RegistrationServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession session = req.getSession();

//        if ((session.getAttribute("authen") != null)){
//            resp.sendRedirect("/profile");
//        }else
            if (session.getAttribute("reg") != null){
            resp.sendRedirect("/login");
        }else {
            req.getServletContext().getRequestDispatcher("/WEB-INF/views/registration.jsp").forward(req,resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        String email = req.getParameter("email");
        String pass = req.getParameter("password");
        String gender = req.getParameter("gender");
        String subscribe = req.getParameter("subscribe");
        String aboutMe = req.getParameter("aboutMe");
        if (email != null && pass != null && gender != null&& aboutMe!=null) {
            try {
                UserRepository.addUser(new User(email, pass, gender, subscribe, aboutMe));

                httpSession.setAttribute("reg", "1");
                resp.sendRedirect("/login");
                return;
            } catch (DuplicateEntryException|NotValidEmailException
                    | ShortPasswordException| LongPasswordException e) {
                req.setAttribute("message", e.getMessage());
            }

        } else
            req.setAttribute("message", "Please fill all fields");
        getServletContext().getRequestDispatcher("/WEB-INF/views/registration.jsp").forward(req, resp);
    }

}

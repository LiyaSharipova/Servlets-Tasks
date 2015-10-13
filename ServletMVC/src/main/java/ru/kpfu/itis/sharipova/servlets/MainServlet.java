package ru.kpfu.itis.sharipova.servlets;

import ru.kpfu.itis.sharipova.entities.User;
import ru.kpfu.itis.sharipova.exceptions.LongPasswordException;
import ru.kpfu.itis.sharipova.exceptions.NotValidEmailException;
import ru.kpfu.itis.sharipova.exceptions.ShortPasswordException;
import ru.kpfu.itis.sharipova.repository.DataRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class MainServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        String reqParam = req.getParameter("exception");
        if (reqParam  == null) {
            out.println(getHtml());
            return;
        }
        switch (reqParam){
            case "shortPass" : out.println("Password is too short");
                break;
            case "email" : out.println("Email is not valid");
                break;
            case "longPass" : out.println(("Password is too long"));
                break;
            case "emptyFields" : out.println(("Fill in all fields"));
                break;
        }
        out.print(getHtml());
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
                    dataRepository.addUser(new User(email, pass, gender, subscribe));}
               catch (NotValidEmailException e){
                   resp.sendRedirect("/form?exception=email");
                   return;
               }
               catch (ShortPasswordException e){
                   resp.sendRedirect("/form?exception=shortPass");
                   return;
               }
                catch (LongPasswordException e){
                    resp.sendRedirect("/form?exception=longPass");
                    return;
                }
                resp.sendRedirect("/form");
            } else
                resp.sendRedirect("/form?exception=emptyFields");


    }



    protected String getHtml() {

        return ("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Log in</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<form action=\"\"form method=\"POST\">\n" +
                "    <p>Email:<br><input type=\"text\" name=\"email\"></p>\n" +
                "    <p>Password:<br><input type=\"password\" name=\"password\" value=\"\"></p>\n" +
                "Gennder: </br>\n" +

                "    <input type=\"radio\" name=\"gender\" value=\"1\">Male</br>\n" +
                "    <input type=\"radio\" name=\"gender\" value=\"0\" >Female </br>" +


                "<p>  <input type=\"checkbox\" name=\"subscribe\" value=\"on\" checked>I want to receive the latest news</p>" +
                " <p><input  type=\"submit\" value=\"Log in\">" +
                "</form>\n" +
                "</body>\n" +
                "</html>");

    }

}

package ru.kpfu.itis.sharipova.servlets;

import ru.kpfu.itis.sharipova.repository.DataRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;

/**
 * Created by Baths on 07.10.2015.
 */
public class UsersDataServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.print(getHtml());


    }


    protected String getHtml(){
        StringBuilder sb = new StringBuilder();
        sb.append("<!DOCTYPE html>");
        sb.append("<html>");
        sb.append("<head><meta charset=\"utf-8\"/>");
        sb.append("<title>users</title>");
        sb.append("<style>body{ background-color: #7babac; }\n" +
                        "      .block{\n" +
                        "          text-align: center; border: solid 2px #34bc85;\n" +
                        "          padding: 15px;height: 150px;\n" +
                        "          width: 300px ; background: gainsboro;\n" +
                        "          font-family: sans-serif; font-weight: 200; font-size: 20px; \n" +
                        "          color: #ec8f01; margin:20px;float: left}"+
                "</style >");
        sb.append("</head");

        sb.append("<body>");
        ArrayList<String[]> db = DataRepository.getData();
        for (String[] data: db){
            sb.append("<div class=\"block\">"+data[0]+"</br>");
            sb.append(data[1].replace('&', ' ')+"</br>");
            if (data[2]=="1") data[2]="male";
            else data[2]="female";
            sb.append(data[2]+"</br>");
            sb.append(data[3]+"</div>");
        }
        sb.append("</body>");
        sb.append("</html>");
        return sb.toString();
    }
}

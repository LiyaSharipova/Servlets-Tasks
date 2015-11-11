package ru.kpfu.itis.sharipova.servlets;

import ru.kpfu.itis.sharipova.utils.DBConnection;
import ru.kpfu.itis.sharipova.utils.SingletonDBConnection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class ConfigServlet extends HttpServlet
{
    @Override
    public void init() throws ServletException
    {
        super.init();
//        SingletonDBConnection.getInstance();
        DBConnection.getDBConnection();
    }
}

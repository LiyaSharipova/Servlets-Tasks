package info.istamendil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class MainServlet extends HttpServlet {
    protected File db = new File("C:\\Users\\Baths\\Documents\\web\\dataBase.txt");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
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
        if (email != null && pass != null && gender != null) {
            out.println("User is added ");
            writeToFail(email, pass, gender, subscribe);
        } else
            out.print("Please fill in all fields.");
        doGet(req, resp);
    }

    protected void writeToFail(String email, String pass, String gender, String suscribe) {
        if(suscribe==null) suscribe="off";
        try ( PrintWriter writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(db, true), "UTF-8"));) {
            writer.println(email + " " + datacheck(pass) + " " + gender+ " "+suscribe);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
                "    <p>Email:<br><input type=\"email\" name=\"email\"></p>\n" +
                "\n" +
                "    <p>Password:<br><input type=\"password\" name=\"password\" value=\"\"></p>\n" +
                "Gennder: </br>\n" +

                "    <input type=\"radio\" name=\"gender\" value=\"1\">Male</br>\n" +
                "    <input type=\"radio\" name=\"gender\" value=\"0\" >Female </br>" +


                "<p>  <input type=\"checkbox\" name=\"subscribe\" value=\"on\" cheched>I want to receive the latest news</p>" +
                " <p><input  type=\"submit\" value=\"Log in\">" +
                "</form>\n" +
                "</body>\n" +
                "</html>");
    }

    protected String datacheck(String str) {
        return str.replace(' ', '$');
    }


}

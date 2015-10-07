package info.istamendil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;

/**
 * Created by Baths on 07.10.2015.
 */
public class Users extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.print(getHtml());


    }
    private ArrayList<String> getData() {
        ArrayList<String> database = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new MainServlet().db)));
            String s;
            while ((s = reader.readLine()) != null) {
               database.add(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return database;
    }

    protected String getHtml(){
        StringBuilder sb = new StringBuilder();
        sb.append("<!DOCTYPE html>");
        sb.append("<html>");
        sb.append("<head><meta charset=\"utf-8\"/>");
        sb.append("<title>users</title>");
        sb.append("<style>table{float: left; marging:20px  }</style >");
        sb.append("</head");
        sb.append("<body>");
        ArrayList<String> db = getData();
        for (int i = 0; i < db.size(); i ++) {
            String[] data= db.get(i).split(" ");
            sb.append("<table width:\"150px\">");
            sb.append("<col width=\"50\" valign=\"top\">\n" +
                    "   <col width=\"250\" valign=\"top\">");
            sb.append("<tr><td>Email</td><td>"+data[0]+ "</td> </tr>");
            sb.append("<tr><td>Password</td><td>" + data[1].replace('&', ' ')+"</td></tr>");
            if (data[2]=="1") data[2]="male";
            else data[2]="female";
            sb.append("<tr><td>Gender: </td><td>"+ data[2]+"</td></tr>");
            sb.append("<tr><td>Subscription: </td><td>"+ data[3]+"</td></tr></table>");
        }
        sb.append("</body>");
        sb.append("</html>");
        return sb.toString();
    }
}

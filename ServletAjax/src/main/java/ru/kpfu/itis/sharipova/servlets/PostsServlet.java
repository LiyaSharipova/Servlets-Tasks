package ru.kpfu.itis.sharipova.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.StringWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import ru.kpfu.itis.sharipova.entities.Post;
import ru.kpfu.itis.sharipova.entities.User;
import ru.kpfu.itis.sharipova.repositories.PostRepository;

/**
 * Created by Baths on 10.11.2015.
 */
public class PostsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session= req.getSession();
        User user = (User) session.getAttribute("user");
        if(user==null) resp.sendRedirect("/login");
        List<Post> posts = new ArrayList<>();
        try {
            posts = PostRepository.getAllPosts();

        } catch (SQLException e) {
            req.setAttribute("message","Sorry, some problems with server(");
            e.printStackTrace();
        }
        req.setAttribute("posts", posts);
        req.getServletContext().getRequestDispatcher("/WEB-INF/views/posts.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String textForPost = req.getParameter("post");
        if ("".equals(textForPost) || textForPost == null){
            return;
        }
        HttpSession session = req.getSession();
        User user = (User)session.getAttribute("user");
        Post post = new Post(textForPost, user.getId());
        post.setUserName(user.getEmail());

        try {
            int id = PostRepository.addPost(post);
            post.setId(id);
            String data = getPostJSON(post);
            if ("".equals(data)){
                return;
            }
            resp.setCharacterEncoding("utf-8");
            resp.setContentType("application/json");
            resp.getWriter().write(data);

        } catch (SQLException e) {
            req.setAttribute("message","problems in server");
            e.printStackTrace();
        }
    }

    private static String getPostJSON(Post post){

        try(StringWriter sWriter  = new StringWriter()) {

            JSONObject obj = new JSONObject();

            obj.put("userName",post.getUserName());
            obj.put("postText",post.getText());
            obj.put("pTime",post.getPublishedTime());
            obj.put("id",post.getId());

            obj.write(sWriter);
            return sWriter.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

}

package ru.kpfu.itis.sharipova.repositories;

import ru.kpfu.itis.sharipova.entities.Post;
import ru.kpfu.itis.sharipova.entities.User;
import ru.kpfu.itis.sharipova.utils.MysqlConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.*;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Baths on 10.11.2015.
 */
public class PostRepository {
    public static int addPost(Post post) throws SQLException {
        Connection conn = MysqlConnect.getDbCon().conn;
        StringBuilder sqlQuery = new StringBuilder("insert into posts(text,date,user_id) ")
                .append("values(?,?,?);");

        PreparedStatement p = conn.prepareStatement(sqlQuery.toString(),Statement.RETURN_GENERATED_KEYS);

        p.setNString(1, post.getText());

        p.setString(2, post.getPublishedTime());
        p.setInt(3,post.getUser());

        p.executeUpdate();

        ResultSet set = p.getGeneratedKeys();
        if (set.next()){
            return set.getInt(1);
        }
        return -1;

    }
    public static List<Post> getAllPosts() throws SQLException {
        Connection conn = MysqlConnect.getDbCon().conn;
        ResultSet set = conn.createStatement()
                .executeQuery("select * from posts");

        List<Post> posts = new LinkedList<>();
        while (set.next()){
            int id      = set.getInt(1);
            String text = set.getNString(2);
            Date date   = set.getDate(3);
            Time time   = set.getTime(3);
            int user_id = set.getInt(4);

            Post post = new Post(id,text,date.toString()+"  " + time.toString(),user_id);
            User user = UserRepository.getUserById(user_id);
            if (user != null){
                post.setUserName(user.getEmail());

                posts.add(post);
            }
        }
        return posts;
    }


}

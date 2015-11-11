package ru.kpfu.itis.sharipova.repositories;

import ru.kpfu.itis.sharipova.exceptions.*;
import ru.kpfu.itis.sharipova.entities.User;
import ru.kpfu.itis.sharipova.utils.MysqlConnect;

import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ru.kpfu.itis.sharipova.utils.*;

/**
 * Created by Baths on 12.10.2015.
 */
public class UserRepository {

    public static User identifyUser(String email, String password) throws IdentityException, SQLException {
        Connection conn = MysqlConnect.getDbCon().conn;
        PreparedStatement p = conn.prepareStatement("SELECT * FROM users WHERE (email=?)");
        p.setString(1, email);
        ResultSet set = p.executeQuery();
        if (!set.next())
            throw new IdentityException("No such user");
        int entryId = set.getInt("id");
        String entryEmail = set.getString("email");
        String entryPass = set.getString("password");
        String entryGender = set.getString("gender");
        String entrySubs = set.getString("subscribe");
        String entryAbout = set.getString("aboutMe");
        String entrySalt = set.getString("salt");
        if (!SecurityService.validate(password, entryPass, entrySalt))
            throw new IdentityException("Wrong email or password");
        return new User(entryId, entryEmail, entryPass, entryGender, entrySubs, entryAbout, entrySalt);

    }

    public static User getUserById(int id) throws SQLException {
        Connection conn = MysqlConnect.getDbCon().conn;
        String s = "select * from users where `id` =" +id +";";
        PreparedStatement ps = conn.prepareStatement(s);
//        ps.setInt(1, id);

        ResultSet set = ps.executeQuery();

        if (set.next()){
            int cID      = set.getInt(1);
            String e     = set.getString(2);
            String p     = set.getString(3);
            String salt  = set.getString(4);
            String sex   = set.getString(5);
            String subs  = set.getString(6);
            String about = set.getNString(7);
            return new User(cID,e,p,salt,sex,subs,about);
        }
        return null;
    }
    public static void addUser(User user) throws NotValidEmailException, ShortPasswordException, LongPasswordException,
            DuplicateEntryException {
        emailCheck(user.getEmail());
        passwCheck(user.getPassword());
        if (user.getSubscribe() == null) {
            user.setSubscribe("off");
        }
        StringBuilder sqlQuery = new StringBuilder("insert into users(email,password,gender,subscribe," +
                "aboutMe, salt)")
                .append(" values (?,?,?,?,?,?);");
        Connection conn = MysqlConnect.getDbCon().conn;
        String salt = SecurityService.getSalt();
        String heshedPas = SecurityService.getHesh(user.getPassword(), salt);
        try {
            PreparedStatement p = conn.prepareStatement(sqlQuery.toString());
            p.setString(1, user.getEmail());
            p.setString(2, heshedPas);
            p.setString(3, user.getGender());
            p.setString(4, user.getSubscribe());
            p.setNString(5, user.getAboutMe());
            p.setString(6, salt);
            p.executeUpdate();
            p.close();
        } catch (SQLException e) {
            if (e.getErrorCode() == 1062) throw new DuplicateEntryException(
                    "This user is already exists");
        }


    }

    protected static void emailCheck(String email) throws NotValidEmailException {
        Pattern pattern = Pattern.compile("((?:\\w+(?:\\-|\\.)?)+)@((?:\\w{2,}\\.)+\\w{2,6})");
        Matcher matcher = pattern.matcher(email);
        if (!matcher.matches()) throw new NotValidEmailException("Email is not valid");
    }

    protected static void passwCheck(String pass) throws ShortPasswordException, LongPasswordException {
        if (pass.length() < 4) throw new ShortPasswordException("Password is too short");
        if (pass.length() > 16) throw new LongPasswordException("Password is too long");
    }

    protected String datacheck(String str) {
        return str.replace(' ', '$');
    }

}

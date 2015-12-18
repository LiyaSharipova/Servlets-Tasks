import utilities.DBService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Baths on 22.11.2015.
 */
public class test {
    public static void main(String[] args) {
        Connection connection = DBService.connect();
        try {
            PreparedStatement statement = connection.prepareStatement("select * FROM PATIENT ");
            ResultSet set=statement.executeQuery();
//            while (set.next()){
//                System.out.print(set.getInt(1));
//
//            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

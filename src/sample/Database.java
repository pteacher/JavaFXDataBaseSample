package sample;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database {
    final static String DATABASE_URL = "jdbc:postgresql://localhost:5432/books";
    final static String user = "ruslan";
    final static String pass = "123123123";
    final static String SELECT_QUERY =
            "SELECT authorID, firstName, lastName FROM authors";

    public static List<Authors> init() {
        Statement statement = null;
        List<Authors> authors = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(DATABASE_URL, user, pass);
            statement = connection.createStatement();
            ResultSet res = statement.executeQuery(SELECT_QUERY);

            while (res.next()) {
                Authors a = new Authors();
                a.setAuthorId(Integer.toString(res.getInt("authorID")));
                a.setFirstName(res.getString("firstName"));
                a.setLastName(res.getString("lastName"));
                authors.add(a);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return authors;
    }


}

package sample;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database {
    final static String DATABASE_URL = "jdbc:postgresql://localhost:5432/books";
    final static String user = "ruslan";
    final static String pass = "123123123";
    final static String SELECT_QUERY =
            "SELECT authorID, firstName, lastName FROM authors LIMIT 15";
    static Connection connection = null;

    public static List<Authors> init() {
        Statement statement = null;
        List<Authors> authors = new ArrayList<>();
        try {
            if (connection == null) {
                connection = DriverManager.getConnection(DATABASE_URL, user, pass);
            }
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


    public static void addAuthor(Authors author) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO Authors (firstname, lastname) " + "VALUES ('" + author.getFirstName() +"','" + author.getLastName() + "')");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void deleteAuthor(int id) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM Authors WHERE authorid=" + Integer.toString(id));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


}

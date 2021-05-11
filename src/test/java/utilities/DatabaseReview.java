package utilities;



import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DatabaseReview {

    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;
    public static final String Url = "jdbc:mysql://localhost:3306/mysql";
    public static final String Username = "root";
    public static final String Password = "1234";

    public static Connection createConnection() {

        try {
            connection= DriverManager.getConnection(Url,Username,Password);
            if (connection != null) {
                System.out.println("EN: Connected to the database...");
                System.out.println("TR: Database e baglanildi...");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("SQL Exception " + e.getStackTrace());
            System.out.println("EN: Database connection failed");
            System.out.println("TR: Database baglantisi kurulamadi.");
        }
        return connection;
    }

    public static void sorgu(){
        createConnection();
        try {
            statement=connection.createStatement();
            resultSet=statement.executeQuery("select * from newschema.categories");

            while(resultSet.next()){
                System.out.println(resultSet.getString("category_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws SQLException {
        createConnection();
        sorgu();

    }
}

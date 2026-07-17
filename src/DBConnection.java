import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/library_db";
    private static final String USER = "root";
    private static final String PASSWORD = "Library@123";

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);

            System.out.println("Database Connected Successfully");
            return con;

        } catch (Exception e) {
            System.out.println("Connection Failed!");
            e.printStackTrace();
            return null;
        }
    }
}
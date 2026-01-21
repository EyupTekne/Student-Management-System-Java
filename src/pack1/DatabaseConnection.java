package pack1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static Connection connect() {
        Connection conn = null;
        try {
            String url = "jdbc:mysql://localhost:3306/ogrenci_sistemi";
            String user = "root";
            String password = "Your_Password"; 
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Bağlantı başarılı!");
        } catch (Exception e) {
            System.out.println("Bağlantı hatası: " + e.getMessage());
            e.printStackTrace();
        }
        return conn;
    }
}


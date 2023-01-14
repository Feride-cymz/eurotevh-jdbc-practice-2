package jdbcTest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class InsertTable {
    public static void main(String[] args) throws SQLException {
        String dbUrl = "jdbc:mysql://localhost:3306/kurs";
        String dbUsername = "root";
        String dbPassword = "Kayram.1994";

        try(
                Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
                Statement stmt = connection.createStatement(); ) {

            String sql = "INSERT INTO kurs.ogrenci (ad,soyad,ders,notu) VALUES ('Tolga', 'VONA','SQL',85) ";
            System.out.println(sql);
            stmt.executeUpdate(sql);
            System.out.println("Table insert tamam...");
            stmt.close();
            connection.close();

        } catch (
                SQLException e) {
            e.printStackTrace();
        }

    }
}




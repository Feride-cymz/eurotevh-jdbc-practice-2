package jdbcTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {
    public static void main(String[] args) throws SQLException {
    String dbUrl = "jdbc:mysql://localhost:3306/kurs";
    String dbUsername = "root";
    String dbPassword = "Kayram.1994";

        try(
    Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
    Statement stmt = connection.createStatement(); ) {

        String sql = "CREATE TABLE kurs.ogrenci (id INT NOT NULL AUTO_INCREMENT,\n" +
                "ad VARCHAR(45),\n"+
                "soyad VARCHAR(45),\n"+
                "ders VARCHAR(30),\n"+
                "notu INT,\n"+
                "PRIMARY KEY (id))";
        stmt.executeUpdate(sql);
        System.out.println("Table oluşturma tamam...");
        stmt.close();
        connection.close();

    } catch (
    SQLException e) {
        e.printStackTrace();
    }

}
}

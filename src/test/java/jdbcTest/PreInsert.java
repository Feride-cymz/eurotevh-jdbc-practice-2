package jdbcTest;

import java.sql.*;


public class PreInsert {
    public static void main(String[] args) throws SQLException {
        String dbUrl = "jdbc:mysql://localhost:3306/kurs";
        String dbUsername = "root";
        String dbPassword = "Kayram.1994";

        String sql = "INSERT INTO ogrenci(ad,soyad,ders,notu) VALUES" + "(?,?,?,?)";

        try (Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {
            preparedStatement.setString(1, "Burak");
            preparedStatement.setString(2, "Kaya");
            preparedStatement.setString(3, "Java");
            preparedStatement.setInt(4, 65);
            preparedStatement.executeUpdate();
            System.out.println("insert table tamam");
            preparedStatement.close();
            connection.close();

        } catch (
                SQLException e) {
            e.printStackTrace();
        }

    }
}

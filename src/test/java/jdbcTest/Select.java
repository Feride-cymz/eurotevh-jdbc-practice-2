package jdbcTest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Select {
    public static void main(String[] args) throws SQLException,SQLException {
        String dbUrl = "jdbc:mysql://localhost:3306/kurs";
        String dbUsername = "root";
        String dbPassword = "Kayram.1994";


        Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);

        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        ResultSet resultSet = statement.executeQuery("SELECT * FROM ogrenci");

        resultSet.afterLast();

        while (resultSet.previous()) {
            System.out.println(resultSet.getInt(1) + "-" + resultSet.getString(2) + "-" + resultSet.getString(3) +
                    "-" + resultSet.getString(4) + "-" + resultSet.getInt(5));
        }
        resultSet.close();
        statement.close();
        connection.close();
    }

}

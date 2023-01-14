package jdbcTest;
import java.sql.*;

public class Callable_statment {

    public static void main(String[] args) throws SQLException, SQLException {
        String dbUrl = "jdbc:mysql://localhost:3306/kurs";
        String dbUsername = "root";
        String dbPassword = "Kayram.1994";


        Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        CallableStatement callableStatement = connection.prepareCall("CALL kurs.Sp_ogrenci_select");
        ResultSet resultSet = callableStatement.executeQuery();

        while (resultSet.next()) {
            System.out.println(resultSet.getInt(1) + "-" + resultSet.getString(2) + "-" + resultSet.getString(3) +
                    "-" + resultSet.getString(4) + "-" + resultSet.getInt(5));
        }
        resultSet.close();
        callableStatement.close();
        connection.close();
    }


}


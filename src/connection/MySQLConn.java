package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConn {
    public static Connection getMySQLConnection() throws SQLException, ClassNotFoundException {
        String hostName = "localhost";
        String dbName = "mydbtest";
        String userName = "root";
        String password = "root";
        return getMySQLConnection(hostName, dbName, userName, password);
    }

    private static Connection getMySQLConnection(String hostName, String dbName, String userName, String password) throws ClassNotFoundException, SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
//        String connectionURL = "jdbc:mysql://" + hostName
//                +":3306/" + dbName + "?useUnicode=true&useSSL=false&useJDBCCompliantTimezoneShift=true" +
//        "&useLegacyDatetimeCode=false&serverTimezone=UTC";
       final String connectionURL = "jdbc:mysql://localhost:3306/mydbtest?useUnicode=true&useSSL=false&useJDBCCompliantTimezoneShift=true" +
                "&useLegacyDatetimeCode=false&serverTimezone=UTC";
        Connection connection = DriverManager.getConnection(connectionURL, userName, password);
        return connection;
    }
}

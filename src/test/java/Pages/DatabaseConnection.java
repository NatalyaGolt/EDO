package Pages;

import java.sql.*;

public class DatabaseConnection extends BeforeAndAfter{

    Connection connection;
    Statement statement;
    ResultSet resultSet;

    String dbClass = "org.postgresql.Driver";
    String dbUrlTestKf2024 = "jdbc:postgresql://10.69.0.47:5220/edokf";
    String dbLoginTestKf2024 = "support";
    String dbPasswordTestKf2024 = "Ztcnmhen!";

    public void connectDbEdoTestKf2024() {
        try {
            Class.forName(dbClass);
            connection = DriverManager.getConnection(dbUrlTestKf2024, dbLoginTestKf2024, dbPasswordTestKf2024);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void closeConnectionDbEdoTestKf2024() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}

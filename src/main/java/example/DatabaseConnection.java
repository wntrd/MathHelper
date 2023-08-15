package example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

        private static final String URL = "jdbc:mysql://localhost:3306/expressions";
        private static final String USER = "root";
        private static final String PASSWORD = "1234";

        public static Connection getConnection() {
            Connection connection = null;
            try {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);

                if (connection != null) {
                    System.out.println("Приєднано до бази даних");
                } else {
                    System.out.println("Не вдалося приєднатись до бази даних");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return connection;
    }
}

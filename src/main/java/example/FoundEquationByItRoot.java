package example;

import java.sql.*;

public class FoundEquationByItRoot {
    public static void findEquationsByRoot(String root) throws SQLException {
        Connection connection = DatabaseConnection.getConnection();

        String expressionRoot = root;

        String sql = "SELECT * FROM expressions WHERE expressionRoot LIKE CONCAT(?, '%')";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, expressionRoot);

            ResultSet resultSet = preparedStatement.executeQuery();

            System.out.println("Ось рівняння які мені вдалося знайти під коренем " + root);
            while (resultSet.next()) {
                String expression = resultSet.getString("expression");
                System.out.println(expression);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

package example;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class AddExpressionToDatabase {
    public static void addExpression(String equation) throws SQLException {
        if (ExpressionChecker.checkExpression(equation)) {
            Connection connection = DatabaseConnection.getConnection();

            Statement statement = connection.createStatement();

            statement.executeUpdate("insert into expressions (expression) values ('"+ equation +"')");
            System.out.println("Рівняння " + equation + " було додане до бази даних");
        }
    }
}

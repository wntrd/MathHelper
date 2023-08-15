package example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;



public class CheckRootsAndAddToDatabase {
    public static boolean checkRoots(String equation, String root) {


            String toCharEquals = "";
            String afterCharEquals = "";
            int counter = 0;

            List<String> list = new ArrayList<>();
            list = List.of(equation.split(""));

            for (String str : list) {
                if (Objects.equals(str, "=")) {
                    break;
                } else if (!Objects.equals(str, "x")) {
                    toCharEquals += str;
                } else {
                    toCharEquals += root;
                }
            }

            for (String str : list) {
                if (Objects.equals(str, "=")) {
                    counter++;
                    continue;
                }
                if (counter == 1) {
                    afterCharEquals += str;
                }
            }

            String expressionText = toCharEquals;
            List<Lexeme> lexemes = LexemeBuffer.lexAnalyze(expressionText);
            LexemeBuffer lexemeBuffer = new LexemeBuffer(lexemes);

            if(LexemeBuffer.expr(lexemeBuffer) == Integer.parseInt(afterCharEquals)) {
                System.out.println("Ви ввели правильний корінь");
                return true;
            } else {
                System.out.println("Ви ввели неправильний корінь, АБО можливо, ви записали рівняння у вигляді 5х(3+5)=2, для коректного підрахування коренів запишіть його у вигляді 5*x*(3+5)=2");
                return false;
            }
        }

    public static void addRoots(String equation, String root) throws SQLException {


        if (checkRoots(equation, root)) {
            Connection connection = DatabaseConnection.getConnection();

            String getCountSql = "SELECT COUNT(*) FROM expressions";

            try (Statement countStatement = connection.createStatement()) {
                ResultSet countResultSet = countStatement.executeQuery(getCountSql);

                if (countResultSet.next()) {
                    int rowCount = countResultSet.getInt(1);

                    String updateSql = "UPDATE expressions SET expressionRoot = ? WHERE id = ?";
                    try (PreparedStatement updateStatement = connection.prepareStatement(updateSql)) {
                        updateStatement.setString(1, root);
                        updateStatement.setInt(2, rowCount);
                        updateStatement.executeUpdate();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            System.out.println("Корінь " + root + " був доданий до бази даних для рівнння " + equation);


        }
    }
    }


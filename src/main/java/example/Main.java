package example;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        //Я реалізував програму тільки так, що рівняння може бути записаним тільки без пропусків знака *, тобто програма не зможе порахувати корені
        //рівняння записаного у вигляді 5x=10 або 5(x+3)=10, потрібно їх записувати у вигляді 5*x=10 і 5*(x+3)=10
        //але це не стосується перевірки на правильніть введення рівняння, воно запишеться у базу даних навіть за такої умови

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть рівняння для перевірки : ");
        String inputExpression = scanner.nextLine();

        try {
            AddExpressionToDatabase.addExpression(inputExpression);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Введіть корінь для перевірки : ");
        String root = scanner.nextLine();

        try {
            CheckRootsAndAddToDatabase.addRoots(inputExpression, root);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Введіть корінь за яким хочете знайти рівняння : ");
        String findEquationByRoot = scanner.nextLine();

        try{
            FoundEquationByItRoot.findEquationsByRoot(findEquationByRoot);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Я порахував кількість чисел в рівнянні : " + NumbersCounter.numbersCounter(inputExpression));

    }
}

package example;

import java.util.Stack;

public class ExpressionChecker {

    //Перевіряти введене рівняння на коректність розміщення дужок

    public static boolean checkBrackets(String equation) {
        Stack<Character> stack = new Stack<>();

        for (char brackets : equation.toCharArray()) {
            if (brackets == '(') {
                stack.push(brackets);
            } else if (brackets == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                char lastBracket = stack.pop();
                if ((brackets == ')' && lastBracket != '(')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    //Перевіряти коректність введеного виразу (не повинно бути 2 знаків
    //математичних операцій поспіль, наприклад, неприпустимий вираз 3+*4, в той
    //же час, вираз 4*-7 є допустимим)

    public static boolean checkSymbols(String equation) {

        for (int i = 1; i < equation.length(); i++) {
            char previousSymbol = equation.charAt(i - 1);
            char thisSymbol = equation.charAt(i);

            if ((previousSymbol == '+' || previousSymbol == '-' || previousSymbol == '*' || previousSymbol == '/') && (thisSymbol == '+' || thisSymbol == '*' || thisSymbol == '/')) {
                return false;
            } else if (previousSymbol == '-' && thisSymbol == '-') {
                return false;
            } else if (!equation.contains("=")){
                return false;
            } else if (thisSymbol == '=' && i == equation.length() - 1){
                return false;
            }
        }
        return true;
    }

    public static boolean checkExpression(String equation) {
        if (ExpressionChecker.checkBrackets(equation) && ExpressionChecker.checkSymbols(equation)) {
            System.out.println("Ваше рівняння записано коректно");
            return true;
        } else if (!ExpressionChecker.checkBrackets(equation) && !ExpressionChecker.checkSymbols(equation)) {
            System.out.println("В вашому рівнянні помилка в дужках і символах");
            return false;
        } else if (!ExpressionChecker.checkBrackets(equation)) {
            System.out.println("В вашому рівнянні помилка в дужках");
            return false;
        } else if (!ExpressionChecker.checkSymbols(equation)) {
            System.out.println("В вашому рівнянні помилка в символах");
            return false;
        }
        return false;
    }
}

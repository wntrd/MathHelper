package example;
import java.util.regex.*;
public class NumbersCounter {

    //Додаткове завдання
    //Порахувати кількість чисел у рівнянні, введеному користувачем

    public static int numbersCounter(String equation){

        String numberPattern = "\\d+(\\.\\d+)?";

        Pattern pattern = Pattern.compile(numberPattern);
        Matcher matcher = pattern.matcher(equation);

        int count = 0;
        while (matcher.find()) {
            count++;
        }

        return count;
    }
}

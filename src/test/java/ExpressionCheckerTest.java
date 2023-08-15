import static org.junit.jupiter.api.Assertions.*;

import example.ExpressionChecker;
import org.junit.jupiter.api.Test;

public class ExpressionCheckerTest {
    @Test
    void testCheckBrackets() {
        assertTrue(ExpressionChecker.checkBrackets("(3 + 4) * (5 - 2) = 12"));
        assertTrue(ExpressionChecker.checkBrackets("((x + 2) * 1)= 12"));

        assertFalse(ExpressionChecker.checkBrackets("(3 + 4) * (5 - = 12"));
        assertFalse(ExpressionChecker.checkBrackets("(3 + 4) * )5 - 2(= 12"));
        assertFalse(ExpressionChecker.checkBrackets("3 + 4) * (5 - 2)= 12"));
        assertFalse(ExpressionChecker.checkBrackets("(3 + 4) * (5 - 2))= 12"));
    }

    @Test
    void testCheckSymbols() {
        assertFalse(ExpressionChecker.checkSymbols("3 + 4 * x / 2 = 6 ="));
        assertFalse(ExpressionChecker.checkSymbols("3 + 4 * 5 / 2"));
        assertFalse(ExpressionChecker.checkSymbols("3 ++ x * 5 / 2 = 12"));
        assertFalse(ExpressionChecker.checkSymbols("3 +* 4 * x / 2 = 12"));
        assertFalse(ExpressionChecker.checkSymbols("4 ** 5 / x = 12 "));

        assertTrue(ExpressionChecker.checkSymbols("3 + 4 * 5 /= 12"));
        assertTrue(ExpressionChecker.checkSymbols("3 + x * 5 / 2 =12"));
        assertTrue(ExpressionChecker.checkSymbols("4 * -x = 10"));

    }
}


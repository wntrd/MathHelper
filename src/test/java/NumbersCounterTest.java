import static org.junit.jupiter.api.Assertions.*;

import example.NumbersCounter;
import org.junit.jupiter.api.Test;

public class NumbersCounterTest {
    @Test
    void testNumbersCounter() {
        assertEquals(3, NumbersCounter.numbersCounter("2*x+5=13"));
        assertEquals(5, NumbersCounter.numbersCounter("2*x+5+10/11=13"));
        assertEquals(2, NumbersCounter.numbersCounter("13*x=10"));
        assertEquals(4, NumbersCounter.numbersCounter("2*x*(5+12)=10"));
        assertEquals(11, NumbersCounter.numbersCounter("2+1*x+5+5+5+5+5+5+5+5=13"));
    }
}

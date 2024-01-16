package dataProviders.tests;

import com.calculator.Calculator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CalculatorTest {
    static Calculator calculator;

    @BeforeClass
    public void setup() {
        calculator = new Calculator();
    }

    @Test
    public void testAddingPositiveNumbers()
    {
        
    }
}

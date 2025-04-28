import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for CalcEngine.
 * Covers add, subtract, multiply, divide, division by zero, clear, toggleSign.
 */
public class CalcEngineTest
{
    private CalcEngine calc;

    @Before
    public void setUp()
    {
        calc = new CalcEngine();
    }

    @Test
    public void testAddition()
    {
        calc.numberPressed(2);
        calc.plus();
        calc.numberPressed(3);
        calc.equals();
        assertEquals("5", calc.getDisplayValue());
    }

    @Test
    public void testSubtraction()
    {
        calc.numberPressed(9);
        calc.minus();
        calc.numberPressed(4);
        calc.equals();
        assertEquals("5", calc.getDisplayValue());
    }

    @Test
    public void testMultiplication()
    {
        calc.numberPressed(6);
        calc.multiply();
        calc.numberPressed(7);
        calc.equals();
        assertEquals("42", calc.getDisplayValue());
    }

    @Test
    public void testDivision()
    {
        calc.numberPressed(8);
        calc.divide();
        calc.numberPressed(2);
        calc.equals();
        assertEquals("4", calc.getDisplayValue());
    }

    @Test
    public void testDivisionByZero()
    {
        calc.numberPressed(5);
        calc.divide();
        calc.numberPressed(0);
        calc.equals();
        assertEquals("ERROR", calc.getDisplayValue());
    }

    @Test
    public void testClear()
    {
        calc.numberPressed(8);
        calc.clear();
        assertEquals("0", calc.getDisplayValue());
    }

    @Test
    public void testToggleSign()
    {
        calc.numberPressed(3);
        calc.toggleSign();
        assertEquals("-3", calc.getDisplayValue());
        
        calc.toggleSign();
        assertEquals("3", calc.getDisplayValue());
    }

    @Test
    public void testChainedOperations()
    {
        calc.numberPressed(2);
        calc.plus();
        calc.numberPressed(3);
        calc.multiply();
        calc.numberPressed(4);
        calc.minus();
        calc.numberPressed(8);
        calc.divide();
        calc.numberPressed(3);
        calc.equals();
        assertEquals("4", calc.getDisplayValue());
    }
}

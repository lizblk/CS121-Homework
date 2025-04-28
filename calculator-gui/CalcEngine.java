/**
 * A smarter calculator engine that supports chaining operations, negative numbers, and more operations.
 * Also accounts for certain errors/illegal calculations.
 * 
 * @author: Liz
 * @version 2.0
 */
public class CalcEngine
{
    private int displayValue;       //current value shown
    private int lastValue;          //previous value stored
    private char pendingOperator;   //operator waiting to be applied
    private boolean waitingForNewNumber; //true if user just pressed an operator
    private String errorMessage;    //error when doing an illegal calculation
    
    /**
     * Create a CalcEngine.
     */
    public CalcEngine()
    {
        clear();
    }

    /**
     * @return The value that should currently be displayed
     * on the calculator display.
     */
    public String getDisplayValue()
    {
        if (errorMessage != null) {
            return errorMessage;
        } else {
            return Integer.toString(displayValue);
        }
    }
    
    /**
     * A number button was pressed.
     * @param number The number pressed
     */
    public void numberPressed(int number)
    {
        if (waitingForNewNumber) {
            //starting a new number (after operator)
            displayValue = number;
            waitingForNewNumber = false;
        }
        else {
            //continue typing digits
            if (displayValue >= 0) {
            displayValue = displayValue * 10 + number;}
            else {displayValue = displayValue * 10 - number;}
        }
    }

    /**
     * The 'plus' button was pressed. 
     */
    public void plus()
    {
        applyPendingOperation();
        pendingOperator = '+';
        waitingForNewNumber = true;
    }

    /**
     * The 'minus' button was pressed.
     */
    public void minus()
    {
        applyPendingOperation();
        pendingOperator = '-';
        waitingForNewNumber = true;
    }

    /**
     * The '=' button was pressed.
     */
    public void equals()
    {
        applyPendingOperation();
        pendingOperator = ' ';
        waitingForNewNumber = true;
    }
    
    public void multiply()
    {
        applyPendingOperation();
        pendingOperator = '*';
        waitingForNewNumber = true;
    }
    
    public void divide()
    {
        applyPendingOperation();
        pendingOperator = '/';
        waitingForNewNumber = true;
    }
    
    /**
    * Toggle the sign (positive/negative) of the current display value.
     */
    public void toggleSign()
    {
        displayValue = -displayValue;
    }

    /**
     * The 'C' (clear) button was pressed.
     */
    public void clear()
    {
        displayValue = 0;
        lastValue = 0;
        pendingOperator = ' ';
        waitingForNewNumber = true;
        errorMessage = null;
    }

    /**
     * Apply the pending operator to lastValue and displayValue.
     */
    private void applyPendingOperation()
    {
        if (pendingOperator == '+')
        {
            displayValue = lastValue + displayValue;
        }
        else if (pendingOperator == '-')
        {
            displayValue = lastValue - displayValue;
        }
        else if (pendingOperator == '*') {
        displayValue = lastValue * displayValue;
    }
    else if (pendingOperator == '/') {
        if (displayValue != 0) {
            displayValue = lastValue / displayValue;
        }
        else {
            errorMessage = "ERROR";
            displayValue = 0; // or maybe show an error somehow later
        }
    }
        lastValue = displayValue;
    }
 
    /**
     * @return The title of this calculation engine.
     */
    public String getTitle()
    {
        return "Slightly Improved Calculator";
    }

    /**
     * @return The author of this engine. This string is displayed as it is,
     * so it should say something like "Written by H. Simpson".
     */
    public String getAuthor()
    {
        return "texas instruments (liz)";
    }

    /**
     * @return The version number of this engine. This string is displayed as 
     * it is, so it should say something like "Version 1.1".
     */
    public String getVersion()
    {
        return "2.0";
    }
}

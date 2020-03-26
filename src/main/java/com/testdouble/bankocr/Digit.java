package com.testdouble.bankocr;

import java.util.List;

/**
 * Digit contains the integer representation and the parsing logic
 * for a single digit input as a 3 column wide, 4 row tall collection of 
 * Strings.
 * 
 * @author Glenn Dayton
 * @version 1.0
 * @since 1.0
 */
public class Digit implements DigitInterface
{

    private int digit;

    /**
     * Base constructor for Digit, sets the integer representation 
     * as -1, an invalid digit.
     */
    public Digit()
    {
        digit = -1;
    }

    /**
     * Constructor for setting Digit to a predefined integer passed 
     * in constructor.
     * 
     * @param _digit An integer that digit represents.
     */
    public Digit(int _digit)
    {
        digit = _digit;
    }

    /**
     * Constructor for invoking parsing logic for 3x4 passed List 
     * of Strings.
     * 
     * @param lines List of Strings representaing a single digit.
     */
    public Digit(List<String> lines) 
    {
        digit = parseDigit(lines);
    }

    /**
     * This method parses a 3x4 List of Strings representing a digit.
     * 
     * @param lines 3x4 List of Strings representing unparsed digit.
     * @return Integer representation of a Stringified digit.
     * @since 1.0
     */
    public int parseDigit(List<String> lines) 
    {
        String flattened = lines.get(0) + lines.get(1) + lines.get(2);

        switch(flattened) 
        {
            case " _ | ||_|": return 0;
            case "     |  |": return 1;
            case " _  _||_ ": return 2;
            case " _  _| _|": return 3;
            case "   |_|  |": return 4;
            case " _ |_  _|": return 5;
            case " _ |_ |_|": return 6;
            case " _   |  |": return 7;
            case " _ |_||_|": return 8;
            case " _ |_| _|": return 9;
            default: return -1;
        }
    }

    /**
     * {@inheritDoc}
     * 
     * Getter method for the integer representation of digit.
     * 
     * @return Integer representation of Digit object.
     * @since 1.0
     */
    public int getDigit()
    {
        return this.digit;
    }

     /**
     * {@inheritDoc}
     * 
     * This method was overriden for use in the Entry method in search for 
     * an invalid digit. equals() determines if one digit object is equal to another.
     * 
     * @param o Object that is being compared to current object.
     * @return Returns true or false if one digit object is equal to another.
     * @since 1.0
     */
    @Override
    public boolean equals(Object o) 
    {
        if(o instanceof Digit) 
        {
            Digit toCompare = (Digit) o;
            return toCompare.getDigit() == this.digit;
        }
        return false;
    }

}
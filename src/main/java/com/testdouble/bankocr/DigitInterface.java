package com.testdouble.bankocr;

/**
 * This is the interface for the digit class.
 * 
 * @author Glenn Dayton
 * @version 1.0
 * @since 1.0
 */
public interface DigitInterface
{

    /**
     * This method is a getter for the Digit's parsed integer representation.
     * 
     * @return Returns an integer digit
     * @since 1.0
     */
    int getDigit();

    /**
     * This method determines if one Digit object is equal to another.
     *
     * @param o Object that current Digit is being compared to.
     * @return Returns a true/false 
     * @since 1.0
     */
    boolean equals(Object o);

}
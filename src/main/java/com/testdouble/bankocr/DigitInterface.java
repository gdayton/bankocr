package com.testdouble.bankocr;

import java.util.List;

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


    /**
     * Every Digit object has it's own fingerprint which is generated by taking
     * the index of the pipe or underscore from the position that it's located.
     * 
     * @param lines Input a 3x4 List of Strings to determine fingerprint from.
     * @return Returns a fingerprint for the digit
     */
    List<Integer> fingerprint(List<String> lines);

}
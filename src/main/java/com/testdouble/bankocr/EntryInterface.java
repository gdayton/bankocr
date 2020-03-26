package com.testdouble.bankocr;

/**
 * This interface enforces the Entry class to have the below methods.
 * 
 * @author Glenn Dayton
 * @version 1.0
 * @since 1.0
 */
public interface EntryInterface
{

    /**
     * This method determines if an entry contains an invalid integer, -1.
     * @return Returns a boolean value if Entry is valid or not.
     * @since 1.0
     */
    boolean isValid();

    /**
     * This method returns a Stringified representation of the Entry object.
     * @return Returns a String value representing an Entry object.
     * @since 1.0
     */
    String toString();

}
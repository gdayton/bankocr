package com.testdouble.bankocr;

import java.util.List;
import java.util.ArrayList;

/**
 * Entry contains a List of Digit objects. Contans logic for parsing a 
 * stringified entry that's 27x4 characters into 9 3 character wide chunks.
 * 
 * @author Glenn Dayton
 * @version 1.0
 * @since 1.0
 */
public class Entry implements EntryInterface
{
     /**
     * Amount of characters wide a digit is.
     */
    private static final int CHARS_PER_DIGIT = 3;

    /**
     * Amount of characters wide an entry is.
     */
    private static final int CHARS_PER_LINE = 27;

    /**
     * List of parsed Digit objects.
     */
    private List<Digit> digits;

    /** 
     * Base constructor for Entry object. Initializes Entry's entries to 
     * null.
     */
    public Entry()
    {
        digits = null;
    }

    /**
     * Constructor for running parsing logic on entry and setting result to
     * entries.
     * 
     * @since 1.0
     * @param lines A List of 4 lines, each 27 characters long.
     */
    public Entry(List<String> lines) 
    {
        digits = parseEntry(lines);
    }

    /**
     * This method takes in a List of Strings each 27 characters wide and 
     * splits them into 9 3 character wide chunks that will be further parsed
     * down in the Digit parseDigit method.
     * 
     * @since 1.0
     * @param lines A List of 4 lines, each 27 characters long.
     * @return A List of parsed Digit objects.
     */
    public List<Digit> parseEntry(List<String> lines) 
    {
        if(lines.size() == 4) {
            digits = new ArrayList<Digit>();
            List<String> tmpUnparsedDigit = new ArrayList<String>();
            for(int i = 0; i < CHARS_PER_LINE; i += CHARS_PER_DIGIT) 
            {
                int leftBound = i;
                int rightBound = i + CHARS_PER_DIGIT;

                tmpUnparsedDigit.add(0, lines.get(1).substring(leftBound, rightBound));    // [" _ "]
                tmpUnparsedDigit.add(1, lines.get(2).substring(leftBound, rightBound));    // [" _|"]
                tmpUnparsedDigit.add(2, lines.get(3).substring(leftBound, rightBound));    // ["|_ "]

                Digit digit = new Digit(tmpUnparsedDigit);
                digits.add(digit);

                tmpUnparsedDigit.removeAll(tmpUnparsedDigit);
            }

            return digits;
        }
        return null;
    }

    /**
     * This method examines the parsed Digit object and searches for an 
     * invalid digit, -1. If it occurs, the entry is invalid, false.
     * 
     * @since 1.0
     * @return Returns a true/false boolean value based on if entry contains -1.
     */
    public boolean isValid() 
    {
        if(digits != null) 
        {
            Digit invalidDigit = new Digit(-1);
            return !digits.contains(invalidDigit);
        }
        return false;
    }

    /**
     * This method computes the checksum of the entry. 
     * @return Returns the checksum of the entry, if the entry is invalid, -1 is returned
     * @since 1.1
     */
    public int checksum()
    {
        if(this.isValid() && digits.size() == 9) {
            int sum = 0;
            sum +=  digits.get(8).getDigit() * 1;
            sum +=  digits.get(7).getDigit() * 2;
            sum +=  digits.get(6).getDigit() * 3;
            sum +=  digits.get(5).getDigit() * 4;
            sum +=  digits.get(4).getDigit() * 5;
            sum +=  digits.get(3).getDigit() * 6;
            sum +=  digits.get(2).getDigit() * 7;
            sum +=  digits.get(1).getDigit() * 8;
            sum +=  digits.get(0).getDigit() * 9;
            return sum;
        }

        return -1;
    }

    /**
     * This method calls the checksum method, but mods the result by 11. If it 
     * equals 0, then its a valid checksum.
     * @return true/false if it's a valid checksum.
     * @since 1.1
     */
    public boolean validChecksum() 
    {
        int chk = checksum();

        return chk % 11 == 0;
    }


    /**
     * This method iterates through all Digits and calls their toString() 
     * methods concatenating them into a final Entry string. If the String
     * contains an invalid Entry "ILL" is appended.
     * 
     * @since 1.0
     * @return String representing Entry
     */
    public String toString() 
    {
        if(digits != null) {
            String s = "";
            for(Digit digit: digits)
                s += digit.getDigit() != -1 ? digit.getDigit() : "?";
            s+= isValid() ? (validChecksum() ? "" : " ERR") : " ILL";
            return s;
        }
        return "";
    }

}
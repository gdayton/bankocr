package com.testdouble.bankocr;

import java.util.List;
import java.util.ArrayList;

public class Entry implements EntryInterface
{
    private static final int CHARS_PER_DIGIT = 3;

    private static final int CHARS_PER_LINE = 27;

    private List<Digit> digits;

    public Entry()
    {
        digits = null;
    }

    public Entry(List<String> lines) 
    {
        digits = parseEntry(lines);
    }

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

    public boolean isValid() 
    {
        if(digits != null) 
        {
            Digit invalidDigit = new Digit(-1);
            return !digits.contains(invalidDigit);
        }
        return false;
    }

    public String toString() 
    {
        if(digits != null) {
            String s = "";
            for(Digit digit: digits)
                s += digit.getDigit() != -1 ? digit.getDigit() : "?";
            s+= isValid() ? "" : " ILL";
            return s;
        }
        return "";
    }

}
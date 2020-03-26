package com.testdouble.bankocr;

import java.util.List;

public class Digit implements DigitInterface
{
    private int digit;

    public Digit()
    {
        digit = -1;
    }

    public Digit(int _digit)
    {
        digit = _digit;
    }

    public Digit(List<String> lines) 
    {
        digit = parseDigit(lines);
    }

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

    public int getDigit()
    {
        return this.digit;
    }

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
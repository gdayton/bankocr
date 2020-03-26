package com.testdouble.bankocr;

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

    public int getDigit()
    {
        return this.digit;
    }

}
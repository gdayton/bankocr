package com.testdouble.bankocr;

public class BankOcr
{

    private static BankOcr bankOcr = new BankOcr();

    private BankOcr()
    {

    }

    public static BankOcr getInstance() 
    {
        return bankOcr;
    }

    public String toString()
    {
        return "";
    }
    
}
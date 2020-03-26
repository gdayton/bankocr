package com.testdouble.bankocr;

import java.util.List;
import java.util.ArrayList;

public class BankOcr
{

    private static BankOcr bankOcr = new BankOcr();

    private static List<Entry> entries;

    private BankOcr()
    {
        entries = new ArrayList<Entry>();
    }

    public static BankOcr getInstance() 
    {
        return bankOcr;
    }

    public List<Entry> entries() {
        return entries;
    }

    public String toString()
    {
        return "";
    }

}
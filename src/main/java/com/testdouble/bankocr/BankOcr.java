package com.testdouble.bankocr;

import java.util.List;
import java.util.ArrayList;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

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

    public List<Entry> readInFile(String filePath) 
    {
        BufferedReader reader;

        List<String> tempUnparsedLines = new ArrayList<String>();

        try {
            int lineNumber = 1;

            reader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(filePath)));

            String line = reader.readLine();
            while(line != null) 
            {
                tempUnparsedLines.add(line);

                if(lineNumber % LINES_PER_ENTRY == 0) 
                {
                    // Reached next entry
                    Entry entry = new Entry(tempUnparsedLines);
                    entries.add(entry);
                    tempUnparsedLines.removeAll(tempUnparsedLines);
                }
 
                lineNumber++;
                line = reader.readLine();
            }

        } catch(IOException e) 
        {
            e.printStackTrace(System.out);
            System.out.println("Error reading in file.");
        }

        return entries;
    }

    public List<Entry> entries() {
        return entries;
    }

    public String toString()
    {
        return "";
    }

}
package com.testdouble.bankocr;

import java.util.List;
import java.util.ArrayList;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * BankOcr is a singleton that contains all the logic for this 
 * application. It's the object instantiated in {@link com.testdouble.bankocrkata.App} 
 * that does all the work in the readInFile method.
 * 
 * @author Glenn Dayton
 * @version 1.0
 * @since 1.0
 * 
 */
public class BankOcr
{
    /**
     * Amount of rows that an entry is comprized of. This includes
     * the blank line that appears on top seperating two entries 
     * from one another. 
     */
    private static final int LINES_PER_ENTRY = 4;

    private static BankOcr bankOcr = new BankOcr();

    /**
     * Location where parsed entries reside as collection of 
     * Entry objects.
     */
    private static List<Entry> entries;

    /**
     * Base constructor for BankOcr, initializes BankOcr with 
     * an empty collection of Entry objects.
     */
    private BankOcr()
    {
        entries = new ArrayList<Entry>();
    }

    /**
     * Returns instance of BankOcr
     * 
     * @return BankOcr instantiated instance.
     * @since 1.0
     */
    public static BankOcr getInstance() 
    {
        return bankOcr;
    }
    
    /**
     * Given a path to a file of formatted entries, returns a parsed
     * collection of Entry objects.
     * 
     * @param filePath Relative location to the entries file (e.g. "entries/1")
     * @return A List of Entry objects that were parsed from a desired file location
     * @since 1.0
     */
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

    /**
     * Getter method for List of entries.
     * 
     * @return Returns a List of Entry objects.
     * @since 1.0
     */
    public List<Entry> entries() {
        return entries;
    }

    /**
     * toString overriden to display all Entry object's toString outputs
     * seperated by a newline character.
     * 
     * @return A stringified List of Entry objects.
     * @since 1.0
     */
    public String toString()
    {
        String s = "";
        for(Entry entry: entries) {
            s += entry;
            s += "\n";
        }
        return s;
    }

}
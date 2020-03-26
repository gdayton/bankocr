package com.testdouble.bankocr;

/**
 * Entrypoint for running the entire application. This class calls upon 
 * the {@link com.testdouble.bankocrkata.BankOcr} singleton class.  
 * 
 * @author Glenn Dayton
 * @version 1.0
 * @since 1.0
 */
public class App 
{
    public static void main( String[] args )
    {
        BankOcr bankOcr = BankOcr.getInstance();
        bankOcr.readInFile("entries/mixed");
        System.out.println(bankOcr);
    }
}

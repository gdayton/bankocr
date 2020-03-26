package com.testdouble.bankocr;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * Unit test for simple App.
 */
@RunWith(MockitoJUnitRunner.class)
public class DigitTest 
{
    @Spy
    Digit spyDigit;

    @Mock
    Digit defaultDigit;

    @Mock
    Digit validDigit;

    @Mock
    Digit invalidDigit;

    @Before
    public void setUp() {
        defaultDigit = new Digit();
        spyDigit = spy(defaultDigit);

        validDigit = new Digit(1);

        List<String> validDigitLines = new ArrayList<String>();
        validDigitLines.add(" _ ");
        validDigitLines.add("|_ ");
        validDigitLines.add("|_|");
        validDigit = new Digit(validDigitLines);

        List<String> invalidDigitLines = new ArrayList<String>();
        invalidDigitLines.add(" _ ");
        invalidDigitLines.add("|_ ");
        invalidDigitLines.add("| |");
        invalidDigit = new Digit(invalidDigitLines);
    }

    @Test
    public void defaultConstructorValid_Default_ShouldReturnInteger()
    {
        assertEquals(validDigit.getDigit(), 6);
    }

    @Test
    public void defaultConstructorValid_Default_ShouldReturnValidInteger()
    {
        assertEquals(invalidDigit.getDigit(), -1);
    }

    @Test
    public void validDigitInvalidNotEqualValid_OffNominalEntry_ShouldReturnFalse()
    {
        assertFalse(validDigit.equals(null));
    }

    @Test
    public void validDigitInvalidNotEqualValid_ValidEntry_ShouldReturnFalse()
    {
        validDigit = new Digit(3);
        Digit compareDigit = new Digit(4);
        assertFalse(validDigit.equals(compareDigit));
    }

    @Test
    public void validDigitValidEqualValid_ValidEntry_ShouldReturnTrue()
    {
        validDigit = new Digit(3);
        Digit compareDigit = new Digit(3);
        assertTrue(validDigit.equals(compareDigit));
    }

    @Test
    public void parseInputNominal_ValidParam_ShouldReturnIntDigits()
    {
        List<String> validDigitLines = new ArrayList<String>();
        validDigitLines.add(" _ ");
        validDigitLines.add("|_|");
        validDigitLines.add("|_|");

        int validResult = spyDigit.parseDigit(validDigitLines);

        assertEquals(validResult, 8);
    }

    @Test
    public void possibleDigits_ValidFingerprint_ShouldReturnPossibleInts()
    {
        List<Integer> validFingerprint = new ArrayList<Integer>(Arrays.asList(2,5,8,9));
        List<Integer> possibleDigits = validDigit.possibleDigits();
        for(int digit: possibleDigits) 
        {
            System.out.println(digit);
        }
    }
}

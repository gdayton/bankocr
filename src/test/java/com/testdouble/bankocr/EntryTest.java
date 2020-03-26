package com.testdouble.bankocr;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

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
public class EntryTest 
{
    @Spy
    Entry spyEntry;

    @Mock
    Entry defaultEntry;

    @Mock
    Entry validEntry;

    @Mock
    Entry invalidEntry;

    @Before
    public void setUp() {
        defaultEntry = new Entry();
        spyEntry = spy(defaultEntry);

        List<String> validEntryData = new ArrayList<String>();
        validEntryData.add("                           ");
        validEntryData.add("    _  _     _  _  _  _  _ ");
        validEntryData.add("  | _| _||_||_ |_   ||_||_|");
        validEntryData.add("  ||_  _|  | _||_|  ||_| _|");
        validEntry = new Entry(validEntryData);

        List<String> invalidEntryData = new ArrayList<String>();
        invalidEntryData.add("                           ");
        invalidEntryData.add("    _  _     _  _  _  _  _ ");
        invalidEntryData.add("  | _  _||_||_ |_   ||_||_|");
        invalidEntryData.add("  ||_  _|  | _ |_|  ||_| _|");
        invalidEntry = new Entry(invalidEntryData);
    }

    @Test
    public void defaultConstructorIsValid_Default_ShouldReturnFalse()
    {
        assertFalse(defaultEntry.isValid());
    }

    @Test
    public void defaultConstructorToString_Default_ShouldReturnBlankString()
    {
        assertEquals(defaultEntry.toString(), "");
    }

    @Test
    public void validEntryIsValid_ValidEntry_ShouldReturnTrue()
    {
        assertTrue(validEntry.isValid());
    }

    @Test
    public void invalidEntryIsValid_InvalidEntry_ShouldReturnFalse()
    {
        assertFalse(invalidEntry.isValid());
    }

    @Test
    public void validEntryToString_ValidEntry_ShouldReturnValidString() 
    {
        final String VALID_TO_STRING = "123456789";
        assertEquals(validEntry.toString(), VALID_TO_STRING);
    }

    @Test
    public void invalidEntryToString_InvalidEntry_ShouldReturnInvalidString() 
    {
        final String INVALID_TO_STRING = "1?34?6789 ILL";
        assertEquals(invalidEntry.toString(), INVALID_TO_STRING);
    }

    @Test 
    public void parseInputEmptyValidParam_EmptyValid_ShouldReturnNull()
    {
        List<String> validInput = new ArrayList<String>();
        assertNull(defaultEntry.parseEntry(validInput));
    }

    @Test 
    public void parseInputNotSize4ValidParam_NotSize4Valid_ShouldReturnNull()
    {
        List<String> validInput = new ArrayList<String>();
        validInput.add("                           ");
        assertNull(defaultEntry.parseEntry(validInput));
    }

    @Test
    public void parseInputNominal_ValidParam_ShouldReturnListOfDigits()
    {
        List<String> validInput = new ArrayList<String>();
        validInput.add("                           ");
        validInput.add("    _  _     _  _  _  _  _ ");
        validInput.add("  | _| _||_||_ |_   ||_||_|");
        validInput.add("  ||_  _|  | _||_|  ||_| _|");

        List<Digit> validResult = spyEntry.parseEntry(validInput);

        List<Digit> validDigits = new ArrayList<Digit>();
        Digit d1 = new Digit(1); validDigits.add(d1);
        Digit d2 = new Digit(2); validDigits.add(d2);
        Digit d3 = new Digit(3); validDigits.add(d3);
        Digit d4 = new Digit(4); validDigits.add(d4);
        Digit d5 = new Digit(5); validDigits.add(d5);
        Digit d6 = new Digit(6); validDigits.add(d6);
        Digit d7 = new Digit(7); validDigits.add(d7);
        Digit d8 = new Digit(8); validDigits.add(d8);
        Digit d9 = new Digit(9); validDigits.add(d9);

        assertEquals(validResult, validDigits);
    }
}

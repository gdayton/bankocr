package com.testdouble.bankocr;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * Unit test for simple App.
 */
@RunWith(MockitoJUnitRunner.class)
public class AppTest 
{
    @InjectMocks
    BankOcr bankOcr;

    @Mock
    Entry entry;

    @Mock
    Digit digit;

    @Captor
    ArgumentCaptor<List<String>> stringCaptor;

    @Before
    public void setUp() {
        bankOcr = BankOcr.getInstance();
    }

    @Test
    public void bankOcrInit_Default_ShouldReturnBankOcrObjectWithNoEntries()
    {
        assertTrue(bankOcr instanceof BankOcr);
        assertEquals(bankOcr.entries().size(), 0);
    }

    @Test
    public void bankOcrReadInFileNominal_NominalFilePath_ShouldReturnMixedEntries()
    {
        bankOcr.readInFile("entries/mixed");
        
        List<Entry> nominalEntries = bankOcr.entries();
        assertEquals(nominalEntries.size(), 7);
    }

    @Test(expected = Exception.class)
    public void bankOcrReadInFileOffNominal_OffNominalFilePath_ShouldThrowError()
    {
        bankOcr.readInFile("batman_was_here");
    }
}

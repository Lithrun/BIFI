package nl.hu.sie.bep.bifi.group2.parser;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParserUtilsTests
{
    private ParserUtils utils;

    @BeforeEach
    public void Before()
    {
        utils = new ParserUtils();
    }
    
    @Test
    public void ParserUtilsTestShortenOverSized()
    {
        var result = utils.shortenStringValue(10, "12345678901");
        
        assertEquals("1234567890", result);
    }
    
    @Test
    public void ParserUtilsTestShortenNull()
    {
        var result = utils.shortenStringValue(10, null);

        assertEquals("", result);
    }

    @Test
    public void ParserUtilsTestShortenNormal()
    {
        var result = utils.shortenStringValue(10, "test");

        assertEquals("test", result);
    }

    @Test
    public void ParserUtilsTestShortenEdgeCase()
    {
        var result = utils.shortenStringValue(10, "1234567890");

        assertEquals("1234567890", result);
    }
    
    @Test
    public void ParserUtilsTestFormatDateNull()
    {
        var result = utils.formatDate(null);
        
        assertEquals("", result);
    }

    @Test
    public void FormatDatePreviousCentury()
    {
        assertEquals("010390",  utils.formatDate(new Date(1990, 2, 1)));
    }

    @Test
    public void FormatDateCurrentCentury()
    {
        assertEquals("090818", utils.formatDate(new Date(2018, 7, 9)));
    }

    @Test
    public void FormatDateCurrentCenturyWithDoubleDay()
    {
        assertEquals("190818", utils.formatDate(new Date(2018, 7, 19)));
    }


    @Test
    public void FormatDecimalSmallNumber()
    {
        assertEquals("0000520", utils.formatValue(5, 2, 5.2));
    }

    @Test
    public void FormatDecimalSmallPrecision()
    {
        assertEquals("1520", utils.formatValue(2, 2, 15.2));
    }

    @Test
    public void FormatDecimalBigNumberSmallPrecision()
    {
        assertEquals("11520", utils.formatValue(2, 2, 115.2));
    }

    @Test
    public void FormatDecimalBigNumberBigScale()
    {
        assertEquals("1152000", utils.formatValue(2, 4, 115.2));
    }

    @Test
    public void FormatDecimalBigNumberSmallScale()
    {
        assertEquals("1152", utils.formatValue(2, 1, 115.2));
    }

}

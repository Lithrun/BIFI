package parser;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class ParserUtilsTests
{
    private ParserUtils utils;
    
    @Before
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

    //TODO one assert per unit test!

    @Test
    public void ParserUtilsTestFormatDateValid()
    {
        assertEquals("010390",  utils.formatDate(new Date(1990, 2, 1)));
        assertEquals("090818",  utils.formatDate(new Date(2018, 7, 9)));
        assertEquals("190818",  utils.formatDate(new Date(2018, 7, 19)));

    }

    //TODO one assert per unit test!
    
    @Test
    public void ParserUtilsTestFormatDoubleValid()
    {
        assertEquals("0000520", utils.formatValue(5, 2, 5.2));
        assertEquals("1520", utils.formatValue(2, 2, 15.2));
        assertEquals("11520", utils.formatValue(2, 2, 115.2));
        assertEquals("1152000", utils.formatValue(2, 4, 115.2));
        assertEquals("1152", utils.formatValue(2, 1, 115.2));
    }

}

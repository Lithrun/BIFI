package parser;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;

public class ParserUtilsTests
{
    private ParserUtils _utils;
    
    @BeforeEach
    public void Before()
    {
        _utils = new ParserUtils();
    }
    
    @Test
    public void ParserUtilsTestShortenOverSized()
    {
        var result = _utils.Shorten(10, "12345678901");
        
        assertEquals("1234567890", result);
    }
    
    @Test
    public void ParserUtilsTestShortenNull()
    {
        var result = _utils.Shorten(10, null);

        assertEquals("", result);
    }

    @Test
    public void ParserUtilsTestShortenNormal()
    {
        var result = _utils.Shorten(10, "test");

        assertEquals("test", result);
    }

    @Test
    public void ParserUtilsTestShortenEdgeCase()
    {
        var result = _utils.Shorten(10, "1234567890");

        assertEquals("1234567890", result);
    }
    
    @Test
    public void ParserUtilsTestFormatDateNull()
    {
        var result = _utils.Format(null);
        
        assertEquals("", result);
    }
    
    @Test
    public void ParserUtilsTestFormatDateValid()
    {
        assertEquals("010390",  _utils.Format(new Date(1990, 2, 1)));
        assertEquals("090818",  _utils.Format(new Date(2018, 7, 9)));
        assertEquals("190818",  _utils.Format(new Date(2018, 7, 19)));

    }
    
    @Test
    public void ParserUtilsTestFormatDoubleValid()
    {
        assertEquals("0000520", _utils.Format(5, 2, 5.2));
        assertEquals("1520", _utils.Format(2, 2, 15.2));
        assertEquals("11520", _utils.Format(2, 2, 115.2));
        assertEquals("1152000", _utils.Format(2, 4, 115.2));
        assertEquals("1152", _utils.Format(2, 1, 115.2));
    }

}

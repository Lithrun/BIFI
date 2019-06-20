package parser;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FileBuilderTests
{
    @Test
    public void FileBuilderTestOneLine()
    {
        var fileBuilder = new FileBuilder();
        
        fileBuilder.Add("hallo");
        fileBuilder.Add("test");
        fileBuilder.Add("world");
        var build = fileBuilder.Build();
        
        assertEquals("hallo,test,world", build);
    }
    
    @Test
    public void FileBuilderTestMultiLine()
    {
        var fileBuilder = new FileBuilder();

        fileBuilder.Add("hallo");
        fileBuilder.Add("test");
        fileBuilder.Add("world");
        fileBuilder.NextLine();
        fileBuilder.Add("world");
        fileBuilder.Add("test");
        fileBuilder.Add("hello");
        
        var build = fileBuilder.Build();

        assertEquals("hallo,test,world\nworld,test,hello", build);
    }
    
    @Test
    public void FileBuilderTestTailingWhitespace()
    {
        var fileBuilder = new FileBuilder();

        fileBuilder.Add("hallo ");
        fileBuilder.Add(" test");
        fileBuilder.Add("world ");

        var build = fileBuilder.Build();

        assertEquals("hallo , test,world ", build);
    }
    
    @Test
    public void FileBuilderTestAddRange()
    {
        var fileBuilder = new FileBuilder();

        var items = new String[]
        {
            "hallo",
            "test",
            "world"
        };
        fileBuilder.Add(items);

        var build = fileBuilder.Build();

        assertEquals("hallo,test,world", build);
    }
    
    @Test
    public void FileBuilderTestComma()
    {
        var fileBuilder = new FileBuilder();

        var items = new String[]
        {
            "hallo,",
            "test",
            "world"
        };
        fileBuilder.Add(items);

        var build = fileBuilder.Build();

        assertEquals("hallo\\,,test,world", build);
    }
}

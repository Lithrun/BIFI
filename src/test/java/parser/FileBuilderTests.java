package parser;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FileBuilderTests
{
    @Test
    public void FileBuilderTestOneLine()
    {
        FileBuilder fileBuilder = new FileBuilder();
        
        fileBuilder.add("hallo");
        fileBuilder.add("test");
        fileBuilder.add("world");
        var build = fileBuilder.build();
        
        assertEquals("hallo,test,world", build);
    }
    
    @Test
    public void FileBuilderTestMultiLine()
    {
        var fileBuilder = new FileBuilder();

        fileBuilder.add("hallo");
        fileBuilder.add("test");
        fileBuilder.add("world");
        fileBuilder.nextLine();
        fileBuilder.add("world");
        fileBuilder.add("test");
        fileBuilder.add("hello");
        
        var build = fileBuilder.build();

        assertEquals("hallo,test,world\nworld,test,hello", build);
    }
    
    @Test
    public void FileBuilderTestTailingWhitespace()
    {
        var fileBuilder = new FileBuilder();

        fileBuilder.add("hallo ");
        fileBuilder.add(" test");
        fileBuilder.add("world ");

        var build = fileBuilder.build();

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
        fileBuilder.add(items);

        var build = fileBuilder.build();

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
        fileBuilder.add(items);

        var build = fileBuilder.build();

        assertEquals("hallo\\,,test,world", build);
    }
}

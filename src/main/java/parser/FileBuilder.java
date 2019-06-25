package parser;

import java.util.ArrayList;
import java.util.List;

public class FileBuilder
{
    private List<List<String>> lines = new ArrayList<>();
    private List<String> currentLine = new ArrayList<>();
    
    public void add(String value)
    {
        if (value == null)
        {
            value = "";
        }
        
        //Replace al , with \, so it won't interfere with the CSV format
        if (value.contains(","))
        {
           value = value.replaceAll("\\,", "\\\\,");
        }
        
        currentLine.add(value);
    }
    
    public void add(String[] value)
    {
        for (var item : value)
        {
            add(item);
        }
    }
    
    public void nextLine()
    {
        if (currentLine.size() > 0)
        {
            lines.add(currentLine);
        }
        
        currentLine = new ArrayList<>();
    }
    
    public String build()
    {
        nextLine();
        
        var builder = new StringBuilder();
        
        for (var line : lines)
        {
            var size = line.size();
            for (var i = 0; i < size; i++)
            {
                var value = line.get(i);
                builder.append(value);
                //dont append last comma 
                if (i >= size -1)
                {
                    continue;
                }
                builder.append(",");
                
            }
            builder.append("\n");
        }
        
        var build = builder.toString();
        
        build = build.replaceAll("\n$", "");
        
        return build;
    }
}

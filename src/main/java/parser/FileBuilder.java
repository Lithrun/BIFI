package parser;

import java.util.ArrayList;
import java.util.List;

public class FileBuilder
{
    private List<List<String>> _lines = new ArrayList<>();
    private List<String> _currentLine = new ArrayList<>();
    
    public void Add(String value)
    {
        _currentLine.add(value);
    }
    
    public void Add(String[] value)
    {
        for (var item : value)
        {
            _currentLine.add(item);
        }
    }
    
    public void NextLine()
    {
        if (_currentLine.size() > 0)
        {
            _lines.add(_currentLine);
        }
        
        _currentLine = new ArrayList<>();
    }
    
    public String Build()
    {
        NextLine();
        
        var builder = new StringBuilder();
        
        for (var line : _lines)
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

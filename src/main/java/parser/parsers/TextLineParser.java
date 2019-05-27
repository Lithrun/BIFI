package parser.parsers;

import model.TextLine;
import parser.IParser;
import parser.FileBuilder;
import parser.ParserUtils;

public class TextLineParser extends ParserUtils implements IParser<TextLine>
{
    @Override
    public void Parse(FileBuilder builder, TextLine model)
    {
        var items = new String[]
        {
            "T",
            Shorten(120, model.getDescription()),
        };

        builder.AddRange(items);
        
    }
}

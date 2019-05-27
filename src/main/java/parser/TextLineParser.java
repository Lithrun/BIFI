package parser;

import model.TextLine;

public class TextLineParser extends ParserUtils implements IParser<TextLine>
{
    @Override
    public void Parse(LineBuilder builder, TextLine model)
    {
        var items = new String[]
        {
            "T",
            Shorten(120, model.getDescription()),
        };

        builder.AddRange(items);
        
    }
}

package parser.parsers;

import model.TextLine;
import parser.FileBuilder;
import parser.IParser;
import parser.ParserUtils;

public class TextLineParser extends ParserUtils implements IParser<TextLine>
{
    @Override
    public void parse(FileBuilder builder, TextLine model)
    {
        var items = new String[]
        {
            "T",
                shortenStringValue(120, model.getDescription()),
        };

        builder.add(items);
    }
}

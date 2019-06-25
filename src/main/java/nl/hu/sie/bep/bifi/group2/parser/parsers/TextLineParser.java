package nl.hu.sie.bep.bifi.group2.parser.parsers;

import nl.hu.sie.bep.bifi.group2.model.TextLine;
import nl.hu.sie.bep.bifi.group2.parser.IParser;
import nl.hu.sie.bep.bifi.group2.parser.FileBuilder;
import nl.hu.sie.bep.bifi.group2.parser.ParserUtils;

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

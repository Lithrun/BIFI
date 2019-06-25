package nl.hu.sie.bep.bifi.group2.parser;

public interface IParser<T>
{
    void parse(FileBuilder builder, T model);
}

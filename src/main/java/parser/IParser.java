package parser;

public interface IParser<T>
{
    void parse(FileBuilder builder, T model);
}

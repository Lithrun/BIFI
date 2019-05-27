package parser;

public interface IParser<T>
{
    /**
     * 
     * @param builder
     * @param model
     */
    void Parse(LineBuilder builder, T model);
}

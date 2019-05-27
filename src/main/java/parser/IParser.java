package parser;

/**
 * Base class of parser that will get invoked by the reflector
 * @param <T>
 */
public interface IParser<T>
{
    /**
     * Method will be invoked when the reflector reached the T type
     * @param builder The file builder which the method can append lines to
     * @param model The current model/class
     */
    void Parse(FileBuilder builder, T model);
}

package persistence.jar.generic;

public interface JarDataFactory<T> {
    T get(String value);

    void open();

    void close();
}

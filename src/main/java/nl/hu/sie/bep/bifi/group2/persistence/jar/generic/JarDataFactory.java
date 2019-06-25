package nl.hu.sie.bep.bifi.group2.persistence.jar.generic;

public interface JarDataFactory<T> {
    T get(String value);

    void open();

    void close();
}

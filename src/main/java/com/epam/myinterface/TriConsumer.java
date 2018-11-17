package com.epam.myinterface;

/** Functional interface for 3 arguments
 *
 */
@FunctionalInterface
public interface TriConsumer<T, U, V>  {
    void accept(T t, U u, V v);
}

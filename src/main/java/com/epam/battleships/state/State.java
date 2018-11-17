package com.epam.battleships.state;

public interface State<T> {
    T getNextState();
}

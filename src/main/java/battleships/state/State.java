package state;

public interface State<T> {
    T getNextState();
}

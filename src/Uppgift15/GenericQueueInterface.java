package Uppgift15;

public interface GenericQueueInterface<T> {
    public void put(T t);
    public T take();
    public int size();
}

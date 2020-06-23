package cyclLinkedList;

public interface Linked<T> {
    void addLast(T element);
    void addFirst(T element);
    int size();
    T getElementByIndex(int index);
}

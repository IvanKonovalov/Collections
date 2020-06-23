package cyclLinkedList;

//Дек. Дек організований на масиві із циклічним заповненням та на двоспрямованому списку.
//Операції виконуються з різних кінців дека.


import java.util.Iterator;

public class Queue<T> implements Linked<T>, Iterable<T>, DescendingIterator<T> {
    private Node<T> fstNode;
    private Node<T> lstNode;
    private int size = 0;

    public Queue() {
        lstNode = new Node<T>(fstNode,null,fstNode);
        fstNode = new Node<T>(lstNode, null, lstNode);
    }

    @Override
    public void addLast(T element) {
        Node<T> prev = lstNode;
        prev.setValue(element);
        lstNode = new Node<T>(prev,null,fstNode);
        prev.setNext(lstNode);
        size++;
    }

    @Override
    public void addFirst(T element) {
        Node<T> next = fstNode;
        next.setValue(element);
        fstNode = new Node<T>(lstNode,null, next);
        next.setPrevious(fstNode);
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T getElementByIndex(int index) {
        Node<T> element = fstNode.getNext();
        for (int i = 0; i < index; i ++) {
            element = element.getNext();
        }
        return element.getValue();
    }


    @Override
    public Iterator<T> iterator () {
        return new Iterator<T>() {
            int index = 0;
            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public T next() {
                return getElementByIndex(index++);
            }
        };
    }


    @Override
    public Iterator<T> descendingIterator() {
        return new Iterator<T>() {
            int index = size-1;
            @Override
            public boolean hasNext() {
                return index >= 0;
            }

            @Override
            public T next() {
                return getElementByIndex(index--);
            }
        };
    }
}

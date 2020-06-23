package linkedList;
import cyclLinkedList.DescendingIterator;
import cyclLinkedList.Linked;
import cyclLinkedList.Node;

import java.util.Iterator;

public class TDLinkedList<T>  implements Linked<T>, Iterable<T>, DescendingIterator<T> {
    Node<T> fstNode;
    Node<T> lstNode;
    int size = 0;

    public TDLinkedList() {
        fstNode = new Node(null, null, lstNode);
        lstNode = new Node(fstNode, null, null);
    }

    @Override
    public void addLast(T element) {
        Node<T> prev = lstNode;
        prev.setValue(element);
        lstNode = new Node<T>(prev, null, null);
        prev.setNext(lstNode);
        if (size == 0) {
            fstNode.setNext(prev);
        }
        size++;
    }

    @Override
    public void addFirst(T element) {
        Node<T> next = fstNode;
        next.setValue(element);
        fstNode = new Node<T>(null,null, next);
        next.setPrevious(fstNode);
        if (size == 0) {
            lstNode.setPrevious(next);
        }
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
    public void setValueByIndex(int index, T value) {
        Node<T> element = fstNode.getNext();
        for (int i = 0; i < index; i ++) {
            element = element.getNext();
        }
        element.setValue(value);
    }

    public void removeByIndex (int index) {
        Node<T> element = fstNode.getNext();
        for (int i = 0; i < index; i ++) {
            element = element.getNext();
        }
        element.getPrevious().setNext(element.getNext());
        element.getNext().setPrevious(element.getPrevious());
        size--;
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
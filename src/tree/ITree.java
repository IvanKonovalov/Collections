package tree;

import java.util.List;

public interface ITree<T> extends Iterable<T> {
    boolean add(T e);
    List<T> get();
    int size();
    Leaf<T> find (T e);
};

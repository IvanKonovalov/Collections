package tree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Tree<T> implements  ITree<T>{
    private Leaf<T> root;
    private List<T> list;
    private int size = 0;

    public Tree() {
        list = new LinkedList<>();
        root = new Leaf<>(null);
    }
    @Override
    public boolean add(T t) {
        if(size == 0) {
            return initRootLeaf(t);
        }

        Leaf<T> newNode = new Leaf<T>(t);
        Leaf<T> lastNode = findLastLeaf(root, newNode);

        if(lastNode == null)
            return false;

        size++;
        newNode.setParent(lastNode);

        if(lastNode.compareTo(newNode) < 0) {
            lastNode.setRight(newNode);
        } else {
            lastNode.setLeft(newNode);
        }
        return true;
    }

    private Leaf<T> findLastLeaf(
            final Leaf<T> oldLeaf,
            final Leaf<T> newLeaf
    ) {
        Leaf<T> lastLeaf = oldLeaf;
        int compare = oldLeaf.compareTo(newLeaf);

        if(compare < 0 && oldLeaf.getRight() != null)
            lastLeaf = findLastLeaf(oldLeaf.getRight(), newLeaf);

        if(compare > 0 && oldLeaf.getLeft() != null)
            lastLeaf = findLastLeaf(oldLeaf.getLeft(), newLeaf);

        if(compare == 0)
            return null;

        return lastLeaf;

    }

    private boolean initRootLeaf(final T t) {
        root.setValue(t);
        size++;
        return true;
    }

    @Override
    public List<T> get() {
        for (T key : this) {
            list.add(key);
        }
        return list;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Leaf<T> find(T t) {
        Leaf<T> eLeaf = new Leaf<>(t);
        return searchInDeep(root,eLeaf);
    }

    private Leaf<T> searchInDeep(Leaf<T> leaf, Leaf<T> eLeaf) {
        int compare = leaf.compareTo(eLeaf);

        if (compare < 0 && leaf.getRight() != null)
            return searchInDeep(leaf.getRight(),eLeaf);

        if (compare > 0 && leaf.getLeft() != null)
            return searchInDeep(leaf.getLeft(),eLeaf);

        if (compare == 0) {
            return leaf;
        }

        return  null;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int count = 0;
            Iterator<Leaf<T>>  iterator = new TreeIterator<T>(root);

            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public T next() {
                count++;
                return iterator.next().getValue();
            }
        };
    }
    private  class TreeIterator<T> implements Iterator<Leaf<T>>{
        private Leaf<T> next;

        private TreeIterator(Leaf<T> root){
            next = root;
            goToLeftmost();
        }

        @Override
        public boolean hasNext() {
            return  next != null && next.getValue() != null;
        }

        @Override
        public Leaf<T> next() {
            Leaf<T> r = next;

            if (next.getRight() != null)
                return goRight(r);

            return goUp(r);
        }

        private void goToLeftmost() {
            while (next.getLeft()!=null)
                next = next.getLeft();
        }

        private Leaf<T> goRight(Leaf<T> r) {
            next = next.getRight();
            while (next.getLeft()!=null)
                next = next.getLeft();
            return  r;
        }

        private Leaf<T> goUp(Leaf<T> r) {
            while (true) {
                if(next.getParent() == null) {
                    next = null;
                    return r;
                }

                if(next.getParent().getLeft() == next) {
                    next = next.getParent();
                    return r;
                }

                next = next.getParent();
            }
        }
    }
}

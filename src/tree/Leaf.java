package tree;

public class Leaf<T> implements Comparable<T>{
    private Leaf<T> parent;
    private Leaf<T> right;
    private Leaf<T> left;
    private T value;

    public Leaf(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void setParent(Leaf<T> parent) {
        this.parent = parent;
    }

    public void setRight(Leaf<T> right) {
        this.right = right;
    }

    public void setLeft(Leaf<T> left) {
        this.left = left;
    }

    public Leaf<T> getParent() {
        return parent;
    }

    public Leaf<T> getRight() {
        return right;
    }

    public Leaf<T> getLeft() {
        return left;
    }

    @Override
    public int compareTo(T o) {
        Leaf<T> node = (Leaf<T>)o;
        return this.hashCode() - node.hashCode();
    }

    @Override
    public int hashCode(){
        int hash = 31;
        hash = hash * 17 + value.hashCode();
        return hash;
    }

    public int compareTo(Leaf<T> newLeaf) {
        return this.hashCode() - newLeaf.hashCode();
    }
}

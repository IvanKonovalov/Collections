//Визначити K - кількість вузлів, ключ яких більше заданого числа N;
//використати рекурсивний алгоритм спадного обходу дерева;
//додати вузол з ключем K.

import tree.Tree;

public class lab3 {
    public static void main (String [] args) {
        Tree<Integer> kek = new Tree<>();

        kek.add(2);
        kek.add(12);
        kek.add(-12);
        kek.add(-24);
        kek.add(8);
        kek.add(16);

        for (Integer i : kek.get()){
            System.out.println(i);
        }
    }
}

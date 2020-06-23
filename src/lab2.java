import linkedList.TDLinkedList;
import linkedList.RefactorList;

import java.util.Iterator;

public class lab2 {
    public static final int WINDOWSIZE = 120;
    public static void main (String [] args) {
        TDLinkedList<String> list = new TDLinkedList();

        list.addLast("One");
        list.addFirst("Neeee");
        list.addLast("Two");
        list.addFirst("a");
        list.addFirst("b");
        list.addFirst("Neeee1");
        list.addLast("Three");
        list.addFirst("a");
        list.addFirst("Neeee2");

        Iterator<String> iterator = list.descendingIterator();

        while(iterator.hasNext()) {
            System.out.print(iterator.next() + "  ");
        }
        System.out.println();

        RefactorList refactorList = new RefactorList(list);
        refactorList.findChar();

        StringBuilder str = new StringBuilder();
        int lenth = 0;
        for (String s: list) {
            str.append(s+" ");
            lenth += s.length();
        }

        for (int i = 0; i < WINDOWSIZE; i ++)
            System.out.print(" ");

        System.out.println(str);

    }
}

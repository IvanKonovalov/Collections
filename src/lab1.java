import cyclLinkedList.Queue;

import java.util.Iterator;


public class lab1 {
    public static void main (String [] args) {
        Queue<String> deck = new Queue<>();
        deck.addLast("abs");
        deck.addLast("abb");
        deck.addFirst("First?");
        for (String s : deck) {
            System.out.print(s +"  ");
        }
        System.out.println();

        Iterator<String> iterator = deck.descendingIterator();

        while(iterator.hasNext()) {
            System.out.print(iterator.next() + "  ");
        }
    }
}

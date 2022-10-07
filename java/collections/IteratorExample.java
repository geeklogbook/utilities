package collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class IteratorExample {

    public static void main(String[] args) {
        ArrayList list = new ArrayList();

        list.add("One");
        list.add("Two");
        list.add("Three");
        list.add("Four");
        list.add("Five");

        System.out.println("Iterator using while loop: ");
        Iterator it1 = list.iterator();
        while (it1.hasNext()){
            System.out.println("Next element: " + it1.next());
        }

        System.out.println("Iterator using for loop: ");
        for (Iterator it2 = list.iterator(); it2.hasNext();){
            System.out.println("Next elment: " + it2.next());
        }

        System.out.println("List iterator (foward iteration): ");
        ListIterator lit = list.listIterator();
        while (lit.hasNext()){
            System.out.println("Next element: " + lit.next());
        }


    }

}

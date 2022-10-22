package exceptions;

import java.util.Iterator;
import java.util.Vector;

public class IllegalSTateException {
    public static void main(String[] args) {
        Vector<Integer> intVec = new Vector<Integer>(3);
        intVec.add(1);
        intVec.add(2);
        intVec.add(3);
        Iterator vecIter = intVec.iterator();
        while (vecIter.hasNext()){
            Object obj1 = vecIter.next();
            vecIter.remove();
            vecIter.remove();
        }
    }
}

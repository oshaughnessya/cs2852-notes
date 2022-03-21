package oshaughnessya.week3;

import oshaughnessya.week2.LinkedList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Driver {
    public static void main(String[] args) {
        Collection<String> collection = new LinkedList<>();
        collection.add("two");
        collection.add("to");
        collection.add("too");

        // these two are the exact same
        {
            for(String word: collection) {
                System.out.println(word);
            }
        }
        {
            Iterator<String> itr = collection.iterator();
            while (itr.hasNext()) {
                System.out.println(itr.next());
            }
        }
    }
}

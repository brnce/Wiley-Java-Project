package com.bernice.demo;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class MyLinkedHashSetDemoClass {
    public MyLinkedHashSetDemoClass() {
    }

    public static void main(String[] args) {
        Set<Integer> myCollection = new LinkedHashSet();
        System.out.println("Size : " + myCollection.size());
        myCollection.add(20);
        myCollection.add(50);
        myCollection.add(90);
        myCollection.add(40);
        myCollection.add(68);
        System.out.println("Size : " + myCollection.size());
        System.out.println(myCollection);
        myCollection.add(40);
        myCollection.add(88);
        System.out.println("Size : " + myCollection.size());
        System.out.println(myCollection);
        myCollection.remove(50);
        System.out.println("Size : " + myCollection.size());
        System.out.println(myCollection);
        System.out.println("Traversal using for each loop");
        Iterator var3 = myCollection.iterator();

        while(var3.hasNext()) {
            Integer element = (Integer)var3.next();
            System.out.println(element);
        }

        System.out.println("Traversal using Iterator");
        Iterator<Integer> iterator = myCollection.iterator();

        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }
}

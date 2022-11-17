package com.bernice.demo;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class EmployeeHashSetDemoClass {
	 public EmployeeHashSetDemoClass() {
	    }

	    public static void main(String[] args) {
	        Set<Employee> myCollection = new HashSet();
	        System.out.println("Size : " + myCollection.size());
	        myCollection.add(new Employee(101, "AAAA", "EXecutive", "IT", 12345.0));
	        myCollection.add(new Employee(102, "BBBB", "Sr. EXecutive", "IT", 12345.0));
	        myCollection.add(new Employee(103, "CCCC", "Manager", "Marketing", 12345.0));
	        myCollection.add(new Employee(104, "DDDD", "Associate", "HR", 12345.0));
	        myCollection.add(new Employee(105, "EEEE", "Sr. Manager", "Sales", 12345.0));
	        System.out.println("Size : " + myCollection.size());
	        System.out.println(myCollection);
	        myCollection.add(new Employee(101, "AAAA", "EXecutive", "IT", 12345.0));
	        myCollection.add(new Employee(106, "FFFF", "Executive", "Purchase", 12345.0));
	        System.out.println("Size : " + myCollection.size());
	        System.out.println(myCollection);
	        myCollection.remove(new Employee(101, "AAAA", "EXecutive", "IT", 12345.0));
	        System.out.println("Size : " + myCollection.size());
	        System.out.println(myCollection);
	        System.out.println("Traversal using for each loop");
	        Iterator var3 = myCollection.iterator();

	        while(var3.hasNext()) {
	            Employee element = (Employee)var3.next();
	            System.out.println(element);
	        }

	        System.out.println("Traversal using Iterator");
	        Iterator<Employee> iterator = myCollection.iterator();

	        while(iterator.hasNext()) {
	            System.out.println(iterator.next());
	        }

	    }
}

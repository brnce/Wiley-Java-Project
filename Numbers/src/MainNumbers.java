import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class MainNumbers {
	public MainNumbers() {
		}
	 public static void main(String[] args) {
		 // declaring the set
	        Set<Numbers> myNumbers = new LinkedHashSet<>();

	        Scanner myScanner = new Scanner(System.in);
			System.out.println("Please enter 10 numbers to store in collection: ");
			
			// loop over 10 indexes of set called i
			for (int i=0; i<10; i++) {
				 System.out.println("Please enter " + i +" number: ");
				 // store user input in num
				 int num = myScanner.nextInt();
				 // create number object with index i
				 Numbers myNum = new Numbers(num, i);
				 
				 // for all the numbers in the collection
				 for(Numbers n : myNumbers) {
					 // if the number entered is already in collection
				 if (n.getNumber() == num) {
					 // print out message
					 System.out.println("The number is already in the collection");
					
					 System.out.println("Please enter " + i +" number: ");
					 //myScanner.nextLine();
				 } 
				 }   
				
					 myNumbers.add(myNum); 
			}
			
			
			 for(Numbers n : myNumbers) {
		    	   System.out.println(n.toString());
		       }	
	 }

}

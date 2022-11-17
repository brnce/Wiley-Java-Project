import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MyThrowsKeywordFirstDemoClass {
	 public MyThrowsKeywordFirstDemoClass() {
	    }

	    public static void openFile(String fileName) throws FileNotFoundException {
	        new FileInputStream(fileName);
	    }

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        System.out.println("Enter File Name : ");
	        String fileName = scanner.next();

	        try {
	            openFile(fileName);
	            System.out.println("You can start reading from file " + fileName);
	        } catch (FileNotFoundException var4) {
	            System.out.println("Sorry no such file exist");
	        }

	    }
}

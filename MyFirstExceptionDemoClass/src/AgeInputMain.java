import java.util.Scanner;

public class AgeInputMain {
	 public AgeInputMain() {
	    }

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        AgeInput ageInput2;
	        try {
	            ageInput2 = new AgeInput();
	            System.out.println("Enter Age : ");
	            int age = scanner.nextInt();
	            ageInput2.setAge(age);
	            System.out.println("Age : " + ageInput2.getAge());
	        } catch (AgeUncheckedException var5) {
	            System.out.println("Person is not eligigble for employement");
	        }

	        try {
	            System.out.println("Enter One More Age :");
	            ageInput2 = new AgeInput(scanner.nextInt());
	            System.out.println("As person age is " + ageInput2.getAge() + " so person is eligible for voting");
	        } catch (AgeCheckedException var4) {
	            System.out.println("Person is not eligible for voting");
	        }

	    }
}

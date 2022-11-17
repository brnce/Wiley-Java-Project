//
//Source code recreated from a .class file by IntelliJ IDEA
//(powered by FernFlower decompiler)
//


import java.util.Scanner;

public class MyFirstExceptionDemoClass {
 public MyFirstExceptionDemoClass() {
 }

 public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);
     
     int location = 0;

     try {
         System.out.println("Enter first Number : ");
         int number1 = scanner.nextInt();
         System.out.println("Enter second Number : ");
         int number2 = scanner.nextInt();
         int result = number1 / number2;
         System.out.println("Result of division : " + result);
         System.out.println("Enter Total Number of elements in an array :");
         int total = scanner.nextInt();
         int[] arr = new int[total];

         for(int index = 0; index < total; ++index) {
             System.out.println("Enter " + (index + 1) + " value in an array : ");
             arr[index] = scanner.nextInt();
         }

         System.out.println("Enter location of an array to extract value : ");
         location = scanner.nextInt();
         System.out.println("Value at " + location + " location in an array : " + arr[location]);
     } catch (ArithmeticException var9) {
         System.out.println("Undefined");
     } catch (ArrayIndexOutOfBoundsException var10) {
         System.out.println(location + " location does not exist in an array");
     } catch (NegativeArraySizeException var11) {
         System.out.println("Array Size must be a positive integer");
     } catch (Exception var12) {
         System.out.println("Something went wrong, please try again!");
     }

     System.out.println("Good Bye from main Method!");
 }
}
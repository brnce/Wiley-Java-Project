import java.util.Scanner;

public class EmployeeMain {
	 public EmployeeMain() {
	    }

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        try {
	            System.out.println("Enter total number of employees : ");
	            int total = scanner.nextInt();
	            EmployeeList employeeList = new EmployeeList(total);

	            for(int index = 0; index < total; ++index) {
	                Employee emp = new Employee();
	                System.out.println("Enter Employee Name : ");
	                emp.setName(scanner.next());
	                System.out.println("Enter Employee Age : ");
	                emp.setAge(scanner.nextInt());
	                employeeList.inputEmployee(emp, index);
	            }

	            employeeList.displayEmployees();
	        } catch (AgeException var6) {
	            System.out.println(var6.getMessage());
	        } catch (NameException var7) {
	            System.out.println(var7.getMessage());
	        } catch (NegativeArraySizeException var8) {
	            System.out.println("Total No of employee cannot be negative");
	        } catch (Exception var9) {
	            System.out.println("OOPS Something went wrong, please try after sometime!");
	        }

	    }

}

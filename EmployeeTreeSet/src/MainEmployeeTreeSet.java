import java.util.Set;
import java.util.TreeSet;

public class MainEmployeeTreeSet {
	public static void main(String args[]) {
		
		Set<Employee> myCollection=new TreeSet<Employee>();
		
		myCollection.add(new Employee(001, "Joe Black", 4, "Cloud Engineer", "Dev Ops", 45000));
		myCollection.add(new Employee(002, "Mary Cool", 2, "Junior Developer", "Software", 36000));
		myCollection.add(new Employee(003, "Adam Grey", 1, "Trainee Software Developer", "Software", 27000));
		myCollection.add(new Employee(004, "Ben Manny", 10, "Project Manager", "Client Service", 50000));
		myCollection.add(new Employee(005, "Larry Namk", 7, "Senior Java Developer", "Software", 100000));
		
		System.out.println("Size : " + myCollection.size());
		System.out.println(myCollection.toString());
	}
}

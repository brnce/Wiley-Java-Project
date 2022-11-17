import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode

public class Employee implements Comparable<Employee> {
	private int empId;
	private String Name;
	private int yearsOfExperience;
	private String designation;
	private String department;
	private int salary;
	
	
	@Override
	public int compareTo(Employee employee1) {
		// if object2 number of experience is greater return 1
		if(yearsOfExperience>employee1.yearsOfExperience)
			return 1;
		// if object2 number of experience is greater return -1: store object in right subtree
		else if(yearsOfExperience<employee1.yearsOfExperience)
			return -1;
		// if two number of experiences are equal return 0: objects are duplicate, don't store it
		else if(this.equals(employee1))
			return 0;
		// store object in left subtree
		return 1;
	}

}

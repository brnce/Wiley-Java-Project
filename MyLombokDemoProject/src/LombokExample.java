import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
@AllArgsConstructor
@EqualsAndHashCode


public class LombokExample {
	private int rollNo;
	private String name;
	private int age;
	private LocalDate dateOfBirth;
	
	
	public LombokExample(int rollNo, String name, int age) {
		super();
		this.rollNo = rollNo;
		this.name = name;
		this.age = age;
	}
	
	  public String toString() {
	        return "LombokExample(rollNo = " + this.getRollNo() + ", name = " + this.getName() + ", age = " + this.getAge() + ")";
	    }


}

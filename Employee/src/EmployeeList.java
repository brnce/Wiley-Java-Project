
public class EmployeeList {
	   private Employee[] empList;
	    private int totalEmployees;

	    public EmployeeList(int totalEmployees) {
	        this.totalEmployees = totalEmployees;
	        this.empList = new Employee[totalEmployees];
	    }

	    public void inputEmployee(Employee employee, int index) throws NameException {
	        for(int i = 0; i < index; ++i) {
	            if (this.empList[i].getName().equals(employee.getName())) {
	                throw new NameException("Duplicate name entered");
	            }
	        }

	        this.empList[index] = employee;
	    }

	    public void displayEmployees() {
	        Employee[] var4;
	        int var3 = (var4 = this.empList).length;

	        for(int var2 = 0; var2 < var3; ++var2) {
	            Employee emp = var4[var2];
	            emp.display();
	        }

	    }

}

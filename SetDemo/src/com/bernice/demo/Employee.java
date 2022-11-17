package com.bernice.demo;

public class Employee {
private int empId;
private String empName;
private String designation;
private String department;
private double salary;

public int getEmpId() {
    return this.empId;
}

public String getEmpName() {
    return this.empName;
}

public String getDesignation() {
    return this.designation;
}

public String getDepartment() {
    return this.department;
}

public double getSalary() {
    return this.salary;
}

public void setEmpId(int empId) {
    this.empId = empId;
}

public void setEmpName(String empName) {
    this.empName = empName;
}

public void setDesignation(String designation) {
    this.designation = designation;
}

public void setDepartment(String department) {
    this.department = department;
}

public void setSalary(double salary) {
    this.salary = salary;
}

public String toString() {
    return "Employee(empId=" + this.getEmpId() + ", empName=" + this.getEmpName() + ", designation=" + this.getDesignation() + ", department=" + this.getDepartment() + ", salary=" + this.getSalary() + ")";
}

public Employee() {
}

public Employee(int empId, String empName, String designation, String department, double salary) {
    this.empId = empId;
    this.empName = empName;
    this.designation = designation;
    this.department = department;
    this.salary = salary;
}

public boolean equals(Object o) {
    if (o == this) {
        return true;
    } else if (!(o instanceof Employee)) {
        return false;
    } else {
        Employee other = (Employee)o;
        if (!other.canEqual(this)) {
            return false;
        } else if (this.getEmpId() != other.getEmpId()) {
            return false;
        } else if (Double.compare(this.getSalary(), other.getSalary()) != 0) {
            return false;
        } else {
            label52: {
                Object this$empName = this.getEmpName();
                Object other$empName = other.getEmpName();
                if (this$empName == null) {
                    if (other$empName == null) {
                        break label52;
                    }
                } else if (this$empName.equals(other$empName)) {
                    break label52;
                }

                return false;
            }

            Object this$designation = this.getDesignation();
            Object other$designation = other.getDesignation();
            if (this$designation == null) {
                if (other$designation != null) {
                    return false;
                }
            } else if (!this$designation.equals(other$designation)) {
                return false;
            }

            Object this$department = this.getDepartment();
            Object other$department = other.getDepartment();
            if (this$department == null) {
                if (other$department != null) {
                    return false;
                }
            } else if (!this$department.equals(other$department)) {
                return false;
            }

            return true;
        }
    }
}

protected boolean canEqual(Object other) {
    return other instanceof Employee;
}

public int hashCode() {
    boolean PRIME = true;
    int result = 1;
    result = result * 59 + this.getEmpId();
    long $salary = Double.doubleToLongBits(this.getSalary());
    result = result * 59 + (int)($salary ^ $salary >>> 32);
    Object $empName = this.getEmpName();
    result = result * 59 + ($empName == null ? 43 : $empName.hashCode());
    Object $designation = this.getDesignation();
    result = result * 59 + ($designation == null ? 43 : $designation.hashCode());
    Object $department = this.getDepartment();
    result = result * 59 + ($department == null ? 43 : $department.hashCode());
    return result;
}
}

package com.bernice.controller;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bernice.entity.Employee;
import com.bernice.entity.EmployeePaySlip;
import com.bernice.model.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping("/menu")
	public ModelAndView menuPageController() {
		return new ModelAndView("index");
	}
	
	//===== Controller for Delete===================
	@RequestMapping("/deleteEmpPage")
	public ModelAndView deletePageController() {
		return new ModelAndView("InputIdForDelete");
	}
	
	@RequestMapping("/deleteEmployee")
	public ModelAndView deleteEmployeeController(HttpServletRequest request) {
		ModelAndView modelAndView=new ModelAndView();
		int eId=Integer.parseInt(request.getParameter("empId"));
		String message=null;
		if(employeeService.deleteEmployee(eId))
			message="Employee Deleted with ID " + eId;
		else
			message="Employee with ID " + eId + " does not exist";
		
		modelAndView.addObject("message", message);
		modelAndView.setViewName("Output");
		
		return modelAndView;
	}
	
	//==================================================
	
    //=============Controller for increment Salary==================
	@RequestMapping("/incrementSalPage")
	public ModelAndView salaryPageController() {
		return new ModelAndView("InputIdForIncrement");
	}
	
	@RequestMapping("/incrementSal")
	public ModelAndView salaryEmployeeController(@RequestParam("eId") int id,@RequestParam("increment") double incrementAmount) {
		ModelAndView modelAndView=new ModelAndView();
		
		String message=null;
		
		if(employeeService.incrementSalary(id, incrementAmount))
			message = "Employee with ID " + id + " salary incremented with amount £" + incrementAmount;
		else
			message = "Employee with ID " + id + " does not exist";
		
		modelAndView.addObject("message", message);
		modelAndView.setViewName("Output");
		
		return modelAndView;
	}
	
	//===========================================================
	
	//=============Controller for Listing all Employees==========
	
	@RequestMapping("/showAll")
	public ModelAndView getAllEmployeesController() {
		ModelAndView modelAndView=new ModelAndView();
		Collection<Employee> empList=employeeService.getAllEmployees();
		
		modelAndView.addObject("employees", empList);
		modelAndView.setViewName("ShowAllEmployees");
		return modelAndView;
	}
	
	//===========================================================
	
	//=================Search for Employee by ID=================
	
	@RequestMapping("/searchEmployeePage")
	public ModelAndView searchPageController() {
		return new ModelAndView("InputIdForSearch");
	}
	
	@RequestMapping("/searchEmployee")
	public ModelAndView searchEmployeesController(@RequestParam("empId") int id) {
		ModelAndView modelAndView=new ModelAndView();
	
		
		Employee employee=employeeService.searchEmployeeById(id);

		if(employee != null) {
			modelAndView.addObject("employee", employee);
		    modelAndView.setViewName("ShowEmployee");
	    }
		else {
			modelAndView.addObject("message", "Employee with ID " + id + "does not exist");
			modelAndView.setViewName("Output");
		} 
		return modelAndView;
      }
	
	//===========================================================
	
    //==============Search Employee by Department================
		
	@RequestMapping("/searchEmployeeByDepartmentInputPage")
	public ModelAndView searchEmployeeByDepartmentInputPageController() {
		return new ModelAndView("InputDepartmentForSearch");
	}
	
	@RequestMapping("/searchEmployeeByDepartment")
	public ModelAndView searchEmployeeByDepartmentController(@RequestParam("department") String deptt) {
		ModelAndView modelAndView=new ModelAndView();
		
		List<Employee> empList=employeeService.getEmployeesByDepartment(deptt);
		
		if(empList.size()>0) {
			modelAndView.addObject("employees", empList);
			modelAndView.setViewName("ShowAllEmployees");
		}else {
			modelAndView.setViewName("Output");
			modelAndView.addObject("message", "No Employee works in department "+deptt);
		}
		
		return modelAndView;
	}
	
    //===========================================================
	
    //==============Search Employee by Designation================
		
	@RequestMapping("/searchEmployeeByDesignationInputPage")
	public ModelAndView searchEmployeeByDesignationInputPageController() {
		return new ModelAndView("InputDesignationForSearch");
	}
	
	@RequestMapping("/searchEmployeeByDesignation")
	public ModelAndView searchEmployeeByDesignationController(@RequestParam("designation") String designation) {
		ModelAndView modelAndView=new ModelAndView();
		
		Collection<Employee> empListDept = employeeService.searchByDesignation(designation);
		
		if(empListDept.size()>0) {
			modelAndView.addObject("employees", empListDept);
			modelAndView.setViewName("ShowAllEmployees");
		}else {
			modelAndView.setViewName("Output");
			modelAndView.addObject("message", "No Employee with designation " + designation);
		}
		
		return modelAndView;
	}
	
	//===========================================================
	
	//=======================Add new Employee====================
	
	@RequestMapping("/addEmployeePage")
	public ModelAndView addPageController() {
		return new ModelAndView("AddNewEmployee");
	}
	
	@RequestMapping("/addEmployee")
	public ModelAndView addEmployeeController(@ModelAttribute("emp") Employee newEmployee,@RequestParam("doj") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
		ModelAndView modelAndView=new ModelAndView();
	
		newEmployee.setDateOfJoining(date); 
		
		String message = null;
	
		if(employeeService.addEmployee(newEmployee)) 
			message = "Employee with ID " + newEmployee.getEmpId() + " has been successfully added"; 
		else 
			message = "Employee with iD " + newEmployee.getEmpId() + " already exist, so cannot add it as a new employee!";
			
		
		modelAndView.addObject("message", message);
		modelAndView.setViewName("Output");
		
		return modelAndView;
	}
	
	
	//===========================================================
	
	//================Delete Employee by name====================
	
	@RequestMapping("/deleteEmployeeByNamePage")
	public ModelAndView deleteEmployeeByNamePageController() {
		return new ModelAndView("InputNameForDelete");
	}
	
	@RequestMapping("/deleteEmployeeByName")
	public ModelAndView deleteEmployeeByNameController(@RequestParam("employeeName") String name) {
		ModelAndView modelAndView=new ModelAndView();
		
		String message=null;
		if(employeeService.deleteEmployeeByName(name))
			message="Employee with name " + name + " Deleted";
		else
			message="Employee with Name " + name + " does not exist";
		
		modelAndView.addObject("message", message);
		modelAndView.setViewName("Output");
		
		return modelAndView;
	}
	
	//===========================================================
	
    //====================Generate PaySlip=======================
	
	@RequestMapping("/generatePaySlipPage")
	public ModelAndView generatePaySlipPageController() {
		return new ModelAndView("GeneratePaySlip");
	}
	
	@RequestMapping("/generatePaySlipByID")
	public ModelAndView generatePaySlipController(@RequestParam("empId") int id) {
		ModelAndView modelAndView=new ModelAndView();

		EmployeePaySlip payslip=employeeService.generatePaySlip(id);
		
		if(payslip!=null) {
			// modelAndView.addObject("empId", id);
			modelAndView.addObject("payslip", payslip);
         	modelAndView.setViewName("ShowGeneratedPayslip");
		}
		else {
			
		modelAndView.addObject("message", "Employee with id " + id + " does not exist!");
		modelAndView.setViewName("Output");
		}
		return modelAndView;
	}

}
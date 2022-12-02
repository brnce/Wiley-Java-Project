package com.bernice.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bernice.entity.Customer;
import com.bernice.model.service.CustomerService;

@Controller
public class CustomerController {
	
	@Autowired
	
	private CustomerService customerService;
	
	
	// =================Home Page Controller=======================
	
	@RequestMapping("/index")
	public ModelAndView indexPageController() {
		return new ModelAndView("index");
	}
	
	// =================Login Page Controller=======================
	
	@RequestMapping("/")
	public ModelAndView loginPageController() {
		return new ModelAndView("LoginPage", "customer", new Customer());
	}
	
	@RequestMapping("/userLoginPage")
	public ModelAndView userLoginPageController(@ModelAttribute("customer") Customer customer, HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		
		if (customerService.loginCheck(customer)) {
			Customer customerDetails = customerService.searchById(customer.getAccountId());
			modelAndView.addObject("customer", customerDetails); //adding the object to the model+view
			session.setAttribute("customer" , customerDetails); //adding the customer attribute to the session
			modelAndView.setViewName("index"); //takes user through to the menu / main home page of the website
		} else {
			modelAndView.addObject("message", "Invalid Login Credentials, Please try again");
			modelAndView.addObject("customer", new Customer()); //since we are expecting a customer attribute to be set, we just set an empty one here (?)
			modelAndView.setViewName("LoginPage"); //if its incorrect i.e. not found in database, then user remains on login page and error message is displayed on page
		}
		
		return modelAndView; //everything stored in here now ready for view to display
		
	}
	
	
	// =================Search by ID Controller=======================
	
	
	@RequestMapping("/searchByIdPage")
	public ModelAndView searchbyIDController() {
		return new ModelAndView("InputSearchById");
		
	}
	
	@RequestMapping("/searchById")
	public ModelAndView searchByIdController(@RequestParam("accountId") int accountId) {
		ModelAndView modelAndView = new ModelAndView();
		
		Customer customer = customerService.searchById(accountId);
		
		if(customer != null) {
			modelAndView.addObject("customer", customer);
		    modelAndView.setViewName("ShowCustomer");
		}
		else {
			modelAndView.addObject("message", "Customer with account Id " + accountId + " does not exist");
			modelAndView.setViewName("Output");
			
		} 
		
		return modelAndView;
		
	}
	
	
	// =================Update Account Balance Controller=======================
	
	@RequestMapping("/transferFundsInputPage")
	public ModelAndView transferFundsInputPageController() {
		return new ModelAndView("TransferFundsInputPage");
	}
	
	@RequestMapping("/transferFunds")
	public ModelAndView transferFundsController(@RequestParam("accountId")int recepientAccountId,@RequestParam("amount") double balance,HttpSession session) {
		ModelAndView modelAndView=new ModelAndView();
		
		int myAccountId=((Customer)session.getAttribute("customer")).getAccountId();
		Customer customer=customerService.transferFunds(myAccountId, recepientAccountId,balance );
		if(customer==null) {
			modelAndView.addObject("message", "Transaction Failed");
			session.setAttribute("customer", customer);
		} else
			modelAndView.addObject("message", "Your Account has been debited with balance £" + balance + " and credited in Account No " + recepientAccountId + " and your current Balance is £" + customer.getBalance());
		
		modelAndView.setViewName("Output");
		return modelAndView;
	}
	
//	@RequestMapping("/transferFunds")
//	public ModelAndView transferFundsController(@RequestParam("transferId") Integer transferId, @RequestParam("transferAmount") Double transferAmount, HttpSession session) {
//		ModelAndView modelAndView = new ModelAndView();
//		Customer customerDetails = (Customer) session.getAttribute("customer");
//		
//		//checking if account exists
//		if(customerService.searchById(transferId)==null) {
//			modelAndView.addObject("message", "Account with ID " + transferId + " does not exist!");
//			modelAndView.setViewName("TransferFundsInputPage");
//		//checking if user account has sufficient funds
//		} else if (customerDetails.getBalance() < transferAmount) {
//			modelAndView.addObject("message", "Insufficient funds!");
//			modelAndView.setViewName("TransferFundsInputPage");		
//		//confirming + carrying out transaction once these are confirmed
//		} else {
//			customerService.transferFunds(customerDetails.getAccountId(), transferId, transferAmount);
//			modelAndView.addObject("message", "Succesfully transferred! Transfer again?");
//			modelAndView.setViewName("Output");	
//			
//		}
//		
//		return modelAndView;
//	}
//	
}

package com.baidu.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.baidu.entity.Customer;
import com.baidu.service.CustomerServiceImpl;
import com.baidu.service.LinkManServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer>{
	private CustomerServiceImpl cs=new CustomerServiceImpl();
	 private LinkManServiceImpl lm=new LinkManServiceImpl();
		private Customer customer=new Customer();
	@Override
	public Customer getModel() {
		
		return customer;
	}
	
	public String addCustomer() {
		lm.addCustomer(customer);
		return "addCustomer";
	}
	public String addCustomerUI() {
		return "addCustomerUI";
	}
	public String findAllCustomer() {
		List<Customer> list=cs.findAllCustomer();
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("customers",list);
		return SUCCESS;
	}

}

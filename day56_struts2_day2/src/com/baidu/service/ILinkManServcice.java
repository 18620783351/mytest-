package com.baidu.service;

import java.util.List;

import com.baidu.entity.Customer;
import com.baidu.entity.LinkMan;

public interface ILinkManServcice {
	void addLinkMan(LinkMan linkman);
	void addCustomer(Customer customer);
	
	List<LinkMan>findAllLinkMan(); 
}

package com.baidu.dao;

import java.util.List;

import com.baidu.entity.Customer;
import com.baidu.entity.LinkMan;

public interface IlinkManDao {

	void addLinkMan(LinkMan linkman);
	void addCustomer(Customer customer);
	List<LinkMan> findAllLinkMan();

}

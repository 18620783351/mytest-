package com.baidu.dao;

import java.util.List;

import com.baidu.entity.Customer;

public interface ICustomerDao {
	List<Customer> findAllCustomer();
}

package com.baidu.dao;

import java.util.List;

import org.hibernate.Session;

import com.baidu.entity.Customer;
import com.baidu.utils.HibernateUtil;

public class CustomerDaoImpl implements ICustomerDao {

	@Override
	public List<Customer> findAllCustomer() {
		List<Customer>list= HibernateUtil.getCurrentSession().createQuery("from Customer").list();
		
		return list;
	}

}

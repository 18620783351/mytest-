package com.baidu.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.baidu.dao.CustomerDaoImpl;
import com.baidu.dao.ICustomerDao;
import com.baidu.entity.Customer;
import com.baidu.utils.HibernateUtil;

public class CustomerServiceImpl implements ICustomerService {
	private ICustomerDao customer=new CustomerDaoImpl();
	
	@Override
	public List<Customer> findAllCustomer() {
		List<Customer>list=null;
		Session s= null;
		Transaction tx =null;
		try {
			s= HibernateUtil.getCurrentSession();
			tx = s.beginTransaction();
			list = customer.findAllCustomer();
			tx.commit();		
		} catch (Exception e) {
			tx.rollback();
			throw new RuntimeException(e);
		}		
		return list;
	}

}

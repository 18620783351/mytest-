package com.baidu.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.baidu.dao.IlinkManDao;
import com.baidu.dao.linkManDaoImpl;
import com.baidu.entity.Customer;
import com.baidu.entity.LinkMan;
import com.baidu.utils.HibernateUtil;

public class LinkManServiceImpl implements ILinkManServcice {
	private IlinkManDao link=new linkManDaoImpl();
	@Override
	public void addLinkMan(LinkMan linkman) {
			Session s=null;
			Transaction tx =null;
		try {
			s= HibernateUtil.getCurrentSession();
			tx = s.beginTransaction();
			link.addLinkMan(linkman);
			tx.commit();
			
		} catch (Exception e) {
			tx.rollback();
			throw new RuntimeException(e);
		}
		

	}
	public void addCustomer(Customer customer) {
		Session s=null;
		Transaction tx =null;
	try {
		s= HibernateUtil.getCurrentSession();
		tx = s.beginTransaction();
		link.addCustomer(customer);
		tx.commit();
		
	} catch (Exception e) {
		tx.rollback();
		throw new RuntimeException(e);
	}
		
	}
	@Override
	public List<LinkMan> findAllLinkMan() {
		Session s = null;
		Transaction tx = null;
		List<LinkMan> list=null;
		try {
			s = HibernateUtil.getCurrentSession();
			tx = s.beginTransaction();
			list=link.findAllLinkMan();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			throw new RuntimeException(e);
		}
		return list;
	}

}

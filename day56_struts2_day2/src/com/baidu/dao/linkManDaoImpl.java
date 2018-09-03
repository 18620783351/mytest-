package com.baidu.dao;

import java.util.List;

import org.hibernate.Query;

import com.baidu.entity.Customer;
import com.baidu.entity.LinkMan;
import com.baidu.utils.HibernateUtil;

public class linkManDaoImpl implements IlinkManDao {

	@Override
	public void addLinkMan(LinkMan linkman){
		System.out.println("保存成功");
		HibernateUtil.getCurrentSession().save(linkman);
	}

	@Override
	public void addCustomer(Customer customer) {
		HibernateUtil.getCurrentSession().save(customer);
		
	}

	@Override
	public List<LinkMan> findAllLinkMan() {
		Query q = HibernateUtil.getCurrentSession().createQuery("from LinkMan");
		List<LinkMan> list =q.list();
		return list;
	}


}

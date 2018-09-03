package com.itheima.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import com.itheima.entity.Customer;
import com.itheima.entity.HibernateUtil;

public class HibernateDemo2 {

	private Session s = null;

	// Query By Criteria(QBC)
	// 基本查询
	@Test
	public void test01() {
		s = HibernateUtil.getCurrentSession();
		Transaction tt = s.beginTransaction();
		Criteria c = s.createCriteria(Customer.class);
		List list = c.list();
		for (Object object : list) {
			System.out.println(object);
		}
		tt.commit();
	}

	// 条件查询

	@Test
	public void test02() {
		s = HibernateUtil.getCurrentSession();
		Transaction tt = s.beginTransaction();
		Criteria c = s.createCriteria(Customer.class);
		c.add(Restrictions.like("custAddress", "%广州%"));
		c.add(Restrictions.eq("custSource", "6"));
		List list = c.list();
		for (Object object : list) {
			System.out.println(object);
		}
		tt.commit();
	}

	// 分页查询
	@Test
	public void test03() {
		s = HibernateUtil.getCurrentSession();
		Transaction tt = s.beginTransaction();
		Criteria c = s.createCriteria(Customer.class);
		c.setFirstResult(2);
		c.setMaxResults(3);
		List list = c.list();
		for (Object object : list) {
			System.out.println(object);

		}
		tt.commit();
	}

	// 排序查询
	@Test
	public void test04() {
		s = HibernateUtil.getCurrentSession();
		Transaction tt = s.beginTransaction();
		Criteria c = s.createCriteria(Customer.class);
		c.addOrder(Order.desc("custId"));
		List list = c.list();
		for (Object object : list) {
			System.out.println(object);
		}
		tt.commit();
	}

	// 统计查询
	@Test
	public void test05() {
		s = HibernateUtil.getCurrentSession();
		Transaction tt = s.beginTransaction();
		Criteria c = s.createCriteria(Customer.class);
		c.setProjection(Projections.avg("custId"));
		List list = c.list();
		for (Object object : list) {
			System.out.println(object);
		}
		tt.commit();
	}

	@Test
	public void test06() {
		DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
		dc.add(Restrictions.like("custAddress", "%广州%"));
		dc.add(Restrictions.eq("custSource", "7"));

		s = HibernateUtil.getCurrentSession();
		Transaction tt = s.beginTransaction();
		Criteria c = dc.getExecutableCriteria(s);
		List list = c.list();
		for (Object object : list) {
			System.out.println(object);
		}
		tt.commit();
	}

}

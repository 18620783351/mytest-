package com.itheima.test;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.itheima.entity.HibernateUtil;

public class HibernateDemo1 {
		//HQL查询
	private  Session s=null;
	
	
	//基本查询
	@Test
	public void test01() {
		s=HibernateUtil.getCurrentSession();
		Transaction tt = s.beginTransaction();
		Query q= s.createQuery("from Customer");
		List list = q.list();
		for (Object object : list) {
			System.out.println(object);
			
		}
		tt.commit();	
	}
		
	//条件查询
	@Test
	public void test02() {
		s=HibernateUtil.getCurrentSession();
		Transaction tt = s.beginTransaction();
		Query q= s.createQuery("from Customer where custIndustry=? and custAddress like :custAddress");
		q.setString(0,"IT培训");
		q.setString("custAddress","%广州%");
		List list = q.list();
		for (Object object : list) {
			System.out.println(object);		
		}
		tt.commit();	
	}
	
	
	//分页查询
	@Test
	public void test03() {
		s=HibernateUtil.getCurrentSession();
		Transaction tt = s.beginTransaction();
		Query q = s.createQuery("from Customer");
		q.setFirstResult(2);
		q.setMaxResults(3);
		List list = q.list();
		for (Object object : list) {
			System.out.println(object);
			
		}
		tt.commit();
	}
	
	
	
	//排序查询
	
	@Test
	public void test04() {
		s=HibernateUtil.getCurrentSession();
		Transaction tt = s.beginTransaction();
		Query q = s.createQuery("from Customer order by custId desc");
		List list = q.list();
		for (Object object : list) {
			System.out.println(object);
			
		}
		tt.commit();	
	}
	
	
	
	//统计查询 count sum avg max min
 	
		@Test
		public void test05() {
			s=HibernateUtil.getCurrentSession();
			Transaction tt = s.beginTransaction();
			Query q = s.createQuery("select count(custId) from Customer");
			Long result =(Long) q.uniqueResult();
			System.out.println(result);
			tt.commit();			
		}
		
		
		
		//投影查询
	 	
			@Test
			public void test06() {
				s=HibernateUtil.getCurrentSession();
				Transaction tt = s.beginTransaction();
				Query q = s.createQuery("select custLevel,custName from Customer");
				List<Object []> list = q.list();	
				for (Object[] objects : list) {
					System.out.println(Arrays.toString(objects));
				}
				tt.commit();			
			}
 }

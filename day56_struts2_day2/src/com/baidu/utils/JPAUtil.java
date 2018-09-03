package com.baidu.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	private static EntityManagerFactory factory;
	
	static {
		factory=Persistence.createEntityManagerFactory("cjpa");
	}
	
	public static EntityManager createEntityManager() {
		return factory.createEntityManager();
	}
	

}

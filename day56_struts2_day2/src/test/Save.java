package test;

import java.util.List;

import org.junit.Test;

import com.baidu.entity.Customer;
import com.baidu.entity.LinkMan;
import com.baidu.service.CustomerServiceImpl;
import com.baidu.service.LinkManServiceImpl;

public class Save {
	@Test
	public void save() {
		LinkManServiceImpl ls=new LinkManServiceImpl();
		LinkMan l=new LinkMan();
		l.setLkmName("刘工");
		ls.addLinkMan(l);
	}
	
	@Test
	public void find() {
		LinkManServiceImpl ls=new LinkManServiceImpl();
		List<LinkMan> list = ls.findAllLinkMan();
		for (LinkMan linkMan : list) {
			System.out.println(linkMan);
			
		}
	}
	
	@Test
	public void findCustomer() {
		CustomerServiceImpl cs=new CustomerServiceImpl();
		List<Customer> list = cs.findAllCustomer();
		for (Customer customer : list) {
			System.out.println(customer);
		}
	}

}

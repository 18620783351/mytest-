package com.baidu.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.baidu.entity.Customer;
import com.baidu.entity.LinkMan;
import com.baidu.service.LinkManServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LinkmanAction extends ActionSupport implements ModelDriven<LinkMan>{
	  private LinkManServiceImpl lm=new LinkManServiceImpl();
	  private LinkMan linkman=new LinkMan();
	 
		
	@Override
	public LinkMan getModel() {
		
		return linkman;
	}
	
	public String addLinkMan() {
		lm.addLinkMan(linkman);
		return "addLinkMan";
	}
	
	public String addLinkManUI() {
		return "addLinkManUI";
	}
	
	
	public String findAllLinkMan() {
		List<LinkMan> list=lm.findAllLinkMan();
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("linkmans",list);
		return SUCCESS;		
	}

}

package com.galaxy;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import model.Employee;
import model.EmployeeDao;
import model.User;

@Controller
public class ControllerDemo 
{
	private ApplicationContext conn;
	@RequestMapping("/home")
	public String view1()
	{
		return "home";
	}
	
	@RequestMapping("/login")
	public String view11(Model m)
	{
		conn = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		Employee obj = conn.getBean("info",Employee.class);
		m.addAttribute("bean",obj);
		return "loginpage";
	}
	
	@RequestMapping("/checklogin")
	public String view12(@ModelAttribute("bean")Employee emp, Model m, HttpServletRequest request)
	{
		conn = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		EmployeeDao obj = conn.getBean("dao", EmployeeDao.class);
		boolean flag = obj.checkLogin(emp);
		if(flag)
		{
			User usr = conn.getBean("ur",User.class);
			usr.setEmpname(emp.getEmpname());
			usr.setMobile(emp.getMobile());
			usr.setFlag(1);
			m.addAttribute("msg", "Welcome "+emp.getEmpname().toUpperCase());
			HttpSession session = request.getSession();
			session.setAttribute("data", usr);
			return "home";
		}
		else
		{
			m.addAttribute("msg","Invalid User!");
			return "redirect:index.jsp";
		}
	}
	
	@RequestMapping("/register")
	public String view2(Model m)
	{
		conn = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		Employee obj = conn.getBean("info",Employee.class);
		m.addAttribute("bean",obj);
		return "registerpage";
	}
	
	@RequestMapping("/insertdata")
	public String view3(@ModelAttribute("bean")Employee emp,Model m, HttpServletRequest request)
	{
		conn = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		HttpSession session = request.getSession();
		User use = (User)session.getAttribute("data");
		if(use.getFlag()==1)
		{
			EmployeeDao obj = conn.getBean("dao",EmployeeDao.class);
			obj.saveRecord(emp);
			m.addAttribute("msg", "Record insert successfully..");
			return "registerpage";
		}
		else
		{
			return "redirect:index.jsp";
		}
		
	}
	
	@RequestMapping("/display")
	public String view4(Model m, HttpServletRequest request)
	{
		conn = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		HttpSession session = request.getSession();
		User use = (User)session.getAttribute("data");
		if(use.getFlag()==1)
		{
			EmployeeDao obj = conn.getBean("dao", EmployeeDao.class);
			List list = obj.viewRecord();
		if(!list.isEmpty())
		{
			m.addAttribute("data",list);
		}
		else
		{
			m.addAttribute("msg", "Oops! Record not found");
		}
		return "displaypage";
		}
		else
		{
			return "redirect:index.jsp";
		}
	}
	
	@RequestMapping("/search")
	public String view5(Model m)
	{
		conn = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		Employee obj = conn.getBean("info",Employee.class);
		m.addAttribute("bean",obj);
		return "searchpage";
	}
	
	@RequestMapping("/searchdata")
	public String view6(@ModelAttribute("bean") Employee emp, Model m, HttpServletRequest request)
	{
		conn = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		HttpSession session = request.getSession();
		User use = (User)session.getAttribute("data");
		if(use.getFlag()==1)
		{
		EmployeeDao obj = conn.getBean("dao", EmployeeDao.class);
		List list = obj.findRecord(emp);
		if(!list.isEmpty())
		{
			m.addAttribute("li",list);
		}
		else
		{
			m.addAttribute("msg", "Oops! Record not found");
		}
			return "searchpage";
		}
		else
		{
			return "redirect:index.jsp";
		}
	}
	
	@RequestMapping("/advsearch")
	public String view7(Model m)
	{
		conn = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		Employee obj = conn.getBean("info", Employee.class);
		m.addAttribute("bean",obj);
		return "advsearchpage";
	}
	
	@RequestMapping("/advfind")
	public String view8(@ModelAttribute("bean")Employee emp,Model m, HttpServletRequest request)
	{
		conn = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		HttpSession session = request.getSession();
		User use = (User)session.getAttribute("data");
		if(use.getFlag()==1)
		{
		EmployeeDao obj = conn.getBean("dao", EmployeeDao.class);
		List list = obj.advanceSearch(emp);
		if(!list.isEmpty())
		{
			m.addAttribute("li",list);
		}
		else
		{
			m.addAttribute("msg", "Oops! Record not found");
		}
			return "advsearchpage";
		}
		else
		{
			return "redirect:index.jsp";
		}
	}
	
	@RequestMapping("/update")
	public String view9(@ModelAttribute("bean") Employee emp, Model m, HttpServletRequest request)
	{
		conn = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		HttpSession session = request.getSession();
		User use = (User)session.getAttribute("data");
		if(use.getFlag()==1)
		{
		EmployeeDao obj = conn.getBean("dao", EmployeeDao.class);
		List list = obj.editRecord(emp);
		m.addAttribute("li", list);
		m.addAttribute("msgs","Update successfully...");
		return "advsearchpage";
		}
		else
		{
			return "redirect:index.jsp";
		}
	}
	
	@RequestMapping("/delete")
	public String view10(@ModelAttribute("bean")Employee emp, Model m, HttpServletRequest request)
	{
		conn = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		HttpSession session = request.getSession();
		User use = (User)session.getAttribute("data");
		if(use.getFlag()==1)
		{
		EmployeeDao obj = conn.getBean("dao", EmployeeDao.class);
		List list = obj.dropRecord(emp);
		m.addAttribute("li", list);
		m.addAttribute("dmsg","Delete successfully...");
		return "advsearchpage";
		}
		else
		{
			return "redirect:index.jsp";
		}
	}
	
	@RequestMapping("/logout")
	public String view13(HttpServletRequest request, Model m)
	{
		HttpSession session = request.getSession();
		User obj = (User)session.getAttribute("data");
		obj.setFlag(0);
		return "redirect:index.jsp";
	}
}

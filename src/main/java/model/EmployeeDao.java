package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmployeeDao 
{
	private Configuration con;
	private SessionFactory factory;
	private Session session;
	private Transaction t;

	public void saveRecord(Employee emp) 
	{
		con = new Configuration().configure("hibernate.cfg.xml");
		factory = con.buildSessionFactory();
		session = factory.openSession();
		t = session.beginTransaction();
		session.save(emp);
		t.commit();
		
	}

	public List viewRecord() 
	{
		con = new Configuration().configure("hibernate.cfg.xml");
		factory = con.buildSessionFactory();
		session = factory.openSession();
		t = session.beginTransaction();
		List list = session.createQuery("from Employee").list();
		return list;
	}

	public List findRecord(Employee emp) 
	{
		List li = new ArrayList();
		con = new Configuration().configure("hibernate.cfg.xml");
		factory = con.buildSessionFactory();
		session = factory.openSession();
		t = session.beginTransaction();
		List list =session.createQuery("from Employee").list();
		Iterator it  = list.iterator();
		while(it.hasNext())
		{
			Employee e = (Employee)it.next();
			if(emp.getEmpcode()==e.getEmpcode())
			{
				Employee obj = new Employee();
				obj.setEmpcode(e.getEmpcode());
				obj.setEmpname(e.getEmpname());
				obj.setAddress(e.getAddress());
				obj.setDesignation(e.getDesignation());
				obj.setMobile(e.getMobile());
				obj.setEmail(e.getEmail());
				li.add(obj);
			}
		}
		return li;
	}

	public List advanceSearch(Employee emp) 
	{
		List li = new ArrayList();
		con = new Configuration().configure("hibernate.cfg.xml");
		factory = con.buildSessionFactory();
		session = factory.openSession();
		t = session.beginTransaction();
		List list =session.createQuery("from Employee").list();
		Iterator it  = list.iterator();
		while(it.hasNext())
		{
			Employee e = (Employee)it.next();
			if((emp.getEmpcode()==e.getEmpcode()) || (emp.getEmpname().equalsIgnoreCase(e.getEmpname()) || (emp.getAddress().equalsIgnoreCase(e.getAddress()) ||(emp.getDesignation().equalsIgnoreCase(e.getDesignation()) || (emp.getMobile().equals(e.getMobile()) || (emp.getEmail().equalsIgnoreCase(e.getEmail())))))))
			{
				Employee obj = new Employee();
				obj.setEmpcode(e.getEmpcode());
				obj.setEmpname(e.getEmpname());
				obj.setAddress(e.getAddress());
				obj.setDesignation(e.getDesignation());
				obj.setMobile(e.getMobile());
				obj.setEmail(e.getEmail());
				li.add(obj);
			}
		}
		return li;
	}

	public List editRecord(Employee emp) 
	{
		con = new Configuration().configure("hibernate.cfg.xml");
		factory = con.buildSessionFactory();
		session = factory.openSession();
		t = session.beginTransaction();
		Employee obj = session.get(Employee.class, emp.getEmpcode());
		obj.setEmpname(emp.getEmpname());
		obj.setAddress(emp.getAddress());
		obj.setDesignation(emp.getDesignation());
		obj.setMobile(emp.getMobile());
		obj.setEmail(emp.getEmail());
		session.update(obj);
		t.commit();
		List li = viewRecord();
		return li;
	}

	public List dropRecord(Employee emp) 
	{
		con = new Configuration().configure("hibernate.cfg.xml");
		factory = con.buildSessionFactory();
		session = factory.openSession();
		t = session.beginTransaction();
		Employee obj = session.get(Employee.class, emp.getEmpcode());
		session.delete(obj);
		t.commit();
		List li = viewRecord();
		return li;
	}

	public boolean checkLogin(Employee emp) 
	{
		boolean flag = false;
		con = new Configuration().configure("hibernate.cfg.xml");
		factory = con.buildSessionFactory();
		session = factory.openSession();
		t = session.beginTransaction();
		List list = session.createQuery("from Employee").list();
		Iterator it = list.iterator();
		while(it.hasNext())
		{
			Employee obj = (Employee)it.next();
			if(obj.getEmpname().equalsIgnoreCase(emp.getEmpname()) && obj.getMobile().equals(emp.getMobile()))
			{
				flag = true;
			}
		}
		return flag;
	}

}

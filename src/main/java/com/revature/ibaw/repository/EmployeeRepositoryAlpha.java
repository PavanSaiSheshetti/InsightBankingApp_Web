package com.revature.ibaw.repository;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.revature.ibaw.model.Customer;
import com.revature.ibaw.model.Employee;
import com.revature.ibaw.util.HibernateBuildSessionFactory;

public class EmployeeRepositoryAlpha implements EmployeeRepository{
	
	Employee employee=new Employee();
	SessionFactory sessionFactory=HibernateBuildSessionFactory.getSessionFactory();
	Session session=sessionFactory.openSession();
	public EmployeeRepositoryAlpha() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public long viewAccountBalance(long accountNumber) {
		// TODO Auto-generated method stub
		int balance=-1;
		Query query=session.createQuery("select accountBalance from com.revature.ibaw.model.Customer where accountNumber="+accountNumber);
		List list= query.list();
		return (long) list.get(0); 

	}

	@Override
	public List<Customer> getCustomerBankAccounts() {
		// TODO Auto-generated method stub
		Query query=session.createQuery("from com.revature.ibaw.model.Customer");
		List list= query.list();
		return list;
		
	}

	@Override
	public Customer getCustomerDetails(long accountNumber) {
		// TODO Auto-generated method stub
		Query query=session.createQuery("from com.revature.ibaw.model.Customer where accountNumber="+accountNumber);
		List<Customer> customer=query.list();
		if(customer.isEmpty()==false) {
			return customer.get(0);
		}
		return null;
	}

	@Override
	public String validateEmployee(String employeeUserName, String employeePassword) {
		// TODO Auto-generated method stub
		int res=0;
		Query query= session.createQuery("from com.revature.ibaw.model.Employee where employeeUserName=:userName and employeePassword=:password")
				.setParameter("userName", employeeUserName)
				.setParameter("password", employeePassword);
		List list=query.list();
		if(query.list().size()==0) {
			return null;
		}
		else {
			Session session=sessionFactory.openSession();
			employee=(Employee) session.load(Employee.class, employeeUserName);
			return employee.getEmployeeFirstName()+" "+employee.getEmployeeLastName();
		}
	}

	@Override
	public String isCustomerExist(long accountNumber) {
		// TODO Auto-generated method stub
		Query query=session.createQuery("from com.revature.ibaw.model.Customer where accountNumber="+accountNumber);
		List<Customer> customer=  query.list();
		if(customer.isEmpty()==false)
			return customer.get(0).getCustomerFirstName();
		else
			return null;
	}

	@Override
	public boolean approveAccount(long accountNumber) {
		// TODO Auto-generated method stub
		Transaction transaction=session.beginTransaction();
		long cifId=0;
		Query query=session.createQuery("from com.revature.ibaw.model.Customer where accountNumber="+accountNumber);
		List<Customer> list=  query.list();
		Customer customer=new Customer();
		customer=list.get(0);
		cifId=customer.getCustomerCifId();
		cifId=cifId+100000;
		customer.setCustomerCifId(cifId);
		session.update(customer);
		transaction.commit();
		System.out.println(customer);
		return true;
	}

}

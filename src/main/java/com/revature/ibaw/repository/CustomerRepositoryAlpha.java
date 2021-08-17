package com.revature.ibaw.repository;






import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.revature.ibaw.model.Customer;
import com.revature.ibaw.service.EmployeeService;
import com.revature.ibaw.service.EmployeeServiceAlpha;
import com.revature.ibaw.util.HibernateBuildSessionFactory;

public class CustomerRepositoryAlpha implements CustomerRepository {

	Customer customer=new Customer();
	EmployeeService employeeService=new EmployeeServiceAlpha();
	SessionFactory sessionFactory=HibernateBuildSessionFactory.getSessionFactory();
	Session session=sessionFactory.openSession();
	
	public CustomerRepositoryAlpha() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean addCustomer(Customer customer) {
		// TODO Auto-generated method stub
//		Customer customerDemo=new Customer();
//		customerDemo=loadCustomerDetails(customer.getCustomerUserName());
//		if(customerDemo==null) {
			Transaction transaction=session.beginTransaction();
			session.save(customer);
			transaction.commit();
			session.close();
			return true;
//		}
//		return false;

	}

	@Override
	public Customer makeWithdrawal(Customer customer, long debitAmount) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		Query query= (Query) session.getNamedQuery("makeWithdrawalQuery").
				setParameter("debitAmount", debitAmount).
				setParameter("accountNumber", customer.getAccountNumber());
		query.executeUpdate();
		transaction.commit();
		customer=loadCustomerDetails(customer.getCustomerUserName());
		return customer;
	}

	@Override
	public Customer makeDeposit(Customer customer, long creditAmount) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		Query query= (Query) session.getNamedQuery("makeDepositQuery").
				setParameter("creditAmount", creditAmount)
				.setParameter("accountNumber", customer.getAccountNumber());
		query.executeUpdate();
		transaction.commit();
		customer=loadCustomerDetails(customer.getCustomerUserName());
		return customer;

	}

	@Override
	public Customer makeMoneyTransfer(Customer customer, long customerAccountNumber, long amount) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		String name=employeeService.isCustomerExist(customerAccountNumber);
		if(name!=null) {
			Query query= session.createSQLQuery("Call ibaw.transferAmountProcedure(:senderId,:recieverId,:amount)")
					.addEntity(Customer.class)
					.setParameter("senderId",customer.getAccountNumber())
					.setParameter("recieverId", customerAccountNumber)
					.setParameter("amount", amount);
			query.executeUpdate();
			transaction.commit();
			customer=loadCustomerDetails(customer.getCustomerUserName());
			return customer;
		}
		else {
			return null;
		}

	}

	@Override
	public void aboutApp() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Customer loadCustomerDetails(String customerUserName) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		customer=(Customer) session.get(Customer.class, customerUserName);
		if(customer!=null)
			return customer;
		else
			return null;
	}

	@Override
	public Customer validateCustomer(String customerUserName, String customerPassword) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		int res=0;
		Query query=(Query) session.getNamedQuery("validateCustomerQuery")
				.setParameter("userName", customerUserName)
				.setParameter("password", customerPassword);
		List list=query.list();
		if(query.list().size()==0) {
			return null;
		}
		else {
			customer=loadCustomerDetails(customerUserName);
			return customer;
		}
			
	}

	@Override
	public boolean deleteCustomer(String CustomeruserName) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		Customer customer=new Customer();
		customer.setCustomerUserName(CustomeruserName);
		session.delete(customer);
		transaction.commit();
		return true;
	}

}

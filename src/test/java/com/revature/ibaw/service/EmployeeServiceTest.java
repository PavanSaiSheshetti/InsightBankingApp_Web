package com.revature.ibaw.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.ibaw.model.Customer;
import com.revature.ibaw.model.Employee;

public class EmployeeServiceTest {

	Employee employee;
	Customer customer;
	CustomerService customerService=new CustomerServiceAlpha();
	EmployeeService employeeService=new EmployeeServiceAlpha();
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		employee=new Employee();
		customer=new Customer();
	}

	@After
	public void tearDown() throws Exception {
		employee=null;
		customer=null;
	}

	@Test
	public void testViewAccountBalance() {
		//added , get the balance and cross checked with actual balance
		customer=new Customer((long)123,"xhfkl","xzay","xlgek5h78dk","126",(long)-1234,(long)560,"10-08-2021 00:41am");
		customerService.addCustomer(customer);
		long result=employeeService.viewAccountBalance(-1234);
		assertEquals(560, result);
		customerService.deleteCustomer("xlgek5h78dk");
	}

	@Test
	public void testGetCustomerBankAccounts() {
		//get the list of bankAccounts and checked whether it is null or not
		//(also printed and cross checked all the bankAccounts)
		List list=employeeService.getCustomerBankAccounts();
		System.out.println(list);
		assertNotEquals(null, list.get(0));
	}

	@Test
	public void testGetCustomerDetails() {
		//added , customer details retrieved and cross checked with actual data(customerLastName)
		customer=new Customer((long)123,"xhfkl","xzay","xlgek5h78dk","126",(long)-1234,(long)560,"10-08-2021 00:41am");
		customerService.addCustomer(customer);
		customer=employeeService.getCustomerDetails(-1234);
		assertEquals("xzay", customer.getCustomerLastName());
		customerService.deleteCustomer("xlgek5h78dk");
	}

	@Test
	public void testValidateEmployee() {
		//retrieved the employee details and compared the result(full name return by validateEmployee)
		 employee=new Employee((long)953762,"Bharath Sai","Maddela","Bharath789","BharathSaiM");
		 String employeeName=employeeService.validateEmployee("BharathSaiM", "Bharath789");
		 String expectedName="Bharath Sai"+" "+"Maddela";
		 assertEquals(expectedName,employeeName);
	}

	@Test
	public void testIsCustomerExist() {
		//added ,get the result of(firstName)isCostemerExist and compared
		customer=new Customer((long)123,"xhfkl","xzay","xlgek5h78dk","126",(long)-1234,(long)560,"10-08-2021 00:41am");
		customerService.addCustomer(customer);
		String result=employeeService.isCustomerExist(-1234);
		assertEquals("xhfkl", result);
		customerService.deleteCustomer("xlgek5h78dk");
	}

	@Test
	public void testApproveAccount() {
		//added get the boolean true and compared
		//also printed the cifId in the console to cross check 
		customer=new Customer((long)12345,"xhfkl","xzay","xlgek5h78dk","126",(long)-1234,(long)560,"10-08-2021 00:41am");
		customerService.addCustomer(customer);
		boolean result=employeeService.approveAccount(-1234);
		assertEquals(true, result);
		customerService.deleteCustomer("xlgek5h78dk");
	}

}

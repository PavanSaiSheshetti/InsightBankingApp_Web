package com.revature.ibaw.service;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.ibaw.model.Customer;

public class CustomerServiceTest {

	Customer customer;
	CustomerService customerService=new CustomerServiceAlpha();
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		customer=new Customer();
	}

	@After
	public void tearDown() throws Exception {
		customer=null;
	}

	@Test
	public void testAddCustomer() {
		//added ,deposited amount and cross checked the password before and after deposit
		customer=new Customer((long)123,"xhfkl","xzay","xlgek5h78dk","126",(long)-1234,(long)560,"10-08-2021 00:41am");
		customerService.addCustomer(customer);
		customer=customerService.loadCustomerDetails("xlgek5h78dk");
		assertEquals("126", customer.getCustomerPassword());
		customerService.deleteCustomer("xlgek5h78dk");
	}

	@Test
	public void testMakeWithdrawal() {
		//added ,withdrawn amount and cross checked the balance before and after Withdrawal
		customer=new Customer((long)123,"xhfkl","xzay","xlgek5h78dk","126",(long)-1234,(long)560,"10-08-2021 00:41am");
		customerService.addCustomer(customer);
		customer=customerService.makeWithdrawal(customer,(long) 500);
		assertEquals(60,customer.getAccountBalance());
		customerService.deleteCustomer("xlgek5h78dk");
	}

	@Test
	public void testMakeDeposit() {
		//added ,deposited amount and cross checked the balance before and after deposit
		customer=new Customer((long)123,"xhfkl","xzay","xlgek5h78dk","126",(long)-1234,(long)560,"10-08-2021 00:41am");
		customerService.addCustomer(customer);
		customer=customerService.makeDeposit(customer, 440);
		assertEquals(1000,customer.getAccountBalance());
		customerService.deleteCustomer("xlgek5h78dk");
	}


	@Test
	public void testLoadCustomerDetails() {
		//added,loaded details and cross checked the balance after loading
		customer=new Customer((long)123,"xhfkl","xzay","xlgek5h78dk","126",(long)-1234,(long)560,"10-08-2021 00:41am");
		customerService.addCustomer(customer);
		customer=customerService.loadCustomerDetails("xlgek5h78dk");
		assertEquals(560,customer.getAccountBalance());
		customerService.deleteCustomer("xlgek5h78dk");
	}

	@Test
	public void testValidateCustomer() {
		//added, validated (loads details after successful validation) and cross checked the firstName
		customer=new Customer((long)123,"xhfkl","xzay","xlgek5h78dk","126",(long)-1234,(long)560,"10-08-2021 00:41am");
		customerService.addCustomer(customer);
		customer=customerService.validateCustomer("xlgek5h78dk", "126");
		assertEquals("xhfkl",customer.getCustomerFirstName());
		customerService.deleteCustomer("xlgek5h78dk");
	}
	@Test
	public void testMakeMoneyTransfer() {
		//added ,made money transfer to self account and cross checked the result
		customer=new Customer((long)123,"xhfkl","xzay","xlgek5h78dk","126",(long)-1234,(long)560,"10-08-2021 00:41am");
		customerService.addCustomer(customer);
		customer=customerService.makeMoneyTransfer(customer, (long) -1234,(long) 440);
		//440 withdrawn and deposited to same account...
		assertEquals(560,customer.getAccountBalance());
		customerService.deleteCustomer("xlgek5h78dk");
	}

}

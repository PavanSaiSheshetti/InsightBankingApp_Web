package com.revature.ibaw.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.ibaw.model.Customer;
import com.revature.ibaw.service.CustomerService;
import com.revature.ibaw.service.CustomerServiceAlpha;
import com.revature.ibaw.service.EmployeeService;
import com.revature.ibaw.service.EmployeeServiceAlpha;

/**
 * Servlet implementation class CustomerOperationsServlet
 */
public class CustomerOperationsServlet extends HttpServlet {
	Customer customer=new Customer();
	CustomerService customerService=new CustomerServiceAlpha();
	EmployeeService employeeService=new EmployeeServiceAlpha();
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerOperationsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		String n=request.getParameter("operation");
//		out.println("<html><body><h1>");
//		out.println(n);
//		out.println("</h1></body></html>");
		customer=customerService.loadCustomerDetails((String)session.getAttribute("customerUserName"));
		if(n.equals("deposit")) {
			long creditamount=Long.parseLong(request.getParameter("creditamount"));
			session.setAttribute("creditamount", creditamount);
			customer=new Customer((long)session.getAttribute("customerCifId"),
					(String)session.getAttribute("customerFirstName"),
					(String)session.getAttribute("customerLastName"),
					(String)session.getAttribute("customerUserName"),
					(String)session.getAttribute("customerPassword"),
					(long)session.getAttribute("accountNumber"),
					(long)session.getAttribute("accountBalance"),
					(String)session.getAttribute("dateOfAccountCreation"));
			customer=customerService.makeDeposit(customer, creditamount);
			session.setAttribute("accountBalance", customer.getAccountBalance());
			out.println("<html><body>");
			out.println("<h1>"+customer.getCustomerFirstName()+" "
			+customer.getCustomerLastName()+" you successfully deposited INR "
			+creditamount+" in your account."+"<br/> and your current balance is "
			+customer.getAccountBalance()+"</h1>");
			out.println("</body></html>");
			RequestDispatcher dispatcher=request.getRequestDispatcher("CustomerDashboard.jsp");
			dispatcher.include(request, response);
		}
		else if(n.equals("withdraw")) {
			long debitamount=Long.parseLong(request.getParameter("debitamount"));
			long presentBalance=customer.getAccountBalance();
			if(presentBalance>=debitamount+2000) {
				session.setAttribute("debitamount", debitamount);
				customer=new Customer((long)session.getAttribute("customerCifId"),
						(String)session.getAttribute("customerFirstName"),
						(String)session.getAttribute("customerLastName"),
						(String)session.getAttribute("customerUserName"),
						(String)session.getAttribute("customerPassword"),
						(long)session.getAttribute("accountNumber"),
						(long)session.getAttribute("accountBalance"),
						(String)session.getAttribute("dateOfAccountCreation"));
				customer=customerService.makeWithdrawal(customer, debitamount);
				session.setAttribute("accountBalance", customer.getAccountBalance());
				out.println("<html><body>");
				out.println("<h1>"+customer.getCustomerFirstName()+" "
				+customer.getCustomerLastName()+" you successfully withdrawn INR "
				+debitamount+" in your account."+"<br/> and your current balance is "
				+customer.getAccountBalance()+"</h1>");
				out.println("</body></html>");
				RequestDispatcher dispatcher=request.getRequestDispatcher("CustomerDashboard.jsp");
				dispatcher.include(request, response);
			}
			else {
				out.println("<html><body>");
				out.println("<font color='red'><h6>Account balance is insufficient(you must maintain a minimum of INR 2000 in your account)</h6></font>");
				out.println("</body></html>");
				RequestDispatcher dispatcher=request.getRequestDispatcher("CustomerDashboard.jsp");
				dispatcher.include(request, response);
			}
		}
		else if(n.equals("transfer")) {
			Long recieverAccountNumber=Long.parseLong(request.getParameter("accountNumber"));
			Long transferamount=Long.parseLong(request.getParameter("transferamount"));
			long presentBalance=(long) session.getAttribute("accountBalance");
//			System.out.println(recieverAccountNumber+"   "+(long)session.getAttribute("accountNumber"));
			if(recieverAccountNumber!=(long)session.getAttribute("accountNumber")) {
				if(presentBalance>=transferamount+2000) {
					session.setAttribute("transferamount", transferamount);
					customer=new Customer((long)session.getAttribute("customerCifId"),
							(String)session.getAttribute("customerFirstName"),
							(String)session.getAttribute("customerLastName"),
							(String)session.getAttribute("customerUserName"),
							(String)session.getAttribute("customerPassword"),
							(long)session.getAttribute("accountNumber"),
							(long)session.getAttribute("accountBalance"),
							(String)session.getAttribute("dateOfAccountCreation"));
					customer=customerService.makeMoneyTransfer(customer, recieverAccountNumber, transferamount);
					if(customer!=null) {
						session.setAttribute("accountBalance", customer.getAccountBalance());
						out.println("<html><body>");
						out.println("<h1>"+customer.getCustomerFirstName()+" "
						+customer.getCustomerLastName()+" you successfully transfered INR "
						+transferamount+" from your account to "+ employeeService.isCustomerExist(recieverAccountNumber)+
						" with account number "+recieverAccountNumber+"<br/> and your current balance is "
						+customer.getAccountBalance()+"</h1>");
						out.println("</body></html>");
						RequestDispatcher dispatcher=request.getRequestDispatcher("CustomerDashboard.jsp");
						dispatcher.include(request, response);
					}
					else {
						out.println("<html><body>");
						out.println("<font color='red'><h6>The account number you entered is incorrect...please try again</h6></font>");
						out.println("</body></html>");
						RequestDispatcher dispatcher=request.getRequestDispatcher("CustomerDashboard.jsp");
						dispatcher.include(request, response);
					}
				}
				else {
					out.println("<html><body>");
					out.println("<font color='red'><h6>Account balance is insufficient(you must maintain a minimum of INR 2000 in your account)</h6></font>");
					out.println("</body></html>");
					RequestDispatcher dispatcher=request.getRequestDispatcher("CustomerDashboard.jsp");
					dispatcher.include(request, response);
				}
			}else {
				out.println("<html><body>");
				out.println("<font color='red'><h6>you can't transfer amount to your self account</h6></font>");
				out.println("</body></html>");
				RequestDispatcher dispatcher=request.getRequestDispatcher("CustomerDashboard.jsp");
				dispatcher.include(request, response);
			}
		
		}
		else if(n.equals("logout")) {
			out.println("<html><body>");
			System.out.print(customer.getCustomerFirstName());
			out.println("<h1>"+customer.getCustomerFirstName()+" "+customer.getCustomerLastName()+
					" you successfully logged out");
			out.println("<br/><a href=Welcome.html>goto Home</a></h1>");
			out.println("</body></html>");
			session.invalidate();
		}
		
		
	}

}

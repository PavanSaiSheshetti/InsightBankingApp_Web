package com.revature.ibaw.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.ibaw.model.Customer;
import com.revature.ibaw.model.Employee;
import com.revature.ibaw.service.CustomerService;
import com.revature.ibaw.service.CustomerServiceAlpha;
import com.revature.ibaw.service.EmployeeService;
import com.revature.ibaw.service.EmployeeServiceAlpha;

/**
 * Servlet implementation class EmployeeOperationsServlet
 */
public class EmployeeOperationsServlet extends HttpServlet {
	Customer customer=new Customer();
	Employee employee=new Employee();
	CustomerService custtomeService=new CustomerServiceAlpha();
	EmployeeService employeeService=new EmployeeServiceAlpha();
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeOperationsServlet() {
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
		String operation=request.getParameter("operation");
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		
		if(operation.equals("getBalance")) {
			long accountNumber=Long.parseLong(request.getParameter("accountNumberB"));
			String customerName=employeeService.isCustomerExist(accountNumber);
			if(customerName!=null) {
				long balance=employeeService.viewAccountBalance(accountNumber);
				out.println("<html><body>");
				out.println("<h1> account balance of "+ customerName+" with account number "
				+accountNumber+" is "+balance+"</h1>");
				out.println("</body></html>");
				RequestDispatcher dispatcher=request.getRequestDispatcher("EmployeeDashboard.jsp");
				dispatcher.include(request, response);
			}
			else {
				out.println("<html><body>");
				out.println("<font color='red'><h6>The account number you entered is does not exist in records</h6></font>");
				out.println("</body></html>");
				RequestDispatcher dispatcher=request.getRequestDispatcher("EmployeeDashboard.jsp");
				dispatcher.include(request, response);
			}
		}
		else if(operation.equals("getCustomerDetails")) {
			long accountNumber=Long.parseLong(request.getParameter("accountNumberC"));
			String customerName=employeeService.isCustomerExist(accountNumber);
			if(customerName!=null) {
				customer=employeeService.getCustomerDetails(accountNumber);
				session.setAttribute("PresentCustomerDetails", customer);
//				out.println("<html><body>");
//				out.println("<h1>"+customer+"</h1>");
//				out.println("</body></html>");
				RequestDispatcher dispatcher=request.getRequestDispatcher("viewCustomerDetails.jsp");
				dispatcher.include(request, response);
			}
			else {
				out.println("<html><body>");
				out.println("<font color='red'><h6>The account number you entered is does not exist in records</h6></font>");
				out.println("</body></html>");
				RequestDispatcher dispatcher=request.getRequestDispatcher("EmployeeDashboard.jsp");
				dispatcher.include(request, response);
			}
		}
		else if(operation.equals("getBankAccounts")) {
			List list=employeeService.getCustomerBankAccounts();
			session.setAttribute("allCustomers", list);
//			out.println("<html><body>");
//			out.println("<h1>"+list+"</h1>");
//			out.println("</body></html>");
			RequestDispatcher dispatcher=request.getRequestDispatcher("ViewBankAccountDetails.jsp");
			dispatcher.include(request, response);
		}
		else if(operation.equals("approveAccount")) {
			long accountNumber=Long.parseLong(request.getParameter("accountNumberA"));
			String customerName=employeeService.isCustomerExist(accountNumber);
			if(customerName!=null) {
				customer=employeeService.getCustomerDetails(accountNumber);
				long cifId=customer.getCustomerCifId();
				if(cifId>=10000 && cifId<=99999 ) {
					employeeService.approveAccount(accountNumber);
					out.println("<html><body>");
					out.println("<h1>"+ customerName+" account successfully approved"+"</h1>");
					out.println("</body></html>");
					RequestDispatcher dispatcher=request.getRequestDispatcher("EmployeeDashboard.jsp");
					dispatcher.include(request, response);
				}
				else {
					out.println("<html><body>");
					out.println("<font color='red'><h1>"+customerName+" account already approved"+"</h1></font>");
					out.println("</body></html>");
					RequestDispatcher dispatcher=request.getRequestDispatcher("EmployeeDashboard.jsp");
					dispatcher.include(request, response);
				}

			}
			else {
				out.println("<html><body>");
				out.println("<font color='red'><h6>The account number you entered is does not exist in records</h6></font>");
				out.println("</body></html>");
				RequestDispatcher dispatcher=request.getRequestDispatcher("EmployeeDashboard.jsp");
				dispatcher.include(request, response);
			}
		}
		else if(operation.equals("log")) {
			out.println("<html><body>");
			out.println("<font color='red' text-align='center'><h1>Insight Banking Log</h1></font>");
			out.println("</body></html>");
			RequestDispatcher dispatcher=request.getRequestDispatcher("showLog.jsp");
			dispatcher.include(request, response);
		}
		else if(operation.equals("logout")) {
			out.println("<html><body>");
			out.println("<h1>"+session.getAttribute("employeeName")+ " you successfully logged out");
			out.println("<br/><a href=Welcome.html>goto Home</a></h1>");
			out.println("</body></html>");
		}
	}

}

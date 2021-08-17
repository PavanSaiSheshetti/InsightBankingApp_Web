package com.revature.ibaw.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

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
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	Customer customer=new Customer();
	Employee employee=new Employee();
	CustomerService customerService=new CustomerServiceAlpha();
	EmployeeService employeeService=new EmployeeServiceAlpha();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		String type=request.getParameter("type");
		if(type.equals("employee")) {
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			HttpSession session=request.getSession();
			String userName=request.getParameter("userName");
			String password=request.getParameter("password");
			String employeeName=employeeService.validateEmployee(userName, password);
			session.setAttribute("employeeName", employeeName);
			if(employeeName!=null) {
				Date lastLoggedInDate= new Date();
				out.println("<html><body>");
				out.println("<h1>"+employeeName+" you successfully logged in to your account"+"</h1>");
				out.println("</body></html>");
				RequestDispatcher dispatcher=request.getRequestDispatcher("EmployeeDashboard.jsp");
				dispatcher.include(request, response);
			}
			else {
				out.println("<html><body>");
				out.println("<font color='red'><h6>Invalid Username or Password !!</h6></font>");
				out.println("</body></html>");
				RequestDispatcher dispatcher=request.getRequestDispatcher("EmployeeLogin.jsp");
				dispatcher.include(request, response);
			}
		}
		else if(type.equals("customer")){
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			HttpSession session=request.getSession();
			String userName=request.getParameter("userName");
			String password=request.getParameter("password");
			customer=customerService.validateCustomer(userName, password);
			if(customer!=null) {
				long cifId=customer.getCustomerCifId();
				if(cifId>=100000 && cifId<=999999) {
					Date lastLoggedInDate= new Date();
					session.setAttribute("customerFirstName", customer.getCustomerFirstName());
					session.setAttribute("customerLastName", customer.getCustomerLastName());
					session.setAttribute("customerUserName", customer.getCustomerUserName());
					session.setAttribute("customerPassword", customer.getCustomerPassword());
					session.setAttribute("customerCifId", customer.getCustomerCifId());
					session.setAttribute("accountNumber", customer.getAccountNumber());
					session.setAttribute("accountBalance", customer.getAccountBalance());
					session.setAttribute("dateOfAccountCreation", customer.getDateOfAccountCreation());
					session.setAttribute("lastLoggedInDate", lastLoggedInDate);
					out.println("<html><body>");
					out.println("<h1>"+customer.getCustomerFirstName()+" "+
					customer.getCustomerLastName()+" you successfully logged in to your account"+"</h1>");
					out.println("</body></html>");
					RequestDispatcher dispatcher=request.getRequestDispatcher("CustomerDashboard.jsp");
					dispatcher.include(request, response);
				}
				else {
					out.println("<html><body>");
					out.println("<font color='red'><h6>Your Account Not Approved Yet!!</h6></font>");
					out.println("<font color='red'><h6>Approval of Account will take 24 to 48 hours after you created your account </h6></font>");
					out.println("</body></html>");
					RequestDispatcher dispatcher=request.getRequestDispatcher("CustomerLogin.jsp");
					dispatcher.include(request, response);
				}

			}
			else{
				out.println("<html><body>");
				out.println("<font color='red'><h6>Invalid Username or Password !!</h6></font>");
				out.println("</body></html>");
				RequestDispatcher dispatcher=request.getRequestDispatcher("CustomerLogin.jsp");
				dispatcher.include(request, response);
			}
		}

		
	}

}

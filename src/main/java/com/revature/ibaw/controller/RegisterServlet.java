package com.revature.ibaw.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.classic.Session;

import com.revature.ibaw.model.Customer;
import com.revature.ibaw.repository.CustomerRepository;
import com.revature.ibaw.repository.CustomerRepositoryAlpha;
import com.revature.ibaw.service.CustomerService;
import com.revature.ibaw.service.CustomerServiceAlpha;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	
	Customer customer=new Customer();
	CustomerService customerService=new CustomerServiceAlpha();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		HttpSession session=request.getSession();
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String firstName=request.getParameter("firstName");
		String lastName=request.getParameter("lastName");
		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
		long openingDeposit=Integer.parseInt(request.getParameter("openingDeposit"));
		
		customer=customerService.loadCustomerDetails(userName);
		if(customer!=null) {
//			session.setAttribute("errorMessage", "sorry this username already exist "+userName);
//			session.setMaxInactiveInterval(5);
			out.println("<html><body>");
			out.println("<font color='red'><h1>sorry this username already exist</h1></font>");
			out.println("</body></html>");
			RequestDispatcher dispatcher=request.getRequestDispatcher("Register.jsp");
			dispatcher.include(request, response);
		}else {
			Long accountNumber = (long) (100000000 + Math.random() * 900000000);
			Long customerCifId= (long) (10000 + Math.random() * 90000);
			
			DateFormat df=new SimpleDateFormat();
			customer=new Customer(customerCifId, firstName, lastName, userName, password, accountNumber, openingDeposit, df.format(new Date()));
			customerService.addCustomer(customer);
			out.println("<html><body>");
			out.println("<h1> You successfully Created your Account and your Username is "+userName+" and "
					+ "Unique Account Number is "+accountNumber+" Please keep them for further reference</h1>");
			out.println("<h3> You will be redirected to home page within 10 seconds. If not please <a href=Welcome.html>click here</a><h3/> ");
			out.println("</html></body>");
//			response.sendRedirect("Welcome.html");
		}

		
		
	}

}

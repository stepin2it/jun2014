package com.example.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletTest
 */
public class ServletTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletTest() {
		super();
		// TODO Auto-generated constructor stub
		
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();

		out.println("Hello Java");

		if ((request.getParameter("atomicnumber") == null)) {

			getServletContext().getRequestDispatcher("/index.jsp").forward(
					request, response);
		}
		String atomicnumber = request.getParameter("atomicnumber");
		Integer atomicweight = Integer.parseInt(atomicnumber) * 2;
		request.setAttribute("atomicweight", atomicweight);
		getServletContext().getRequestDispatcher("/output.jsp").forward(
				request, response);

	}

}

package com.java.demo.processor;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.java.demo.bo.DepartmentDO;
import com.java.demo.dao.DepartmentDAO;

/**
 * Servlet implementation class DepartmentProcessor
 */


/**
 * This class is used to accept the request from the server and gives the
 * response.
 * 
 * @author moturi
 * 
 */


public class DepartmentProcessor extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private DepartmentDAO deptDaoObj = null;

	/**
	 * This constructor is used to create instance for the DepartmentDAO class
	 * by using get bean method from spring.xml file.
	 */

	public DepartmentProcessor() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "Spring.xml" });
		deptDaoObj = context.getBean("departmentDaoObj", DepartmentDAO.class);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	/**
	 * Whenever this method get the request from server , it calls the doPost
	 * method. In doPost method, it consists of business logic and gives the
	 * response.
	 */

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	/**
	 * This method takes the input values from the input class and performs the
	 * business logic. It takes the view from the request dispatcher and
	 * displays the results in the Department Processor page itself.
	 */

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Integer deptOut = null;
		DepartmentDO deptDO = null;
		DepartmentDO deptInObj1 = (DepartmentDO) request
				.getAttribute("deptIn");
		if (deptInObj1!=null) {
			String deptName = deptInObj1.getDeptName();
			Integer mgrId = deptInObj1.getMgrId();
			Integer locId = deptInObj1.getLocId();
			Integer deptId = deptInObj1.getDeptId();
			if ((deptName!=null)&&(mgrId!=0)&&(locId!=0)) {
				deptOut = deptDaoObj.addDepartment(deptName, mgrId, locId);
				request.setAttribute("deptOut", deptOut);
				RequestDispatcher reqDispObj = request
						.getRequestDispatcher("view/SearchDepartment.jsp");
				reqDispObj.forward(request, response);
			} else if(deptId!=0){
				deptDO = deptDaoObj.getDepartmentByPK(deptId);
				request.setAttribute("deptOut", deptDO);
				RequestDispatcher reqDispObj = request
						.getRequestDispatcher("view/DepartmentOutput.jsp");
				reqDispObj.forward(request, response);
			}else if((deptName!=null)){
				deptDaoObj.updateDepartment(deptId, deptName);
				RequestDispatcher reqDispObj = request
						.getRequestDispatcher("view/Home.jsp");
				reqDispObj.forward(request, response);
			}else {
				response.sendRedirect("view/Home.jsp");
			}
		} else {
			response.sendRedirect("view/Home.jsp");
		}
	}

}

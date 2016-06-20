package com.shreetesh.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shreetesh.model.Student;
import com.shreetesh.repository.StudentRepository;

@SuppressWarnings("serial")
public class StudentController extends HttpServlet {

	private StudentRepository studentRepository;

	private static String STUDENT_SIGNUP = "content/signup.jsp";
	private static String STUDENT_LOGIN = "content/login.jsp";
	private static String LOGIN_SUCCESS = "content/success.jsp";
	private static String LOGIN_FAILURE = "content/failure.jsp";
	private static String LIST_USER = "content/listUser.jsp";
	private static String INSERT_OR_EDIT = "content/update.jsp";

	public StudentController() {
		super();
		studentRepository = new StudentRepository();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter("action");

		request.getParameter("pageName");
		String forward = "";

		if (action != null && action.equalsIgnoreCase("delete")) {

			int studentId = Integer.parseInt(request.getParameter("studentId"));
			studentRepository.deleteStudent(studentId);
			forward = LIST_USER;
			request.setAttribute("students", studentRepository.getAllStudent());
		} else if (action != null && action.equalsIgnoreCase("edit")) {
			forward = INSERT_OR_EDIT;

			int studentId = Integer.parseInt(request.getParameter("studentId"));
			Student student = studentRepository.getStudentById(studentId);
			request.setAttribute("studentId", studentId);

		} else if (action != null && action.equalsIgnoreCase("update")) {

			int studentId = Integer.parseInt(request.getParameter("studentId"));
			Student student = studentRepository.getStudentById(studentId);

			student.setFirstName(request.getParameter("firstName"));
			student.setLastName(request.getParameter("lastName"));

			studentRepository.updateStudent(student);

			forward = LIST_USER;
		}

		else if (action != null && action.equalsIgnoreCase("listUser")) {
			forward = LIST_USER;

		}

		if (!forward.equals("") && !forward.equalsIgnoreCase(LIST_USER)) {
			RequestDispatcher view = request.getRequestDispatcher(forward);
			view.forward(request, response);
		} else {
			RequestDispatcher view1 = request.getRequestDispatcher(LIST_USER);
			request.setAttribute("students", studentRepository.getAllStudent());
			view1.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String pageName = request.getParameter("pageName");

		String forward = "";

		if (studentRepository != null) {

			if (pageName.equals("signup")) {
				if (studentRepository.findByUserName(request
						.getParameter("userName"))) {
					request.setAttribute("message",
							"User Name exists. Try another user name");
					forward = STUDENT_SIGNUP;
					RequestDispatcher view = request
							.getRequestDispatcher(forward);
					view.forward(request, response);
					return;
				}
				try {
					studentRepository.save(request.getParameter("userName"),
							request.getParameter("password"),
							request.getParameter("firstName"),
							request.getParameter("lastName"),
							request.getParameter("dateOfBirth"),
							request.getParameter("emailAddress"));
				} catch (ParseException e) {

					e.printStackTrace();
				}

				forward = STUDENT_LOGIN;

			} else if (pageName.equals("login")) {
				boolean result = studentRepository.findByLogin(
						request.getParameter("userName"),
						request.getParameter("password"));

				if (result == true) {

					forward = LOGIN_SUCCESS;
				} else {

					forward = LOGIN_FAILURE;
				}
			}

		}

		response.sendRedirect(request.getContextPath() + "/" + forward);

	}
}

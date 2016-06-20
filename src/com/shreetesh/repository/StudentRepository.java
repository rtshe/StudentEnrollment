package com.shreetesh.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.shreetesh.model.Student;
import com.shreetesh.util.DbUtil;

public class StudentRepository {
	private Connection dbConnection;

	public StudentRepository() {
		dbConnection = DbUtil.getConnection();
	}

	public void save(String userName, String password, String firstName,
			String lastName, String dateOfBirth, String emailAddress) throws ParseException {
		try {
			PreparedStatement prepStatement = dbConnection
					.prepareStatement("insert into student(  userName, password, firstName, lastName, dateOfBirth, emailAddress) values (?, ?, ?, ?, ?, ?)");

			prepStatement.setString(1, userName);
			prepStatement.setString(2, password);
			prepStatement.setString(3, firstName);
			prepStatement.setString(4, lastName);
			prepStatement.setDate(
					5,
					new java.sql.Date(new SimpleDateFormat("MM/dd/yyyy").parse(
							dateOfBirth.substring(0, 10)).getTime()));
			prepStatement.setString(6, emailAddress);
			prepStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean findByUserName(String userName) {
		try {
			PreparedStatement prepStatement = dbConnection
					.prepareStatement("select count(*) from student where userName = ?");
			prepStatement.setString(1, userName);

			ResultSet result = prepStatement.executeQuery();
			if (result != null) {
				while (result.next()) {
					if (result.getInt(1) == 1) {
						return true;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean findByLogin(String userName, String password) {
		try {
			PreparedStatement prepStatement = dbConnection
					.prepareStatement("select password from student where userName = ?");
			prepStatement.setString(1, userName);

			ResultSet result = prepStatement.executeQuery();
			if (result != null) {
				while (result.next()) {
					if (result.getString(1).equals(password)) {
						return true;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public void deleteStudent(int studentId) {
		try {

			PreparedStatement preparedStatement = dbConnection
					.prepareStatement("delete from student where studentId=?");
			preparedStatement.setInt(1, studentId);
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void addStudent(Student student) {
		try {
			String query = "insert into student (studentId,firstName, lastName, userName, emailAddress) values (?,?,?,?)";
			PreparedStatement preparedStatement = dbConnection
					.prepareStatement(query);
			preparedStatement.setInt(1, student.getStudentId());
			preparedStatement.setString(2, student.getFirstName());
			preparedStatement.setString(3, student.getLastName());
			preparedStatement.setString(4, student.getUserName());
			preparedStatement.setString(5, student.getPassword());
			preparedStatement.setString(6, student.getEmailAddress());
			preparedStatement.setDate(7, new java.sql.Date(student
					.getDateOfBirth().getTime()));

			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateStudent(Student student) {
		try {
			PreparedStatement preparedStatement = dbConnection
					.prepareStatement("update student set firstName = ?,lastName = ?,dateOfBirth = ?,emailAddress = ?"
							+ " where StudentId = " + student.getStudentId());
			
			System.out.println("aalu peda"+student.getStudentId());
			System.out.print("first time allu peda" + student.getFirstName());

			preparedStatement.setString(1, student.getFirstName());
			preparedStatement.setString(2, student.getLastName());
			preparedStatement.setDate(3, new java.sql.Date(student
					.getDateOfBirth().getTime()));
			preparedStatement.setString(4, student.getEmailAddress());
//			preparedStatement.setString(5, student.getUserName());
//			preparedStatement.setString(6, student.getPassword());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Student getStudentByEmail(String emailAddress){
		Student student = new Student();
		try{
			String query = "select * from student where emailAddress=?";
			PreparedStatement preparedStatement = dbConnection
					.prepareStatement(query);
			preparedStatement.setString(1, emailAddress);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				student.setStudentId(resultSet.getInt("studentId"));
				student.setFirstName(resultSet.getString("firstName"));
				student.setLastName(resultSet.getString("LastName"));
				student.setUserName(resultSet.getString("Username"));
				student.setDateOfBirth(resultSet.getDate("dateOfBirth"));
			}
			resultSet.close();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
}
	
	public List<Student> getAllStudent() {
		List<Student> students = new ArrayList<Student>();
		try {
			Statement statement = dbConnection.createStatement();

			ResultSet result = statement.executeQuery("Select * from student");
			while (result.next()) {
				Student student = new Student();
				student.setStudentId(result.getInt("studentId"));
				student.setFirstName(result.getString("firstName"));
				student.setLastName(result.getString("lastName"));
				student.setDateOfBirth(result.getDate("dateOfBirth"));
				student.setEmailAddress(result.getString("emailAddress"));
				student.setUserName(result.getString("userName"));
				student.setPassword(result.getString("Password"));

				students.add(student);

			}
			result.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return students;
	}

	public Student getStudentById(int studentId) {
		Student student = new Student();
		try {
			String query = "select * from student where StudentId=?";
			PreparedStatement preparedStatement = dbConnection
					.prepareStatement(query);
			preparedStatement.setInt(1, studentId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				student.setStudentId(resultSet.getInt("studentId"));
				student.setFirstName(resultSet.getString("firstName"));
				student.setLastName(resultSet.getString("LastName"));
				student.setUserName(resultSet.getString("Username"));
				student.setEmailAddress(resultSet.getString("EmailAddress"));
				student.setDateOfBirth(resultSet.getDate("dateOfBirth"));
			}
			resultSet.close();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return student;
	}
}

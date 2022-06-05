package admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class AdminOperations {

	public void giveAdminRights() {
		System.out.println("CHOOSE FROM THE BELOW OPTIONS"); // option starts
		System.out.println("1. Add Employee");
		System.out.println("2. Remove Employee");
		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);

		int AdminBankingOptions = s.nextInt();
		s.nextLine();

		if (AdminBankingOptions == 1) {
			addEmployee();
		} else if (AdminBankingOptions == 2) {
			System.out.println("Enter Employee Id");
			int empId = s.nextInt();
			s.nextLine();
			removeEmployee(empId);

		} else {
			System.out.println("Read the options carefully");
			giveAdminRights();
		}

	}

	public void addEmployee() {
		System.out.println("PLEASE FILL THE FOLLOWING DETAILS");
		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);

		System.out.println("Enter Employee Id:");
		int employeeId = s.nextInt();
		s.nextLine();

		System.out.println("Enter Employee Name:");
		String employeeName = s.nextLine();

		System.out.println("Enter Employee Number:");
		long contactNumber = s.nextLong();
		s.nextLine();

		System.out.println("Enter Employee Age:");
		int age = s.nextInt();
		s.nextLine();

		System.out.println("Enter Employee Gender");
		String gender = s.nextLine();

		System.out.println("Enter Password");
		String password = s.nextLine();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/aimless?autoReconnect=true&useSSL=false", "root", "qwerty123");

			String query = "insert into employeedetails values(?,?,?,?,?,?)";

			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, employeeId);
			stmt.setString(2, employeeName);
			stmt.setLong(3, contactNumber);
			stmt.setInt(4, age);
			stmt.setString(5, gender);
			stmt.setString(6, password);
			stmt.execute();

			System.out.println("Employee Details Added Successfully");
			con.close();
			System.out.println("Press 1 to Continue... Or Exit");
			int checkcontinue = s.nextInt();
			s.nextLine();
			if (checkcontinue == 1)
				giveAdminRights();
			else
				System.exit(0);

			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void removeEmployee(int employeeId) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/aimless?autoReconnect=true&useSSL=false", "root", "qwerty123");

			String query = "DELETE FROM employeedetails WHERE (EmployeeId = ?)";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, employeeId);
			stmt.execute();
			System.out.println("Employee Deleted Successfully");
			con.close();

			System.out.println("Press 1 to Continue... Or Exit");
			@SuppressWarnings("resource")
			Scanner s = new Scanner(System.in);
			int checkcontinue = s.nextInt();
			s.nextLine();
			if (checkcontinue == 1)
				giveAdminRights();
			else
				System.exit(0);

		} catch (Exception e) {
			System.out.println(e);
		}

	}
}

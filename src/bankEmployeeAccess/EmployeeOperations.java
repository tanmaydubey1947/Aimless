package bankEmployeeAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class EmployeeOperations {

	public void giveEmployeeBankingOptions() {
		System.out.println("CHOOSE FROM THE BELOW OPTIONS");
		System.out.println("1. Add Customer");
		System.out.println("2. Remove Customer");
		Scanner s = new Scanner(System.in);
		int employeeBankingOptions = s.nextInt();
		s.nextLine();

		if (employeeBankingOptions == 1) {
			addCustomer();
		} else if (employeeBankingOptions == 2) {
			System.out.println("Enter Customer Id");
			int customerId = s.nextInt();
			s.nextLine();
			deleteCustomer(customerId);

		} else {
			System.out.println("Read the options carefully");
			giveEmployeeBankingOptions();
		}
	}

	public void addCustomer() {
		System.out.println("PLEASE FILL THE FOLLOWING DETAILS");
		Scanner s = new Scanner(System.in);

		System.out.println("Enter Customer Id:");
		int customerId = s.nextInt();
		s.nextLine();

		System.out.println("Enter Customer Name:");
		String customerName = s.nextLine();

		System.out.println("Enter Contact Number:");
		long contactNumber = s.nextLong();
		s.nextLine();

		System.out.println("Enter Age:");
		int age = s.nextInt();
		s.nextLine();

		System.out.println("Enter Gender");
		String gender = s.nextLine();

		System.out.println("Enter Password");
		String password = s.nextLine();

		System.out.println("Enter Opening Amount:");
		int amount = s.nextInt();
		s.nextLine();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/aimless?autoReconnect=true&useSSL=false", "root", "qwerty123");

			String query = "insert into customerdetails values(?,?,?,?,?,?,?)";

			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, customerId);
			stmt.setString(2, customerName);
			stmt.setLong(3, contactNumber);
			stmt.setInt(4, age);
			stmt.setString(5, gender);
			stmt.setString(6, password);
			stmt.setInt(7, amount);
			stmt.execute();

			System.out.println("Customer Details Added Successfully");
			con.close();
			System.out.println("Press 1 to Continue... Or Exit");
			int checkcontinue = s.nextInt();
			s.nextLine();
			if (checkcontinue == 1)
				giveEmployeeBankingOptions();
			else
				System.exit(0);

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void deleteCustomer(int customerId) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/aimless?autoReconnect=true&useSSL=false", "root", "qwerty123");

			String query = "DELETE FROM customerdetails WHERE (customerId = ?)";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, customerId);
			stmt.execute();
			System.out.println("Customer Deleted Successfully");
			con.close();

			System.out.println("Press 1 to Continue... Or Exit");
			Scanner s = new Scanner(System.in);
			int checkcontinue = s.nextInt();
			s.nextLine();
			if (checkcontinue == 1)
				giveEmployeeBankingOptions();
			else
				System.exit(0);

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}

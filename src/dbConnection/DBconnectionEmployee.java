package dbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import bankEmployeeAccess.EmployeeOperations;

public class DBconnectionEmployee {

	public void dbCheckEmployee(int employeeId, String password) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/aimless?autoReconnect=true&useSSL=false", "root", "qwerty123");
			Statement stmt = con.createStatement();

			ResultSet EmployeeValidation = stmt.executeQuery(
					"select password from employeedetails where EmployeeId =" + String.valueOf(employeeId));
			EmployeeValidation.next();
			if (EmployeeValidation.getString("password").equals(password)) {
				ResultSet EmployeeDetails = stmt.executeQuery(
						"select EmployeeName from employeedetails where EmployeeId=" + String.valueOf(employeeId));

				EmployeeDetails.next();
				System.out.println("Hello " + EmployeeDetails.getString("EmployeeName") + " Welcome To AIMLESS BANK");
				con.close();
				EmployeeOperations eo = new EmployeeOperations();
				eo.giveEmployeeBankingOptions();
			}

			else {
				System.out.println("Wrong Credentials");
				con.close();
			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}

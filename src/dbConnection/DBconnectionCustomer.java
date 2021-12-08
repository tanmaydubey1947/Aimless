package dbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import customerAccess.CustomerOperations;

public class DBconnectionCustomer {

	public void dbCheckCustomer(int customerId, String password) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/aimless?autoReconnect=true&useSSL=false", "root", "qwerty123");
			Statement stmt = con.createStatement();

			ResultSet customerValidation = stmt.executeQuery(
					"select password from customerdetails where customerid =" + String.valueOf(customerId));
			customerValidation.next();
			if (customerValidation.getString("password").equals(password)) {
				ResultSet customerDetails = stmt.executeQuery(
						"select customerName from customerdetails where customerid=" + String.valueOf(customerId));

				customerDetails.next();
				System.out.println("Hello "+customerDetails.getString("customerName")+ " Welcome To AIMLESS BANK");
				con.close();
				CustomerOperations co = new CustomerOperations();
				co.giveCustomerBankingOptions(customerId);
			}

			else {
				System.out.println("Wrong Credentials");
				con.close();
			}

			// while (rs.next())
			// System.out.println(rs.getString("bankbalance"));
			// con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}

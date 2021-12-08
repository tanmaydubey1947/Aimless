package dbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import admin.AdminOperations;

public class DBconnectionAdmin {

	public void dbCheckAdmin(int AdminId, String password) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/aimless?autoReconnect=true&useSSL=false", "root", "qwerty123");
			Statement stmt = con.createStatement();

			ResultSet AdminValidation = stmt
					.executeQuery("select adminPassword from admin where adminId =" + String.valueOf(AdminId));
			AdminValidation.next();
			if (AdminValidation.getString("adminPassword").equals(password)) {
				ResultSet AdminDetails = stmt
						.executeQuery("select adminName from admin where adminId=" + String.valueOf(AdminId));

				AdminDetails.next();
				System.out.println("Hello " + AdminDetails.getString("adminName") + " Welcome To AIMLESS BANK");
				con.close();

				AdminOperations ao = new AdminOperations();
				ao.giveAdminRights();
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

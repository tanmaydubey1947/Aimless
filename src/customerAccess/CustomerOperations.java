package customerAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import startHere.ChooseBankingOptions;

public class CustomerOperations {

	public void giveCustomerBankingOptions(int customerId) {
		System.out.println("CHOOSE FROM THE BELOW OPTIONS");
		System.out.println("1. Check Current Balance");
		System.out.println("2. Withdraw Money");
		System.out.println("3. Add Money");

		Scanner s = new Scanner(System.in);
		int option = s.nextInt();
		s.nextLine();

		if (option == 1)
			checkCurrentBalance(customerId);
		else if (option == 2) {
			System.out.println("Enter Amount to Withdraw");
			int amount = s.nextInt();
			s.nextLine();
			withdrawMoney(customerId, amount);
		}

		else if (option == 3) {
			System.out.println("Enter Amount to Deposit");
			int amount = s.nextInt();
			s.nextLine();
			addMoney(customerId, amount);
		}

		else {
			System.out.println("INPUT VALID OPTIONS");
			giveCustomerBankingOptions(customerId);
		}

	}

	public void checkCurrentBalance(int customerId) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/aimless?autoReconnect=true&useSSL=false", "root", "qwerty123");
			Statement stmt = con.createStatement();

			ResultSet customerDetails = stmt.executeQuery(
					"select bankbalance from customerdetails where customerid=" + String.valueOf(customerId));
			customerDetails.next();
			System.out.println("Your Bank Balance is -  " + customerDetails.getInt("bankbalance"));

			System.out.println("Thank You For Using AIMLESS BANKING");
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		} 
		
		Scanner s = new Scanner(System.in);
		System.out.println("Press 1 to continue banking...");
		int continuebankingcheck = s.nextInt();s.nextLine();
		if(continuebankingcheck==1)
		{
			ChooseBankingOptions cbo = new ChooseBankingOptions();
			cbo.bankinOptionFunction();
		}
		else
			System.exit(0);
		
		
	}

	public void withdrawMoney(int customerId, int amount) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/aimless?autoReconnect=true&useSSL=false", "root", "qwerty123");
			Statement stmt = con.createStatement();

			ResultSet customerDetails = stmt.executeQuery(
					"select bankbalance from customerdetails where customerid=" + String.valueOf(customerId));
			customerDetails.next();

			amount = customerDetails.getInt("bankbalance") - amount;

			String query = "update customerdetails set bankbalance=? where customerId=?";

			PreparedStatement stmt1 = con.prepareStatement(query);
			stmt1.setInt(1, amount);
			stmt1.setInt(2, customerId);
			stmt1.execute();

			ResultSet customerDetailsUpdated = stmt.executeQuery(
					"select bankbalance from customerdetails where customerId=" + String.valueOf(customerId));

			customerDetailsUpdated.next();
			System.out.println("Your Bank Balance is -  " + customerDetailsUpdated.getInt("bankbalance"));

			System.out.println("Thank You For Using AIMLESS BANKING");
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
		Scanner s = new Scanner(System.in);
		System.out.println("Press 1 to continue banking...");
		int continuebankingcheck = s.nextInt();s.nextLine();
		if(continuebankingcheck==1)
		{
			ChooseBankingOptions cbo = new ChooseBankingOptions();
			cbo.bankinOptionFunction();
		}
		else
			System.exit(0);
	}

	public void addMoney(int customerId, int amount) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/aimless?autoReconnect=true&useSSL=false", "root", "qwerty123");
			Statement stmt = con.createStatement();

			ResultSet customerDetails = stmt.executeQuery(
					"select bankbalance from customerdetails where customerid=" + String.valueOf(customerId));
			customerDetails.next();
			amount = amount + customerDetails.getInt("bankbalance");

			String query = "update customerdetails set bankbalance=? where customerId=?";

			PreparedStatement stmt1 = con.prepareStatement(query);
			stmt1.setInt(1, amount);
			stmt1.setInt(2, customerId);
			stmt1.execute();

			ResultSet customerDetailsUpdated = stmt.executeQuery(
					"select bankbalance from customerdetails where customerId=" + String.valueOf(customerId));

			customerDetailsUpdated.next();
			System.out.println("Your Bank Balance is -  " + customerDetailsUpdated.getInt("bankbalance"));

			System.out.println("Thank You For Using AIMLESS BANKING");
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
		Scanner s = new Scanner(System.in);
		System.out.println("Press 1 to continue banking...");
		int continuebankingcheck = s.nextInt();s.nextLine();
		if(continuebankingcheck==1)
		{
			ChooseBankingOptions cbo = new ChooseBankingOptions();
			cbo.bankinOptionFunction();
		}
		else
			System.exit(0);

	}

}

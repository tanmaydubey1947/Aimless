package customerAccess;

import java.util.Scanner;

import dbConnection.DBconnectionCustomer;

public class ValidateCustomer {

	private int id;
	private String password;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public void takeCustomerCredentials()
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter Customer Id : ");
		int id = s.nextInt();
		s.nextLine();
		System.out.println("Enter Customer Password : ");
		String password = s.nextLine();
		
		DBconnectionCustomer dgcc = new DBconnectionCustomer();
		dgcc.dbCheckCustomer(id,password);
		
	}
	
}

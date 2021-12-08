package admin;

import java.util.Scanner;

import dbConnection.DBconnectionAdmin;

public class ValidateAdmin {
	
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
	
	public void takeAdminCredentials()
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter Admin Id : ");
		int id = s.nextInt();
		s.nextLine();
		System.out.println("Enter Admin Password : ");
		String password = s.nextLine();
		
		DBconnectionAdmin dbca = new DBconnectionAdmin();
		dbca.dbCheckAdmin(id, password);

	}
	
	
}

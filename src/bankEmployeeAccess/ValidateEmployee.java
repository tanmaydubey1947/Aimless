package bankEmployeeAccess;

import java.util.Scanner;

import dbConnection.DBconnectionEmployee;

public class ValidateEmployee {
	
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
	
	public void takeEmployeeCredentials()
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter Employee Id : ");
		int id = s.nextInt();
		s.nextLine();
		System.out.println("Enter Employee Password : ");
		String password = s.nextLine();
		
		DBconnectionEmployee dbce = new DBconnectionEmployee();
		dbce.dbCheckEmployee(id, password);
		
		
		
	}

}

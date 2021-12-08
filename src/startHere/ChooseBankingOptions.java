package startHere;

import java.util.Scanner;

import admin.ValidateAdmin;
import bankEmployeeAccess.ValidateEmployee;
import customerAccess.ValidateCustomer;

public class ChooseBankingOptions {

	public int bankingOptions;

	public void bankinOptionFunction() {
		System.out.println("CHOOSE FROM THE BELOW OPTIONS TO START");
		System.out.println("1. ADMIN LOGIN");
		System.out.println("2. BANK EMPLOYEE LOGIN");
		System.out.println("3. CUSTOMER LOGIN");

		Scanner s = new Scanner(System.in);
		bankingOptions = s.nextInt();
		s.nextLine();

		if (bankingOptions == 1) {
			ValidateAdmin va = new ValidateAdmin();
			va.takeAdminCredentials();
		}

		else if (bankingOptions == 2) {
			ValidateEmployee ve = new ValidateEmployee();
			ve.takeEmployeeCredentials();

		}

		else if (bankingOptions == 3) {
			ValidateCustomer vc = new ValidateCustomer();
			vc.takeCustomerCredentials();
		}

		else {
			System.out.println("Read the Options Carefully\n\n");
			bankinOptionFunction();
		}

	}

}

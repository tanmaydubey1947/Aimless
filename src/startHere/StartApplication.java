package startHere;

public class StartApplication {

	public static void main(String[] args) {

		BankingLogo printit = new BankingLogo();
		printit.printLogo();

		ChooseBankingOptions cbo = new ChooseBankingOptions();
		cbo.bankinOptionFunction();

	}

}

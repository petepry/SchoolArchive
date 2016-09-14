package zad1;

public class Account {
	
	private double balance;
	private static double INTEREST_RATE;

	public Account(){
		balance = 0.0;
	}
	
	public void deposit(double i) {
		if (i <= 0)
			;
		else
			balance += i;
	}

	public void transfer(Account account, double i) {
		if (i <= 0 || i > balance)
			;
		else{
			balance -= i;
			account.balance += i;
		}
	}

	public void withdraw(double i) {
		if (i <= 0 || i > balance)
			;
		else
			balance -= i;
		
	}

	public static void setInterestRate(double d) {
		INTEREST_RATE = d/100;
		
	}

	public void addInterest() {
		if (INTEREST_RATE <= 0)
			;
		else
			balance += balance*INTEREST_RATE;
	}
	
	public double getBalance(){
		return balance;
	}

}

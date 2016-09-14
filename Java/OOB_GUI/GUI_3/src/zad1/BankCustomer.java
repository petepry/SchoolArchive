package zad1;

public class BankCustomer extends Person {
	
	private Account balance;

	public BankCustomer(Person name) {
		super(name.getName());
		balance = new Account();
	}

	public Account getAccount() {
		return balance;
	}
	
	public String toString(){
		return "Klient: " + this.getName() + " stan konta " + this.getAccount().getBalance();
	}
}

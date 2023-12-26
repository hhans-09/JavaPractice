package testFramework.udemyQuestions;

public class accountInformation {
	
	private long balance;
	
	public accountInformation() {
		this.balance = 0;
	} 
	
	public boolean deposit(long amount) {
		if(amount >= 0) {
			this.balance += amount;
			return true;
		}
		
		return false;
	}
	
	public boolean withdraw(long amount) {
		if(amount >= 0) {
			this.balance -= amount;
			return true;
		}
		
		return false;
	}
	
	public boolean checkBalance() {
		
		if(getBalance() >= 0) {
			return true;
		}
		
		return false;
		
	}
	
	public long getBalance() {
		return balance;
	}

}

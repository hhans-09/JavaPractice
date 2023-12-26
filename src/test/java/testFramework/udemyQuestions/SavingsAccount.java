package testFramework.udemyQuestions;


import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.junit.rules.TestName;

/*
 * 
 * Business Requirements:
    Deposit and withdraw methods will not accept negative amount
	Deposit and withdraw methods return correct results
	Withdrawing more than available balance is not allowed
	Withdrawing full available balance is allowed

 * 
 * Test Approach :
 * input : account number / deposit amount /withdraw amount
 * Output : deposit/withdraw status, account balance 
 * Expected : if deposit success, then return return success 
 * if withdraw amount <= account balance, then withdraw successful
 * if withdraw amount > account balance, then withdraw failed
 * 
 * Test cases :
 * Deposit with positive amount ( 100) -> deposit successful
 * Deposit or Withdraw with negative amount ( -350) -> deposit error
 * Withdraw amount(100) less than available balance(2000), withdraw successful
 * Withdraw amount(1000) more than available balance(200), withdraw failed
 * Withdraw amount(1000) equal to available balance(1000), withdraw successful
 * 
 * 
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SavingsAccount {
	
	long AccountNumber;
	double depositAmount;
	double withdrawAmount;
	double accountBalance;

	@Before
	public void setInitialAccountBalance() {
		accountBalance = 1000.00;
		
	}
	
	
	public double getAccountBalance(long AccountNumber) {
		
		return accountBalance;	
	}
	
	public void setUpdateAccountBalance(long AccountNumber, double accountBalance) {
		
		this.accountBalance = accountBalance ;
		
	}
	
	
	
	public boolean DeposittoAccount(long AccountNumber, double depositAmount) {
		
		
		if(depositAmount < 0) {
			System.out.println("Can not deposit incorrect amount of : " + depositAmount);
			
			return false;
		}  else {
			
			System.out.println("Available Balance in account "+AccountNumber+ " is :" + getAccountBalance(AccountNumber));
			System.out.println("Deposit amount is: "+ depositAmount);
			
			accountBalance += depositAmount;
			setUpdateAccountBalance(AccountNumber, accountBalance);
			
			System.out.println("Available Balance in account "+AccountNumber+ " is :" + accountBalance);
			
			return true;
		}
		
		
	}
	
	public boolean WithdrawfromAccount(long AccountNumber, double withdrawAmount) {
		
		
		if(withdrawAmount < 0) {
			System.out.println("Can not withdraw incorrect amount of : " + withdrawAmount);
			
			return false;
		}  
		
		double accountBalance = getAccountBalance(AccountNumber);
		if(withdrawAmount <= accountBalance) {
			
			System.out.println("Available Balance in account "+AccountNumber+ " is :" + getAccountBalance(AccountNumber));
			System.out.println("Withdrawl amount is: "+ withdrawAmount);
			
			accountBalance -= withdrawAmount;
			
			setUpdateAccountBalance(AccountNumber, accountBalance);
			System.out.println("Available Balance in account "+AccountNumber+ " after withdrawing " + withdrawAmount+" is :" + accountBalance);
			
			return true;
		} else {
			System.out.println("Withdrawing " + withdrawAmount +" more than available balance "+ getAccountBalance(AccountNumber)+" is not allowed");
			return false;
		}
		
	}
	
	@Test
	public void testValidDepositAndWithdraw() {
		
		AccountNumber = 1266883009;
		depositAmount = 200;
		withdrawAmount = 100;
		
		try {
		boolean depositStatus = DeposittoAccount(AccountNumber, depositAmount);
		Assert.assertTrue(depositStatus);
		Assert.assertEquals(1200.0, getAccountBalance(AccountNumber), 0.001);
		
		
		boolean withDrawStatus = WithdrawfromAccount(AccountNumber,withdrawAmount);
		Assert.assertTrue(withDrawStatus);
		Assert.assertEquals(1100.0, getAccountBalance(AccountNumber), 0.001);
		}
		catch(AssertionError e) {
			System.out.println("Test Case failed");
			Assert.fail();
		}
		
	}
	
	@Test
	public void testInvalidDepositAndWithdraw() {
		
		AccountNumber = 1266883009;
		depositAmount = -200;
		withdrawAmount = -100;
		
		
		try {
		boolean depositStatus = DeposittoAccount(AccountNumber, depositAmount);
		Assert.assertFalse(depositStatus);
		
		boolean withDrawStatus = WithdrawfromAccount(AccountNumber,withdrawAmount);
		Assert.assertFalse(withDrawStatus);
		System.out.println("Test Case passed");
		}
		catch(AssertionError e) {
			System.out.println("Test Case failed");
			Assert.fail();
		}
		
		
	}
	
	@Test
	public void testWithdrawLessThanBalance() {
		
		AccountNumber = 1266883009;
		depositAmount = 200;
		withdrawAmount = 800;
		
		try {
		boolean depositStatus = DeposittoAccount(AccountNumber, depositAmount);
		Assert.assertTrue(depositStatus);
		
		boolean withDrawStatus = WithdrawfromAccount(AccountNumber,withdrawAmount);
		Assert.assertTrue(withDrawStatus);
		System.out.println("Test Case passed");
		}
		catch(AssertionError e) {
			System.out.println("Test Case failed");
			Assert.fail();
		}
		
		
	}
	
	@Test
	public void testWithdrawEqualtoBalance() {
		
		AccountNumber = 1266883009;
		depositAmount = 500;
		
		try {
		boolean depositStatus = DeposittoAccount(AccountNumber, depositAmount);
		Assert.assertTrue(depositStatus);
		
		withdrawAmount = getAccountBalance(AccountNumber);
		
		boolean withDrawStatus = WithdrawfromAccount(AccountNumber,withdrawAmount);
		Assert.assertTrue(withDrawStatus);
		System.out.println("Test Case passed");
		
		}
		catch(AssertionError e) {
			System.out.println("Test Case failed");
			Assert.fail();
		}
		
	}
	
	@Test
	public void testWithdrawMoreThanBalance() {
		
		AccountNumber = 1266883009;
		depositAmount = 500;
		withdrawAmount = 2000;
		
		try {
		boolean depositStatus = DeposittoAccount(AccountNumber, depositAmount);
		Assert.assertTrue(depositStatus);
		
		
		boolean withDrawStatus = WithdrawfromAccount(AccountNumber,withdrawAmount);
		Assert.assertFalse(withDrawStatus);
		System.out.println("Test Case passed");
		
		}
		catch(AssertionError e) {
			System.out.println("Test Case failed");
			Assert.fail();
		}
		
	}
		
	
		
		

}

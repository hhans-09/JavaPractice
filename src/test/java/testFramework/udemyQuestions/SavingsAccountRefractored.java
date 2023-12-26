package testFramework.udemyQuestions;


import org.junit.After;
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
public class SavingsAccountRefractored {
	
	long AccountNumber;
	long depositAmount;
	long withdrawAmount;
	long accountBalance;
	boolean allowed;
	
	accountInformation account;
	
	
	@Rule
	public TestName name = new TestName();
	
	@Before
	public void beforeTest() {
		System.out.println("** Run Test: "+ name.getMethodName());
		account = new accountInformation();
	}
	
	@After
	public void afterTest() {
		System.out.println("** test run completed: "+ name.getMethodName());
		System.out.println();
	}
	
	
	
	
	@Test
	public void test01ValidDepositAndWithdraw() {
		
		
		try {
			depositAmount = 200;
			withdrawAmount = 100;
			
			System.out.println("Deposit amount : "+ depositAmount);
			account.deposit(200);
			System.out.println("Balance after deposit : "+ account.getBalance());
			
			System.out.println("Withdraw amount : "+ withdrawAmount);
			account.withdraw(withdrawAmount);
			System.out.println("Balance after withdraw : "+ account.getBalance());
			
			Assert.assertEquals(100, account.getBalance());
			System.out.println("Test Case Passed");
		
		}
		catch(AssertionError e) {
			System.out.println("Test Case failed");
			Assert.fail();
		}
		
	}
	
	@Test
	public void test02NegativeDepositAndWithdraw() {
		
		
		try {
			depositAmount = -200;
			withdrawAmount = -100;
			
			System.out.println("Deposit amount : "+ depositAmount);
			account.deposit(depositAmount);
			System.out.println("Balance after deposit : "+ account.getBalance());
			
			System.out.println("Withdraw amount : "+ withdrawAmount);
			account.withdraw(withdrawAmount);
			System.out.println("Balance after withdraw : "+ account.getBalance());
			
			Assert.assertEquals(0, account.getBalance());
			System.out.println("Test Case Passed");
		
		}
		catch(AssertionError e) {
			System.out.println("Test Case failed");
			Assert.fail();
		}
		
	}
	
	
	@Test
	public void test03WithdrawEqualtoBalance() {
		
		
		try {
			depositAmount = 200;
			withdrawAmount = 200;
			
			System.out.println("Deposit amount : "+ depositAmount);
			account.deposit(200);
			System.out.println("Balance after deposit : "+ account.getBalance());
			
			System.out.println("Withdraw amount : "+ withdrawAmount);
			account.withdraw(withdrawAmount);
			System.out.println("Balance after withdraw : "+ account.getBalance());
			
			
			
			allowed = account.checkBalance();
			System.out.println("Allowed : "+allowed);
			
			Assert.assertTrue(allowed);
			
			System.out.println("Test Case Passed");
		
		}
		catch(AssertionError e) {
			System.out.println("Test Case failed");
			Assert.fail();
		}
		
	}
	
	@Test
	public void test04WithdrawMoreThanBalance() {
		
		
		try {
			depositAmount = 200;
			withdrawAmount = 500;
			
			System.out.println("Deposit amount : "+ depositAmount);
			account.deposit(200);
			System.out.println("Balance after deposit : "+ account.getBalance());
			
			System.out.println("Withdraw amount : "+ withdrawAmount);
			account.withdraw(withdrawAmount);
			System.out.println("Balance after withdraw : "+ account.getBalance());
			
			
			
			allowed = account.checkBalance();
			System.out.println("Allowed : "+allowed);
			
			Assert.assertFalse(allowed);
			
			System.out.println("Test Case Passed");
		
		}
		catch(AssertionError e) {
			System.out.println("Test Case failed");
			Assert.fail();
		}
		
	}
			

}

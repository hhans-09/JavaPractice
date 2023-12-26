package testFramework.CreditCardCashback;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import org.junit.Assert;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CreditCardTransactionsTest extends baseTest{
	
	
	@Test
	public void test01CashbackEligibility_LessThanTenTransactions() {
		
		try {
		testData_LessThanTenTransactions();
		
		int actual = creditCardTransactions.getTransactions_eligibleForCashBack();
		int expected = 3;
		
		Assert.assertEquals(actual, expected);
		System.out.println("Test case Passed");
		}
		catch(AssertionError e) {
			System.out.println("Test case Failed");
			Assert.fail();
		}
	}
	
	@Test
	public void test02CashbackAmount_LessThanTenTransactions() {
		
		try {
		testData_LessThanTenTransactions();
		
		Double amount = creditCardTransactions.getProcessCashback();
		Double  expected = 2.42;
		
		Assert.assertEquals(amount, expected);
		System.out.println("Test case Passed");
		}
		catch(AssertionError e) {
			System.out.println("Test case Failed");
			Assert.fail();
		}
	}
	
	@Test
	public void test03CashbackEligibility_MoreThanTenTransactions() {
		
		try {
			testData_MoreThanTenTransactions();
		
		int actual = creditCardTransactions.getTransactions_eligibleForCashBack();
		int expected = 5;
		
		Assert.assertEquals(actual, expected);
		System.out.println("Test case Passed");
		}
		catch(AssertionError e) {
			System.out.println("Test case Failed");
			Assert.fail();
		}
	}
	
	@Test
	public void test04CashbackAmount_MoreThanTenTransactions() {
		
		try {
			testData_MoreThanTenTransactions();
		
		Double amount = creditCardTransactions.getProcessCashback();
		Double  expected = 7.16;
		
		Assert.assertEquals(amount, expected);
		System.out.println("Test case Passed");
		}
		catch(AssertionError e) {
			System.out.println("Test case Failed");
			Assert.fail();
		}
	}
	
	@Test
	public void test05CashbackEligibility_EqualToTenTransactions() {
		
		try {
			testData_EqualToTenTransactions();
		
		int actual = creditCardTransactions.getTransactions_eligibleForCashBack();
		int expected = 3;
		
		Assert.assertEquals(actual, expected);
		System.out.println("Test case Passed");
		}
		catch(AssertionError e) {
			System.out.println("Test case Failed");
			Assert.fail();
		}
	}
	
	@Test
	public void test06CashbackAmount_EqualToTenTransactions() {
		
		try {
			testData_EqualToTenTransactions();
		
		Double amount = creditCardTransactions.getProcessCashback();
		Double  expected = 2.42;
		
		Assert.assertEquals(amount, expected);
		System.out.println("Test case Passed");
		}
		catch(AssertionError e) {
			System.out.println("Test case Failed");
			Assert.fail();
		}
	}

}

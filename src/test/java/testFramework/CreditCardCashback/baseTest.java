package testFramework.CreditCardCashback;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;

public class baseTest {
	
	CreditCardTransactions creditCardTransactions;
	
	@Rule
	public TestName name = new TestName();
	
	@Before
	public void beforeTest(){
		System.out.println("Test case name: "+name.getMethodName());
		
		creditCardTransactions = new CreditCardTransactions();
		
		creditCardTransactions.setCashbackPercentageStandard(1.00);
		creditCardTransactions.setCashbackPercentageEnhanced(2.00);
		creditCardTransactions.setCashbackEligibilityTxStandardAmount(50);
		creditCardTransactions.setCashbackEligibilityTxEnchancedCount(10);
		
	}
	
	@After
	public void afterTest(){
		
		System.out.println("Test completed: "+name.getMethodName());
		System.out.println();
		
	}
	
	
	public void testData_LessThanTenTransactions() {
		creditCardTransactions.setTransactions(1, 51.22); //eligible
		creditCardTransactions.setTransactions(2, 19.90);
		creditCardTransactions.setTransactions(3, 10.00);
		creditCardTransactions.setTransactions(4, 45.00);
		creditCardTransactions.setTransactions(5, 90.23); //eligible
		creditCardTransactions.setTransactions(6, 100.45); //eligible
		creditCardTransactions.setTransactions(7, 23.08);
		creditCardTransactions.setTransactions(8, 50.0); //Not eligible
		creditCardTransactions.setTransactions(9, 49.00);
		
		
	}
	
	public void testData_MoreThanTenTransactions() {
		creditCardTransactions.setTransactions(1, 51.22); //eligible
		creditCardTransactions.setTransactions(2, 19.90);
		creditCardTransactions.setTransactions(3, 10.00);
		creditCardTransactions.setTransactions(4, 45.00);
		creditCardTransactions.setTransactions(5, 90.23); //eligible
		creditCardTransactions.setTransactions(6, 100.45); //eligible
		creditCardTransactions.setTransactions(7, 23.08);
		creditCardTransactions.setTransactions(8, 50.0); //Not eligible
		creditCardTransactions.setTransactions(9, 49.99);
		creditCardTransactions.setTransactions(10, 49.99);
		creditCardTransactions.setTransactions(11, 50.02); //eligible
		creditCardTransactions.setTransactions(12, 65.89); //eligible
		
	}
	
	public void testData_EqualToTenTransactions() {
		creditCardTransactions.setTransactions(1, 51.22); //eligible
		creditCardTransactions.setTransactions(2, 19.90);
		creditCardTransactions.setTransactions(3, 10.00);
		creditCardTransactions.setTransactions(4, 45.00);
		creditCardTransactions.setTransactions(5, 90.23); //eligible
		creditCardTransactions.setTransactions(6, 100.45); //eligible
		creditCardTransactions.setTransactions(7, 23.08);
		creditCardTransactions.setTransactions(8, 50.0); //Not eligible
		creditCardTransactions.setTransactions(9, 49.99);
		creditCardTransactions.setTransactions(10, 49.99);
		
		
	}
	
}

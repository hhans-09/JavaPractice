package testFramework.ExchangeRates;

import org.junit.Assert;
import org.junit.Test;

public class ExchangeRatesTest extends BaseTest{
	
	@Test
	public void test01BaseCurrencyGBP() {
		System.out.println("Test case 01 - BaseCurrency is GBP");
		
		double expectedGBP = 1.0;
		
		double gbp = getCurrencyValue("GBP");
		System.out.println("base currency value is : " + gbp);
		
		Assert.assertEquals(expectedGBP, gbp, 0.0);
		System.out.println("Test case passed\n");
		
	}
	
	
	@Test
	public void test01NonBaseCurrencyValue() {
		System.out.println("Test case 02 - Non-Base Currency is USD");
		
		double usd = getCurrencyValue("USD");
		System.out.println("Non base currency value is : " + usd);
		
		Assert.assertTrue(usd>1.0);
		System.out.println("Test case passed\n");
		
	}

}


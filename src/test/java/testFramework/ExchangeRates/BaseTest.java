package testFramework.ExchangeRates;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;

public class BaseTest {
	
	Map<String,Double> currencies;
	ExchangeRates exchange;
	
	
	@Before
	public void beforeTest() {
		exchange = new ExchangeRates();
		
		exchange.setBaseCurrency("GBP");
		exchange.setEUR(1.2);
		exchange.setGBP(1.0);
		exchange.setUSD(1.5);
		
		setCurrencyValueMap();
		
	}
	
	public void setCurrencyValueMap() {
		
		currencies = new HashMap<String,Double>();
		
		currencies.put("GBP", exchange.getGBP());
		currencies.put("USD", exchange.getUSD());
		currencies.put("EUR", exchange.getEUR());
		
		
		
	}
	
	public double getCurrencyValue(String currency) {
		
		double currencyValue = currencies.get(currency);
		return currencyValue;
		
	}

}

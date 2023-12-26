package testFramework.CreditCardCashback;

import java.util.HashMap;
import java.util.Map;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class CreditCardTransactions {

	private Double cashbackPercentageStandard;
	private Double cashbackPercentageEnhanced;
	private int cashbackEligibilityTxStandardAmount;
	private int cashbackEligibilityTxEnchancedCount;
	private int countEligibileTransactions;
	
	
	public CreditCardTransactions() {
		countEligibileTransactions = 0;
	}

	public Double getCashbackPercentageStandard() {
		return cashbackPercentageStandard;
	}

	public void setCashbackPercentageStandard(Double cashbackPercentageStandard) {
		this.cashbackPercentageStandard = cashbackPercentageStandard;
	}

	public Double getCashbackPercentageEnhanced() {
		return cashbackPercentageEnhanced;
	}

	public void setCashbackPercentageEnhanced(Double cashbackPercentageEnhanced) {
		this.cashbackPercentageEnhanced = cashbackPercentageEnhanced;
	}

	public int getCashbackEligibilityTxEnchancedCount() {
		return cashbackEligibilityTxEnchancedCount;
	}

	public void setCashbackEligibilityTxEnchancedCount(int cashbackEligibilityTxEnchancedCount) {
		this.cashbackEligibilityTxEnchancedCount = cashbackEligibilityTxEnchancedCount;
	}
	
	public int getCashbackEligibilityTxStandardAmount() {
		return cashbackEligibilityTxStandardAmount;
	}

	public void setCashbackEligibilityTxStandardAmount(int cashbackEligibilityTxStandardAmount) {
		this.cashbackEligibilityTxStandardAmount = cashbackEligibilityTxStandardAmount;
	}

	
	public boolean isTransactionValue_greaterThan_CashbackEligibilityTransactionAmountStandard(Double transactionAmount) {
		
		if(transactionAmount > getCashbackEligibilityTxStandardAmount()) {
			return true;
		} else {
			return false;
		}
		
	}
	
	 Map<Integer,Double> transactionsDetails = new HashMap<Integer,Double>();
	public void setTransactions(int transactionCount, Double transactionAmount) {
		transactionsDetails.put(transactionCount, transactionAmount);
		
	}
	
	public Map<Integer, Double> getTransactions() {
		return transactionsDetails;
	}
	
	public int getTransactionsCount() {
		return transactionsDetails.size();
	}
	
	public int getTransactions_eligibleForCashBack() {
		
		Map<Integer,Double> transaction = getTransactions();
		
		for(Integer trans : transaction.keySet()) {
			Double value = transaction.get(trans);
			
			System.out.println("Transaction value :"+value);
			
			if(isTransactionValue_greaterThan_CashbackEligibilityTransactionAmountStandard(value)) {
				countEligibileTransactions++;
				
			}
		}
		
		System.out.println("Count of eligible Transactions for cashback :"+countEligibileTransactions);
		
		return countEligibileTransactions;
		
	}
	
	public Double getProcessCashback() {
		
		int transactionCount = getTransactionsCount();
		Double cashbackPercentage;
		Double cashbackAmount = 0.0;
		
		System.out.println("transactionCount :"+transactionCount);
		
		if(transactionCount > getCashbackEligibilityTxEnchancedCount()) {
			cashbackPercentage = getCashbackPercentageEnhanced();
		} else {
			cashbackPercentage = getCashbackPercentageStandard();		
		}
		
		System.out.println("cashbackPercentage: "+ cashbackPercentage);
		
		Map<Integer,Double> transaction = getTransactions();
		for(Integer trans : transaction.keySet()) {
			Double value = transaction.get(trans);
			
			System.out.println("Transaction value :"+value);
			
			if(isTransactionValue_greaterThan_CashbackEligibilityTransactionAmountStandard(value)) {
				Double amount = cashbackPercentage * value/ 100.00;
				cashbackAmount += amount;
				
			}
			
		}
		
		System.out.println("cashback amount : "+round(cashbackAmount,2));
		return round(cashbackAmount,2);
		
	}

	private Double round(Double value, int decimalplaces) {
		BigDecimal bd = new BigDecimal(Double.toString(value));
		bd = bd.setScale(decimalplaces, RoundingMode.HALF_UP);
		return bd.doubleValue();

	}
	
}

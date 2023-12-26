package testFramework.ConfirmationMessage;

import org.junit.Test;

import org.junit.Assert;

public class CountWordsInConfirmationMessageTest {

	CountWordsInConfirmationMessage confirmationMessage = new CountWordsInConfirmationMessage();
	String message;
	
	@Test
	public void test01MessageWithoutLeadingTrailingSpace() {
		
		message = "Loan Drawdown Transaction was successfully completed. Reference RP124232333";
		
		Object wordCount = confirmationMessage.countMessageWords(message);
		
		Assert.assertEquals(8, wordCount);
		
	}
	
	@Test
	public void test02MessageContainingNot() {
		
		message = "Loan Drawdown Transaction was not successfully completed. Reference RP124232333";
		
		Object wordCount = confirmationMessage.countMessageWords(message);
		
		Assert.assertEquals(true, wordCount);
		
	}
	
	@Test
	public void test03MessageWithLeadingTrailingSpace() {
		
		message = " Loan Drawdown Transaction was successfully completed. Reference RP124232333 ";
		
		Object wordCount = confirmationMessage.countMessageWords(message);
		
		Assert.assertEquals(8, wordCount);
		
	}
	
	@Test
	public void test04MessageWithSpaceOnly() {
		
		message = "   ";
		
		Object wordCount = confirmationMessage.countMessageWords(message);
		
		Assert.assertEquals(0, wordCount);
		
	}
	
	@Test
	public void test05MessageisEmpty() {
		
		message = "";
		
		Object wordCount = confirmationMessage.countMessageWords(message);
		
		Assert.assertEquals(0, wordCount);
		
	}
	
	@Test
	public void test06MessageisNull() {
		
		message = null;
		
		Object wordCount = confirmationMessage.countMessageWords(message);
		
		Assert.assertEquals(0, wordCount);
		
	}
	
}

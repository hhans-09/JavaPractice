package testFramework.udemyQuestions;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Before;
import org.junit.Test;

import org.junit.Assert;

/*
 * * Application: Sign up for an Email account
* Feature: Email ID availability Checker
* Valid Input: Email ID 
    [allowed characters: AlphaNumeric, .(dot) and _(under score)]     
    [Example ID: Tim123._ (NOTE: Ignore domain name @outlook.com for validation)]
* Expected Outcome Messages:
   Create a password (if email ID is available),
   Someone already has this email address (if email ID is NOT available),
   Enter the email address in valid format (when an invalid email ID is entered)


 * 
 * Email IDs NOT Available for registration = Tim, Tim123, Tim123.Smith, Tim123._

 * 
 */

public class EmailIDValidation {
	
	String EmailID;
	List<String> EmailIDNotAvailable;
	String allowedEmailID;
	
	Pattern pattern;
	Matcher matcher;
	String ExpectedOutput;
	
	
	@Before
	public void setUp() {
		
		EmailIDNotAvailable = new ArrayList<String>();
		EmailIDNotAvailable.add("Tim");
		EmailIDNotAvailable.add("Tim123");
		EmailIDNotAvailable.add("Tim123._");
		EmailIDNotAvailable.add("Tim123.Smith");
		
		
		allowedEmailID = "(^([a-zA-z0-9._]+)$)";
		
	}
	
	public boolean getPatternMatch(String EmailID, String allowedEmailID) {
		pattern = Pattern.compile(allowedEmailID);
		matcher = pattern.matcher(EmailID);
	
		return matcher.matches();
	}
	
	public String checkEmailAvailability(String EmailID) {
		
		String actualOutput;
		
		if(EmailIDNotAvailable.contains(EmailID)) {
			actualOutput = "Someone already has this email address";
			
		} else if(getPatternMatch(EmailID,allowedEmailID)) {
			actualOutput = "Create a password";
		} else {
			actualOutput = "Enter the email address in valid format";
		}
		
		return actualOutput;
	}
	
	
	public void testMethod(String EmailID, String ExpectedOutput) {
		
		try {
		String actualOutput = checkEmailAvailability(EmailID);
		System.out.println(actualOutput);
		
		Assert.assertEquals(actualOutput, ExpectedOutput);
		System.out.println("Test Case Passed");
		}
		catch(AssertionError e) {
			System.out.println("Test Case Failed");
			Assert.fail();
			
		}
		
	}
	
	@Test
	public void testValidEmailID() {
		
		EmailID = "Tim1234._";
		ExpectedOutput = "Create a password";
		testMethod(EmailID, ExpectedOutput);
	
	}
	
	@Test
	public void testValidUsedEmailID() {

		EmailID = "Tim";
		ExpectedOutput = "Someone already has this email address";
		testMethod(EmailID, ExpectedOutput);
	
	}
	
	@Test
	public void testInvalidEmailIDWithSpace() {
		
		EmailID = "Tim Smith";
		ExpectedOutput = "Enter the email address in valid format";
		testMethod(EmailID, ExpectedOutput);
	
	}
	
	@Test
	public void testInvalidEmailID() {
		EmailID = "";
		ExpectedOutput = "Enter the email address in valid format";
		testMethod(EmailID, ExpectedOutput);
	
	}
	
}


